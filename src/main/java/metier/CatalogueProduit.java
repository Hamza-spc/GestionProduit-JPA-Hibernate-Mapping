package metier;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class CatalogueProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcat;

    private String categorie;

    @OneToMany(mappedBy = "catalogue")
    private List<Produit> produits;

    public CatalogueProduit() {}

    public CatalogueProduit(String categorie) {
        this.categorie = categorie;
    }

    public Long getIdcat() { return idcat; }
    public String getCategorie() { return categorie; }
    public List<Produit> getProduits() { return produits; }

    public void setCategorie(String categorie) { this.categorie = categorie; }
}