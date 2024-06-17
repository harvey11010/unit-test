package com.team13.fantree.entity;

import com.team13.fantree.exception.LikeErrorCode;
import com.team13.fantree.exception.MismatchException;
import lombok.Getter;

import java.util.Objects;

@Getter
public enum ContentEnumType {
	POST("post"), COMMENT("comment");

	private final String type;

	ContentEnumType(String type) {
		this.type = type;
	}

	public static ContentEnumType getByType(String type) {
		if (Objects.equals(type, POST.type)) {
			return POST;
		} else if (Objects.equals(type, COMMENT.type)) {
			return COMMENT;
		} else
			throw new MismatchException(LikeErrorCode.CONTENT_TYPE_MISMATCH);
	}
}
