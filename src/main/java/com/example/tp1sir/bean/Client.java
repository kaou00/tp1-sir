package com.example.tp1sir.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cin;
    @OneToMany
    private List<Emprunt> emprunts;
    private int point;

    public Client(String cin, List<Emprunt> emprunts, int point) {
        this.cin = cin;
        this.emprunts = emprunts;
        this.point = point;
    }

    public Client(Long id) {
        this.id = id;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
