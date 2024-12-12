package com.ssafy.abctrip.exception;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private final int status;
    private final String message;
}