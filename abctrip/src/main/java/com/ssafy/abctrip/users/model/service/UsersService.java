package com.ssafy.abctrip.users.model.service;

import java.util.Map;
import com.ssafy.abctrip.users.model.UsersDto;


public interface UsersService {
	// 1. 기본 인증
	void register(UsersDto usersDto) throws Exception;
	boolean checkUserId(String userId) throws Exception;
	Map<String, Object> login(UsersDto usersDto) throws Exception;
	Map<String, Object> userInfo(String userId, String token) throws Exception;

	// 2. 회원 정보 관리
	void modify(UsersDto usersDto) throws Exception;
	void remove(String userId) throws Exception;

	// 3. 토큰 관리
	void saveRefreshToken(String userId, String refreshToken) throws Exception;
	String getRefreshToken(String userId) throws Exception;
	void deleRefreshToken(String userId) throws Exception;
	Map<String, Object> getRefreshToken(UsersDto usersDto, String token) throws Exception;
	
	// 4. 패스워드 찾기 이메일에 임시비번 보내기
	void sendPasswordResetMail(String email, String tempPassword) throws Exception;
	void updatePassword(String email, String tempPassword) throws Exception;
	
}
