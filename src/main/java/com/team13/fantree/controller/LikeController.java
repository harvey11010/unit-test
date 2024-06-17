package com.team13.fantree.controller;

import com.team13.fantree.dto.LikeResponseDto;
import com.team13.fantree.security.UserDetailsImpl;
import com.team13.fantree.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/likes")
@RestController
public class LikeController {

	private final LikeService likeService;

	private static final String LIKE_CANCEL = "좋아요 취소";

	@PostMapping("/{contentId}")
	public ResponseEntity<LikeResponseDto> like(
		@PathVariable long contentId,
		@RequestParam("contentType") String contentType,
		@AuthenticationPrincipal UserDetailsImpl userDetails) {

		LikeResponseDto responseDto = likeService.createLike(
			userDetails.getUser().getId(), contentId, contentType);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
	}

	@DeleteMapping("/{likeId}")
	public ResponseEntity<String> deleteLike(@PathVariable long likeId,
		@AuthenticationPrincipal UserDetailsImpl userDetails) {

		likeService.deleteLike(likeId, userDetails.getUser().getId());
		return ResponseEntity.ok().body(LIKE_CANCEL);
	}

}
