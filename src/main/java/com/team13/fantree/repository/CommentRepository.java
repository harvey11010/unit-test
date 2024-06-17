package com.team13.fantree.repository;

import com.team13.fantree.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findAllByPostId(long id);
}
