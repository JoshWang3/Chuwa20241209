package com.chuwa.redbook.payload;


public class CommentDTO {
    private Long id;
    private String content;
    private Long authorId;
    private Long postId;

    public CommentDTO() {}

    public CommentDTO(Long id, String content, Long authorId, Long postId) {
        this.id = id;
        this.content = content;
        this.authorId = authorId;
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}