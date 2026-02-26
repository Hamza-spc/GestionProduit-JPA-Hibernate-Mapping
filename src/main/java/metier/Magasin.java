package metier;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Magasin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idm;

    private String lieu;

    @ManyToMany
    private List<Produit> produits;

    public Magasin() {}

    public Magasin(String lieu) {
        this.lieu = lieu;
    }

    public Long getIdm() { return idm; }
    public String getLieu() { return lieu; }
    public List<Produit> getProduits() { return produits; }

    public void setLieu(String lieu) { this.lieu = lieu; }
}