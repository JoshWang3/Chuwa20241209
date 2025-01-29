package com.chuwa.redbook.payload;

public class PostDTOMongo {

    private String id;
    private String title;
    private String content;
    private String description;
    private String userId;

    public PostDTOMongo() {}

    public PostDTOMongo(String id, String title, String content, String description, String userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.description = description;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getUserId() {return userId;}

    public void setUserId(String userId) {this.userId = userId;}

    @Override
    public String toString() {
        return "PostDTOMongo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
