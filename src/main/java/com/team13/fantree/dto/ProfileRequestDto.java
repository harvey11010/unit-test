package com.team13.fantree.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class ProfileRequestDto {
	private String password;

	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{10,}$",
		message = "대소문자 포함 영문 + 숫자 + 특수문자를 최소 1글자씩 포함, 최소 10글자 이상")
	private String newPassword;

	private String name;

	private String headline;
}
