package com.example.tp1sir.bean;

import javax.persistence.*;

@Entity
public class Emprunt {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Livre livre;
    @ManyToOne
    private Client client;
    private int nombreExemplaire;
    private int retard;
    private String etat;

    public Emprunt(Livre livre, Client client, int nombreExemplaire, int retard, String etat) {
        this.livre = livre;
        this.client = client;
        this.nombreExemplaire = nombreExemplaire;
        this.retard = retard;
        this.etat = etat;
    }

    public Emprunt(Long id) {
        this.id = id;
    }

    public Emprunt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getNombreExemplaire() {
        return nombreExemplaire;
    }

    public void setNombreExemplaire(int nombreExemplaire) {
        this.nombreExemplaire = nombreExemplaire;
    }

    public int getRetard() {
        return retard;
    }

    public void setRetard(int retard) {
        this.retard = retard;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
