package com.ssafy.abctrip.users.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.abctrip.users.model.UsersDto;

@Mapper
public interface UsersMapper {

	// 1. 기본 인증
	void register(UsersDto usersDto) throws SQLException;
	UsersDto login(UsersDto usersDto) throws SQLException;
	UsersDto userInfo(String userId) throws SQLException;
	boolean checkUserId(String userId) throws SQLException;
	
	// 2. 회원 정보 관리
	void modify(UsersDto usersDto) throws SQLException;
	void remove(String userId) throws SQLException;

	// 3. 토큰 관리
	void saveRefreshToken(Map<String, String> map) throws SQLException;
	String getRefreshToken(String userid) throws SQLException;
	void deleteRefreshToken(Map<String, String> map) throws SQLException;
	
	// 4. 임시 비밀번호로 변경
	int updatePassword(Map<String, Object> map);
}