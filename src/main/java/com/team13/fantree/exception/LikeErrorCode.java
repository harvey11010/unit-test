package com.team13.fantree.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum LikeErrorCode implements ErrorCode {
	LIKE_NOT_FOUND(HttpStatus.NOT_FOUND,
		"좋아요가 없습니다."),
	SELF_LIKE(HttpStatus.NOT_ACCEPTABLE,
		"자신의 글/댓글에 좋아요 사용 불가"),
	DUPLICATE_LIKE(HttpStatus.NOT_ACCEPTABLE,
		"좋아요는 한번만 가능합니다."),
	USER_MISMATCH(HttpStatus.NOT_ACCEPTABLE,
		"유저와 좋아요가 일치하지 않습니다."),
	CONTENT_TYPE_MISMATCH(HttpStatus.NOT_ACCEPTABLE,
		"컨텐츠 타입이 일치하지 않습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}


