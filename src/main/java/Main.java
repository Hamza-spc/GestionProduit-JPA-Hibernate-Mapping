import dao.ImplProduit;
import metier.Produit;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ImplProduit dao = new ImplProduit();

        // ➕ Ajouter
        Produit p1 = new Produit("Laptop", 9000, 5);
        dao.add(p1);

        Produit p2 = new Produit("Mouse", 200, 20);
        dao.add(p2);

        System.out.println("Produits ajoutés");

        // 🔍 Lire
        Produit produit = dao.getProduit(1L);
        System.out.println("Produit ID 1 : " + produit.getDesignation());

        // ✏️ Modifier
        Produit newData = new Produit("Laptop Gaming", 12000, 3);
        dao.modifyProduit(newData, 1L);
        System.out.println("Produit modifié");

        // 📋 Afficher tous
        List<Produit> produits = dao.afficherListProduits();
        System.out.println("Liste des produits :");
        for (Produit p : produits) {
            System.out.println(p.getId() + " | " + p.getDesignation() +
                    " | " + p.getPrix() + " | " + p.getQuantite());
        }

        // ❌ Supprimer
        dao.supprimer(p2);
        System.out.println("Produit supprimé");
    }
}