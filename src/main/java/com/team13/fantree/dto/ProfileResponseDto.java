package com.team13.fantree.dto;

import com.team13.fantree.entity.User;
import lombok.Getter;

@Getter
public class ProfileResponseDto {
	private final String username;
	private final String name;
	private final String email;
	private final String headline;

	public ProfileResponseDto(User user) {
		this.username = user.getUsername();
		this.name = user.getName();
		this.email = user.getEmail();
		this.headline = user.getHeadline();
	}

}
