package com.team13.fantree.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DuplicateException extends RuntimeException {
	private final ErrorCode errorCode;
}
