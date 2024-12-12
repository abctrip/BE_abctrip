package com.ssafy.abctrip.users.model;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor  // 기본 생성자
@ToString
@Schema(description = "회원 정보")
public class UsersDto {

	@Schema(description = "회원 아이디")
	private String userId;

	@Schema(description = "회원 이름")
	private String userName;

	@Schema(description = "회원 닉네임")
	private String nickName;
	
	@Schema(description = "비밀번호")
	private String userPwd;

	@Schema(description = "이메일 아이디")
	private String emailId;

	@Schema(description = "이메일 도메인")
	private String emailDomain;

	@Schema(description = "리프레시 토큰")
	private String refreshToken;
	
	@Schema(description = "회원 권한")
	private int userRole;
	
	@Schema(description = "가입일")
	private String createdAt;
	
	@Schema(description = "수정일")
	private String updatedAt;	
}