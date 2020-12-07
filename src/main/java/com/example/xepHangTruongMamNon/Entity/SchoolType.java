package com.example.xepHangTruongMamNon.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SchoolType")
public class SchoolType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "typeName")
    private String typeName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "schoolType")
    private List<NurserySchool> listNurserySchool;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<NurserySchool> getListNurserySchool() {
        return listNurserySchool;
    }

    public void setListNurserySchool(List<NurserySchool> listNurserySchool) {
        this.listNurserySchool = listNurserySchool;
    }

    public SchoolType() {

    }

    public SchoolType(String typeName) {
        this.typeName = typeName;
    }
}
