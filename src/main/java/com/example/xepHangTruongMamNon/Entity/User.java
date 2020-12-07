package com.example.xepHangTruongMamNon.Entity;

// import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;

// import org.hibernate.annotations.CreationTimestamp;
// import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String avatar;
    @Column
    private String address;

    private boolean deleted = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    // @Column(name = "create_time", updatable = false)
    // @Temporal(TemporalType.TIMESTAMP)
    // @CreationTimestamp
    // private Date create_time;

    // @Column(name = "update_time")
    // @Temporal(TemporalType.TIMESTAMP)
    // @UpdateTimestamp
    // private Date update_time;

    // @Column(name = "delete_time")
    // @Temporal(TemporalType.TIMESTAMP)
    // private Date delete_time;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // public Date getCreate_time() {
    // return create_time;
    // }

    // public void setCreate_time(Date create_time) {
    // this.create_time = create_time;
    // }

    // public Date getUpdate_time() {
    // return update_time;
    // }

    // public void setUpdate_time(Date update_time) {
    // this.update_time = update_time;
    // }

    // public Date getDelete_time() {
    // return delete_time;
    // }

    // public void setDelete_time(Date delete_time) {
    // this.delete_time = delete_time;
    // }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public User(String username, String password, String email, String avatar, String address, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.address = address;
        this.role = role;
    }

    public User() {

    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
