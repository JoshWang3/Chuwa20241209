package com.chuwa.redbook.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;
    //bidirectional relationship, indicate the owner field for proper mapping
    @OneToMany(mappedBy = "author")
    private List<Comment> commentList;
    private String name;
    @OneToMany(mappedBy = "author")
    private List<Post> postList;

    public Author() {};

    public Author(Long id, List<Comment> commentList, String name, List<Post> postList) {
        this.id = id;
        this.commentList = commentList;
        this.name = name;
        this.postList = postList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
