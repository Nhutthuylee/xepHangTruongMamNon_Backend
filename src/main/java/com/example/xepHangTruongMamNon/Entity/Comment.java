package com.example.xepHangTruongMamNon.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "nurserySchool_id", nullable = false)
    private NurserySchool nurserySchool;

    @Column(name = "content")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public NurserySchool getNurserySchool() {
        return nurserySchool;
    }

    public void setNurserySchool(NurserySchool nurserySchool) {
        this.nurserySchool = nurserySchool;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment( User user, NurserySchool nurserySchool, String content) {
        this.user = user;
        this.nurserySchool = nurserySchool;
        this.content = content;
    }

    public Comment() {
    }
}
