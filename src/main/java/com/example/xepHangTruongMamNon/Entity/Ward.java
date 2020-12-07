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
@Table(name="Ward")
public class Ward {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="wardName", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY, mappedBy = "ward")
    private List<NurserySchool> listNurserySchool;
    
    public Ward(){

    }

    public Ward(String name){
        this.name= name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NurserySchool> getListNurserySchool() {
        return listNurserySchool;
    }

    public void setListNurserySchool(List<NurserySchool> listNurserySchool) {
        this.listNurserySchool = listNurserySchool;
    }
}
