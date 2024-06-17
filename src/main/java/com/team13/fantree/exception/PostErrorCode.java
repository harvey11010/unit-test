package com.team13.fantree.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PostErrorCode implements ErrorCode {
	POST_NOT_FOUND(HttpStatus.NOT_FOUND,
		"게시글의 정보를 찾을수 없습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}


