package com.team13.fantree.controller;

import com.team13.fantree.dto.EmailCheckRequestDto;
import com.team13.fantree.dto.EmailRequestDto;
import com.team13.fantree.exception.UserErrorCode;
import com.team13.fantree.security.UserDetailsImpl;
import com.team13.fantree.service.MailSendService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {
	private final MailSendService mailService;

	@PostMapping("/mailsend")
	public String mailSend(@RequestBody @Valid EmailRequestDto emailDto) {
		return mailService.joinEmail(emailDto.getEmail());
	}

	@PutMapping("/mailableCheck")
	public ResponseEntity AuthCheck(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody @Valid EmailCheckRequestDto requestDto) {
		long userId = userDetails.getUser().getId();
		String email = userDetails.getUser().getEmail();
		if (requestDto.getAuthNum() == null) {
			return ResponseEntity.status(200).body(UserErrorCode.AUTH_NUM_NOTFOUND);
		}
		mailService.CheckAuthNum(userId, email, requestDto.getAuthNum());
		return ResponseEntity.ok().body("인증 완료 했습니다");
	}
}