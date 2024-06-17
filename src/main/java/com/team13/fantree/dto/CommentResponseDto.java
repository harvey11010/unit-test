package com.team13.fantree.dto;

import com.team13.fantree.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
	private final Long id;
	private final Long postId;
	private final Long userId;
	private final String content;
	private final Long likeCount;
	private final LocalDateTime createAt;
	private final LocalDateTime modifiedAt;

	public CommentResponseDto(Comment comment) {
		this.id = comment.getId();
		this.postId = comment.getPost().getId();
		this.userId = comment.getUser().getId();
		this.content = comment.getContent();
		this.likeCount = comment.getLikeCount();
		this.createAt = comment.getCreatedAt();
		this.modifiedAt = comment.getModifiedAt();
	}
}
