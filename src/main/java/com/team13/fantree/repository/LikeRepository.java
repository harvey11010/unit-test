package com.team13.fantree.repository;

import com.team13.fantree.entity.ContentEnumType;
import com.team13.fantree.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

	Optional<Like> findByUserIdAndContentIdAndContentType(long userId, long contentId, ContentEnumType byType);
}
