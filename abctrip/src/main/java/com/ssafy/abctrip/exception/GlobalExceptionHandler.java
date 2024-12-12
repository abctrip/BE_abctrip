package com.ssafy.abctrip.exception;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UnAuthorizedException.class)
	public ResponseEntity<ErrorResponse> handleUnauthorized(UnAuthorizedException e) {
		log.error("Unauthorized error: ", e);
		return createErrorResponse(HttpStatus.UNAUTHORIZED, e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(Exception e) {
		log.error("Internal server error: ", e);
		return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류가 발생했습니다");
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException e) {
		log.error("Invalid argument: ", e);
		return createErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException e) {
		log.error("Validation error: ", e);
		return createErrorResponse(HttpStatus.BAD_REQUEST, "입력값이 올바르지 않습니다");
	}

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ErrorResponse> handleSQLException(SQLException e) {
	   log.error("Database error: ", e);
	   return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "데이터베이스 오류가 발생했습니다");
	}
	
	private ResponseEntity<ErrorResponse> createErrorResponse(HttpStatus status, String message) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(status.value(), message), status);
	}
}