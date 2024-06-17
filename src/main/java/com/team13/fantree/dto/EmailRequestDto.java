package com.team13.fantree.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequestDto {
	@Email
	@NotNull
	private String email;
}