package com.ssafy.abctrip.users.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.ssafy.abctrip.users.model.UsersDto;
import com.ssafy.abctrip.users.model.mapper.UsersMapper;
import com.ssafy.abctrip.util.JWTUtil;
import com.ssafy.abctrip.exception.UnAuthorizedException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

	@Value("${spring.mail.username}")
	private String from;

	private final UsersMapper usersMapper;
	private final JWTUtil jwtUtil;
	private final JavaMailSender mailSender;

	// 1. 기본 인증
	@Override
	public void register(UsersDto usersDto) throws Exception {
		usersMapper.register(usersDto);
	}

	@Override
	public boolean checkUserId(String userId) throws Exception {
		return usersMapper.checkUserId(userId);
	}

	@Override
	public Map<String, Object> login(UsersDto usersDto) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		UsersDto loginUser = usersMapper.login(usersDto);

		if (loginUser == null) {
			throw new UnAuthorizedException("Invalid credentials");
		}

		String accessToken = jwtUtil.createAccessToken(loginUser.getUserId());
		String refreshToken = jwtUtil.createRefreshToken(loginUser.getUserId());
		saveRefreshToken(loginUser.getUserId(), refreshToken);

		resultMap.put("access-token", accessToken);
		resultMap.put("refresh-token", refreshToken);
		return resultMap;
	}

	@Override
	public Map<String, Object> userInfo(String userId, String token) throws Exception {
		if (!jwtUtil.checkToken(token)) {
			throw new UnAuthorizedException("Invalid token");
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("userInfo", usersMapper.userInfo(userId));
		return resultMap;
	}

	// 2. 회원 정보 관리
	@Override
	public void modify(UsersDto usersDto) throws Exception {
		usersMapper.modify(usersDto);
	}

	@Override
	public void remove(String userId) throws Exception {
		// 관리자 계정 탈퇴 방지
		UsersDto user = usersMapper.userInfo(userId);
		if (user.getUserRole() == 1) {
			throw new IllegalArgumentException("관리자 계정은 개발자한테 문의 바람.");
		}
		usersMapper.remove(userId);
	}

	// 3. 토큰 관리
	@Override
	public void saveRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("userId", userId);
		map.put("refreshToken", refreshToken);
		usersMapper.saveRefreshToken(map);
	}

	@Override
	public String getRefreshToken(String userId) throws Exception {
		return usersMapper.getRefreshToken(userId);
	}

	@Override
	public void deleRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("userId", userId);
		map.put("token", null);
		usersMapper.deleteRefreshToken(map);
	}

	@Override
	public Map<String, Object> getRefreshToken(UsersDto usersDto, String token) throws Exception {
		if (!jwtUtil.checkToken(token) || !token.equals(usersMapper.getRefreshToken(usersDto.getUserId()))) {
			throw new UnAuthorizedException("Invalid refresh token");
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("access-token", jwtUtil.createAccessToken(usersDto.getUserId()));
		return resultMap;
	}

	@Override
	public void sendPasswordResetMail(String email, String tempPassword) throws Exception {
		System.out.println(email);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);  // 수신자
		message.setFrom(from);  // 발신자
		message.setSubject("임시 비밀번호 발급");  // 제목
		message.setText("임시 비밀번호: " + tempPassword + "\n로그인 후 반드시 비밀번호를 변경해주세요.");  // 내용

		mailSender.send(message);  // 발송
	}

	// 임시 패스워드 발송
	@Override
	public void updatePassword(String email, String tempPassword) throws Exception {
		String[] parts = email.split("@");
		String emailId = parts[0];
		String emailDomain = parts[1];

		Map<String, Object> params = new HashMap<>();
		params.put("emailId", emailId);
		params.put("emailDomain", emailDomain);
		params.put("userPwd", tempPassword);

		System.out.println(params);
		usersMapper.updatePassword(params);
	}
}