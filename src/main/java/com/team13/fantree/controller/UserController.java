package com.team13.fantree.controller;

import com.team13.fantree.dto.ProfileRequestDto;
import com.team13.fantree.dto.ProfileResponseDto;
import com.team13.fantree.dto.SignUpRequestDto;
import com.team13.fantree.dto.WithDrawUserRequestDto;
import com.team13.fantree.entity.UserStatusEnum;
import com.team13.fantree.jwt.JwtTokenHelper;
import com.team13.fantree.security.UserDetailsImpl;
import com.team13.fantree.service.UserService;
import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	private final JwtTokenHelper jwtTokenHelper;
	private static final String LOGOUT_SUCCESS_MESSAGE = "로그아웃 성공하셨습니다";
	private static final String WITHDRAW_SUCCESS_MESSAGE = "회원탈퇴에 성공했습니다.";
	private static final String REFRESH_TOKEN_SUCCESS_MESSAGE = "토큰 재발급 성공했습니다.";

	@PostMapping("/logout")
	public ResponseEntity<String> logout(
		@AuthenticationPrincipal UserDetailsImpl userDetails) {

		userService.logout(userDetails.getUser().getId());
		return ResponseEntity.ok().body(LOGOUT_SUCCESS_MESSAGE);
	}

	@PostMapping
	public ResponseEntity<ProfileResponseDto> signUp(@Valid @RequestBody SignUpRequestDto requestDto) {

		ProfileResponseDto user = userService.signup(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	@DeleteMapping
	public ResponseEntity<String> withDraw(
		@AuthenticationPrincipal UserDetailsImpl userDetails,
		@Valid @RequestBody WithDrawUserRequestDto requestDto) {

		userService.withDraw(userDetails.getUser().getId(), requestDto.getPassword());
		return ResponseEntity.ok().body(WITHDRAW_SUCCESS_MESSAGE);
	}

	@PutMapping
	public ResponseEntity<ProfileResponseDto> profileUpdate(
		@AuthenticationPrincipal UserDetailsImpl userDetails,
		@RequestBody ProfileRequestDto requestDto) {

		Long userId = userDetails.getUser().getId();
		return ResponseEntity.ok().body(userService.update(userId, requestDto));
	}

	@GetMapping
	public ResponseEntity<ProfileResponseDto> getProfile(
		@RequestHeader(JwtTokenHelper.AUTHORIZATION_HEADER) String accessToken,
		@AuthenticationPrincipal UserDetailsImpl userDetails) {

		log.info(accessToken);
		return ResponseEntity.ok()
			.body(userService.getProfile(userDetails.getUser().getId()));
	}

	@GetMapping("/refresh")
	public ResponseEntity<String> refresh(
		@RequestHeader(JwtTokenHelper.AUTHORIZATION_HEADER) String accessToken,
		@RequestHeader(JwtTokenHelper.REFRESH_TOKEN_HEADER) String refreshToken) {

		Claims claims = jwtTokenHelper.getExpiredAccessToken(accessToken);
		String username = claims.getSubject();
		String status = claims.get("status").toString();
		UserStatusEnum statusEnum = UserStatusEnum.valueOf(status);

		userService.refreshTokenCheck(username, refreshToken);

		String newAccessToken = jwtTokenHelper.createToken(username, statusEnum);
		return ResponseEntity.ok()
			.header(JwtTokenHelper.AUTHORIZATION_HEADER, newAccessToken)
			.body(REFRESH_TOKEN_SUCCESS_MESSAGE + newAccessToken);
	}
}
