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
@Table(name = "SchoolImage")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "imageLink")
    private String imageLink;
    @ManyToOne()
    @JoinColumn(name = "nurserySchool_id", nullable = false)
    private NurserySchool nurserySchool;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public NurserySchool getNurserySchool() {
        return nurserySchool;
    }

    public void setNurserySchool(NurserySchool nurserySchool) {
        this.nurserySchool = nurserySchool;
    }

    public Image(String imageLink, NurserySchool nurserySchool) {
        this.imageLink = imageLink;
        this.nurserySchool = nurserySchool;
    }

    public Image() {
    }
}
