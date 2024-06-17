package com.team13.fantree.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EmailCheckRequestDto {

	@NotEmpty(message = "인증 번호를 입력해 주세요")
	private String authNum;

}