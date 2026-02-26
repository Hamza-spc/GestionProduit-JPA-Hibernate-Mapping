import jakarta.persistence.*;
import metier.*;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionProduits");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // 1) Créer un catalogue
        CatalogueProduit cat = new CatalogueProduit("Informatique");
        em.persist(cat);

        // 2) Créer des produits (héritage)
        ProduitStandard ps = new ProduitStandard("Clavier", 250, 10);
        ps.setCatalogue(cat);


        ProduitFrais pf = new ProduitFrais(
                "Lait",
                12.0,
                30,
                new Date()
        );        pf.setCatalogue(cat);

        em.persist(ps);
        em.persist(pf);

        // 3) Créer un magasin + associer produits
        Magasin m1 = new Magasin("Casablanca");
        m1.getProduits().add(ps);
        m1.getProduits().add(pf);

        em.persist(m1);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Catalogue + Produits + Magasin insérés !");
    }
}