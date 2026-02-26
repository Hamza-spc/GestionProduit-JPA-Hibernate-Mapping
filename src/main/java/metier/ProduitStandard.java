package metier;

import jakarta.persistence.*;

@Entity
public class ProduitStandard extends Produit {

    public ProduitStandard() {}

    public ProduitStandard(String designation, double prix, int quantite) {
        super(designation, prix, quantite);
    }
}