package com.team13.fantree.service;

import com.team13.fantree.dto.CommentRequestDto;
import com.team13.fantree.dto.CommentResponseDto;
import com.team13.fantree.entity.Comment;
import com.team13.fantree.entity.Post;
import com.team13.fantree.entity.User;
import com.team13.fantree.exception.CommentErrorCode;
import com.team13.fantree.exception.MismatchException;
import com.team13.fantree.exception.NotFoundException;
import com.team13.fantree.exception.UserErrorCode;
import com.team13.fantree.repository.CommentRepository;
import com.team13.fantree.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	public CommentResponseDto createComment(CommentRequestDto requestDto, User user) {
		Post post = postRepository.findById(requestDto.getPostId()).orElseThrow(
			() -> new NotFoundException(CommentErrorCode.COMMENT_NOT_FOUND));
		Comment comment = new Comment(post, user, requestDto.getContent());
		log.info("Creating comment {}", comment.getUser().getUsername());
		commentRepository.save(comment);
		return new CommentResponseDto(comment);
	}

	public List<CommentResponseDto> findAllByPosts(long id) {
		List<Comment> commentList = commentRepository.findAllByPostId(id);
		List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();

		for (Comment comment : commentList) {
			CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
			commentResponseDtoList.add(commentResponseDto);
		}
		return commentResponseDtoList;
	}

	@Transactional
	public CommentResponseDto updateComment(long id, CommentRequestDto requestDto, User user) {
		Comment comment = commentRepository.findById(id).orElseThrow(() -> new NotFoundException(CommentErrorCode.COMMENT_NOT_FOUND));
		if (comment.getUser().getId() != user.getId()) {
			throw new MismatchException(UserErrorCode.USER_MISMATCH_FOR_POST);
		}
		comment.setContent(requestDto.getContent());
		commentRepository.save(comment);
		return new CommentResponseDto(comment);
	}

	public String deleteComment(long id, User user) {
		Comment comment = commentRepository.findById(id).orElseThrow(
			() -> new NotFoundException(CommentErrorCode.COMMENT_NOT_FOUND)
		);
		if (comment.getUser().getId() != user.getId()) {
			throw new MismatchException(UserErrorCode.USER_MISMATCH_FOR_POST);
		}
		commentRepository.delete(comment);
		return "성공했습니다";
	}
}
