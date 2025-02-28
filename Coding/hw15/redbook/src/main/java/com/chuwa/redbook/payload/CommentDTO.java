package com.chuwa.redbook.payload;

public class CommentDTO {
    private Long id;
    private String content;
    private Long userId;
    private Long postId;

    public CommentDTO() {}

    public CommentDTO(Long id, String content, Long userId, Long postId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", postId=" + postId +
                '}';
    }
}
