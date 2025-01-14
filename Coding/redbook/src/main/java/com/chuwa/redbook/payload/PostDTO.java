package com.chuwa.redbook.payload;


public class PostDTO {

    private Long id;
    private String title;
    private String content;
    private String description;
    private Long userId;

    public PostDTO() {}

    public PostDTO(Long id, String title, String content, String description, Long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.description = description;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {return userId;}

    public void setUserId(Long userId) {this.userId = userId;}
}