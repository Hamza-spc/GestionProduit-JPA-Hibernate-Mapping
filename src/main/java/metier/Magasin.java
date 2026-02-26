package metier;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Magasin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idm;

    private String lieu;

    @ManyToMany
    @JoinTable(
            name = "Magasin_Produit",
            joinColumns = @JoinColumn(name = "magasin_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<Produit> produits = new ArrayList<>(); // ✅ IMPORTANT

    public Magasin() {}

    public Magasin(String lieu) {
        this.lieu = lieu;
        this.produits = new ArrayList<>(); // ✅ sécurité
    }

    public Long getIdm() { return idm; }
    public String getLieu() { return lieu; }
    public List<Produit> getProduits() { return produits; }

    public void setLieu(String lieu) { this.lieu = lieu; }
}