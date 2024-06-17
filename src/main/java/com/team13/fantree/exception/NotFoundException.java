package com.team13.fantree.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class NotFoundException extends RuntimeException {
	private final ErrorCode errorCode;
}
