package com.ecommerce.microcommerce.model;


// Description des caractéristiques du produits, avec ses attributs, ses getters setters

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@JsonIgnoreProperties(value = {"prixAchat", "id"}) //Pour ignorer plusieurs attributs en une seule commande

@Entity // Pour que cette entité soit receonnue par JPA.
public class Product {

    @Id // Pour signifier que l'id est notre identification unique
    @GeneratedValue // Pour demander à ce que cet ID soit auto-incrémenté.
    private int id;
    private String nom;
    private int prix;

    //@JsonIgnore //Pour ignorer un attribut en particulier
    private int prixAchat;

    public Product(){

    }

    public Product(int id, String nom, int prix, int prixAchat) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.prixAchat = prixAchat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
