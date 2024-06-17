package com.team13.fantree.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignUpException extends RuntimeException {
	private final ErrorCode errorCode;
}
