package metier;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designation;
    private double prix;
    private int quantite;

    // 🔗 Relation avec Catalogue
    @ManyToOne
    private CatalogueProduit catalogue;

    // 🔗 Relation avec Magasin
    @ManyToMany(mappedBy = "produits")
    private List<Magasin> magasins;

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

    public CatalogueProduit getCatalogue() { return catalogue; }
    public List<Magasin> getMagasins() { return magasins; }

    public void setDesignation(String designation) { this.designation = designation; }
    public void setPrix(double prix) { this.prix = prix; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
    public void setCatalogue(CatalogueProduit catalogue) { this.catalogue = catalogue; }
}