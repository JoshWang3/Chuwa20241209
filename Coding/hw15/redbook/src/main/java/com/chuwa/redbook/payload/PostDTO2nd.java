package com.chuwa.redbook.payload;

public class PostDTO2nd {
    private String title;
    private long id;

    public PostDTO2nd(String title, long id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PostDTO2nd{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
