package com.team13.fantree.dto;

import com.team13.fantree.entity.ContentEnumType;
import com.team13.fantree.entity.Like;
import lombok.Getter;

@Getter
public class LikeResponseDto {
	private final long id;
	private final long userId;
	private final long contentId;
	private final ContentEnumType contentType;

	public LikeResponseDto(Like like) {
		this.id = like.getId();
		this.userId = like.getUserId();
		this.contentId = like.getContentId();
		this.contentType = like.getContentType();
	}
}
