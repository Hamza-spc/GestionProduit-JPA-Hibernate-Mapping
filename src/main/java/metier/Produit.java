package metier;

import jakarta.persistence.*;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designation;
    private double prix;
    private int quantite;

    public Produit() {}

    public Produit(String designation, double prix, int quantite) {
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Long getId() { return id; }
    public String getDesignation() { return designation; }
    public double getPrix() { return prix; }
    public int getQuantite() { return quantite; }

    public void setDesignation(String designation) { this.designation = designation; }
    public void setPrix(double prix) { this.prix = prix; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
}