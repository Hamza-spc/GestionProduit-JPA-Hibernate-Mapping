package dao;

import metier.Produit;
import java.util.List;

public interface IProduit {

    void add(Produit p);

    void modifyProduit(Produit p, Long code);

    void supprimer(Produit p);

    Produit getProduit(Long code);

    List<Produit> afficherListProduits();
}