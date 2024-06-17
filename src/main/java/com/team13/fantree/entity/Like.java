package com.team13.fantree.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "likes")
public class Like extends Timestamped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long userId;

	private long contentId;

	@Enumerated(EnumType.STRING)
	private ContentEnumType contentType;

	@Builder
	public Like(long userId, long typeId, String type) {
		this.userId = userId;
		this.contentType = ContentEnumType.getByType(type);
		this.contentId = typeId;
	}
}
