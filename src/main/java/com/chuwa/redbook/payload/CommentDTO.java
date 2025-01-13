package com.chuwa.redbook.payload;

import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.entity.Post;

public class CommentDTO {
    private Long commentId;
    private String content;
    private Author author;
    private Post post;

    public CommentDTO() {
    }

    public CommentDTO(Long commentId, String content, Author author, Post post) {
        this.commentId = commentId;
        this.content = content;
        this.author = author;
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long comment_id) {
        this.commentId = comment_id;
    }
}
