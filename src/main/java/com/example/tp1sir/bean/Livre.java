package com.example.tp1sir.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livre {
    @Id @GeneratedValue(strategy = GenerationType.AUTO )
   private Long id;
    private  String isbn;
    private   String titre;
    private   double prix;
    private  double seuilAlert;
    private   double stock;

    public Livre(String isbn, String titre, double prix, double seuilAlert, double stock) {
        this.isbn = isbn;
        this.titre = titre;
        this.prix = prix;
        this.seuilAlert = seuilAlert;
        this.stock = stock;
    }

    public Livre(Long id) {
        this.id = id;
    }

    public Livre() {
    }

    public Long  getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getSeuilAlert() {
        return seuilAlert;
    }

    public void setSeuilAlert(double seuilAlert) {
        this.seuilAlert = seuilAlert;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
}
