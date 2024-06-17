package com.team13.fantree.repository;

import com.team13.fantree.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PostRepository extends JpaRepository<Post, Long> {
	Page<Post> findAllByOrderByCreatedAtDesc(Pageable pageable);

	Page<Post> findAllByOrderByLikeCountDesc(Pageable pageable);

	Page<Post> findAllByCreatedAtBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);
}
