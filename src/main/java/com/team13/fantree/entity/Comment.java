package com.team13.fantree.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends Timestamped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 게시물 ID
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "posts_id")
	private Post post;

	// 작성자 ID
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id")
	private User user;

	private String content;

	private Long likeCount;

	public Comment(Post post, User user, String content) {
		this.post = post;
		this.user = user;
		this.content = content;
		// this.likeCount = (long) (Math.random()* 1_000_000); //좋아요 조작
		this.likeCount = 0L;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void UpLikeCount() {
		likeCount++;
	}
}
