package com.team13.fantree.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User extends Timestamped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, unique = true)
	private String username;

	private String password;

	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	private String headline;

	@Enumerated(EnumType.STRING)
	private UserStatusEnum status;

	private String refreshToken;

	private LocalDateTime statusUpdate;

	@Builder
	public User(String username, String password, String name, String email, String headline) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.headline = headline;
		this.status = UserStatusEnum.NOAUTH_USER;
	}

	public void withDraw() {
		this.status = UserStatusEnum.NON_USER;
		this.statusUpdate = this.getModifiedAt();
		this.refreshToken = null;
	}

	public void logout() {
		refreshToken = null;
	}

	public void update(Optional<String> name, Optional<String> headline, Optional<String> newEncodePw) {
		this.name = name.orElse(this.name);
		this.headline = headline.orElse(this.headline);
		this.password = newEncodePw.orElse(this.password);
	}

	public void userStatusUpdate() {
		this.status = UserStatusEnum.USER;
		this.statusUpdate = this.getModifiedAt();
	}

	public void saveRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}
