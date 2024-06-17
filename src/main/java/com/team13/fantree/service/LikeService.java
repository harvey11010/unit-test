package com.team13.fantree.service;

import com.team13.fantree.dto.LikeResponseDto;
import com.team13.fantree.entity.Comment;
import com.team13.fantree.entity.ContentEnumType;
import com.team13.fantree.entity.Like;
import com.team13.fantree.entity.Post;
import com.team13.fantree.exception.*;
import com.team13.fantree.repository.CommentRepository;
import com.team13.fantree.repository.LikeRepository;
import com.team13.fantree.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikeService {

	private final LikeRepository likeRepository;
	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	@Transactional
	public LikeResponseDto createLike(long userId, long contentId, String contentType) {

		duplicateLikeCheck(userId, contentId, contentType);
		isContentsAndSelfLikeCheck(userId, contentId, contentType);

		Like like = likeRepository.save(new Like(userId, contentId, contentType));
		return new LikeResponseDto(like);
	}

	private void duplicateLikeCheck(long userId, long contentId, String contentType) {
		Optional<Like> findLike = likeRepository.findByUserIdAndContentIdAndContentType(userId, contentId, ContentEnumType.getByType(contentType));
		if (findLike.isPresent()) {
			if (findLike.get().getContentId() == contentId &&
				Objects.equals(findLike.get().getContentType().getType(), contentType)) {
				throw new DuplicateException(LikeErrorCode.DUPLICATE_LIKE);
			}
		}
	}

	private void isContentsAndSelfLikeCheck(long userId, long contentId, String contentType) {
		//해당 댓글이 존재하지 않으면 예외 발생
		if (Objects.equals(contentType, ContentEnumType.COMMENT.getType())) {
			Comment comment = commentRepository.findById(contentId).orElseThrow(
				// comment 예외 발생
			);
			if (comment.getUser().getId() == userId)
				throw new SelfLikeException(LikeErrorCode.SELF_LIKE);
			comment.UpLikeCount();
			//해당 게시글이 존재하지 않으면 예외 발생
		} else if (Objects.equals(contentType, ContentEnumType.POST.getType())) {
			Post post = postRepository.findById(contentId).orElseThrow(
				() -> new NotFoundException(PostErrorCode.POST_NOT_FOUND)
			);
			if (post.getUser().getId() == userId)
				throw new SelfLikeException(LikeErrorCode.SELF_LIKE);
			post.UpLikeCount();
		} else {
			throw new NotFoundException(CommonErrorCode.RESOURCE_NOT_FOUND);
		}
	}

	public void deleteLike(long likeId, long UserId) {
		Like like = likeRepository.findById(likeId).orElseThrow(
			() -> new NotFoundException(LikeErrorCode.LIKE_NOT_FOUND)
		);

		if (like.getUserId() != UserId)
			throw new MismatchException(LikeErrorCode.USER_MISMATCH);
		likeRepository.delete(like);
	}
}
