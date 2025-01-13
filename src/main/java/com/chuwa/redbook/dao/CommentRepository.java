package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
