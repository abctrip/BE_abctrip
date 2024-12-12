package com.ssafy.abctrip.users.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.abctrip.users.model.UsersDto;
import com.ssafy.abctrip.users.model.service.UsersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController // REST API 응답을 위해 모든 메서드의 반환값을 JSON으로 변환
@RequestMapping("/user") // 공통 URL 경로 지정
@Tag(name = "회원 컨트롤러", description = "회원 가입, 로그인, 로그아웃을 처리하는 컨트롤러") // Swagger API 문서화를 위한 태그 설정
@Slf4j // 로깅을 위한 Lombok 어노테이션

public class UsersController {

	private final UsersService usersService;

	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	@Operation(summary = "회원탈퇴", description = "회원을 탈퇴한다.")
	@DeleteMapping("/remove/{userId}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable String userId) throws Exception {
		System.out.println("전달받은 값: " + userId);
		usersService.remove(userId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Operation(summary = "회원등록", description = "신규 회원을 등록한다.")
	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> register(@RequestBody UsersDto memberDto) throws Exception {
		System.out.println("전달받은 값: " + memberDto);
		usersService.register(memberDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Operation(summary = "ID중복체크", description = "회원ID 중복 체크한다.")
	@GetMapping("/check/{userId}")
	public ResponseEntity<Boolean> checkUserId(@PathVariable String userId) throws Exception {
		boolean isCheck = usersService.checkUserId(userId);
		return ResponseEntity.ok(isCheck);
	}

	@Operation(summary = "회원정보수정", description = "회원 정보를 수정한다.")
	@PutMapping("/modify")
	public ResponseEntity<Map<String, Object>> updateUserInfo(@RequestBody UsersDto memberDto) throws Exception {
		System.out.println("전달받은 값: " + memberDto);
		usersService.modify(memberDto);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Operation(summary = "로그인", description = "아이디와 비밀번호를 이용하여 로그인 처리.")
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody UsersDto memberDto) throws Exception {
		System.out.println(memberDto);
		Map<String, Object> result = usersService.login(memberDto);
		System.out.println(result);
		return ResponseEntity.ok(result);
	}

	@Operation(summary = "로그아웃", description = "회원 정보를 담은 Token 을 제거한다.")
	@GetMapping("/logout/{userId}")
	public ResponseEntity<Map<String, Object>> removeToken(@PathVariable String userId) throws Exception {
		usersService.deleRefreshToken(userId);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "회원인증", description = "회원 정보를 담은 Token 을 반환한다.")
	@GetMapping("/info/{userId}")
	public ResponseEntity<Map<String, Object>> userInfo(@PathVariable String userId,
			@RequestHeader("accessToken") String token) throws Exception {
		Map<String, Object> result = usersService.userInfo(userId, token);
		return ResponseEntity.ok(result);
	}

	@Operation(summary = "Access Token 재발급", description = "만료된 access token 을 재발급 받는다.")
	@PostMapping("/refresh")
	public ResponseEntity<Map<String, Object>> refreshToken(@RequestBody UsersDto memberDto,
			@RequestHeader("refreshToken") String token) throws Exception {
		Map<String, Object> result = usersService.getRefreshToken(memberDto, token);
		return ResponseEntity.ok(result);
	}

	@Operation(summary = "password-reset 이메일 요청", description = "초기화된 패스워드를 사용자 이메일로 보낸다.")
	@PostMapping("/passwordReset")
	public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) throws Exception {
		String email = request.get("email");
		String tempPassword = UUID.randomUUID().toString().substring(0, 8);
		
		usersService.updatePassword(email, tempPassword);
		usersService.sendPasswordResetMail(email, tempPassword);

		return ResponseEntity.ok().body("비밀번호 초기화 메일이 발송되었습니다.");
	}
}