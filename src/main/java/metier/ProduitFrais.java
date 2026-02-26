package metier;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class ProduitFrais extends Produit {

    private Date datePeremption;

    public ProduitFrais() {}

    public ProduitFrais(String designation, double prix, int quantite, Date datePeremption) {
        super(designation, prix, quantite);
        this.datePeremption = datePeremption;
    }

    public Date getDatePeremption() { return datePeremption; }
    public void setDatePeremption(Date datePeremption) { this.datePeremption = datePeremption; }
}