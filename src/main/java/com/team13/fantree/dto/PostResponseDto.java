package com.team13.fantree.dto;

import com.team13.fantree.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
	private final Long id;
	private final String username;
	private final String content;
	private final LocalDateTime createAt;
	private final LocalDateTime modifiedAt;
	private final Long likeCount;

	public PostResponseDto(Post post) {
		this.id = post.getId();
		this.username = post.getUser().getUsername();
		this.content = post.getContent();
		this.createAt = post.getCreatedAt();
		this.modifiedAt = post.getModifiedAt();
		this.likeCount = post.getLikeCount();
	}
}
