package dao;

import jakarta.persistence.*;
import metier.Produit;

import java.util.List;

public class ImplProduit implements IProduit {

    private EntityManagerFactory emf;
    private EntityManager em;

    // 🔹 Constructeur
    public ImplProduit() {
        emf = Persistence.createEntityManagerFactory("GestionProduits");
        em = emf.createEntityManager();
    }

    // ➕ Ajouter
    @Override
    public void add(Produit p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    // ✏️ Modifier
    @Override
    public void modifyProduit(Produit p, Long code) {
        em.getTransaction().begin();

        Produit produit = em.find(Produit.class, code);
        if (produit != null) {
            produit.setDesignation(p.getDesignation());
            produit.setPrix(p.getPrix());
            produit.setQuantite(p.getQuantite());
        }

        em.getTransaction().commit();
    }

    // ❌ Supprimer
    @Override
    public void supprimer(Produit p) {
        em.getTransaction().begin();

        Produit produit = em.find(Produit.class, p.getId());
        if (produit != null) {
            em.remove(produit);
        }

        em.getTransaction().commit();
    }

    // 🔍 Chercher par ID
    @Override
    public Produit getProduit(Long code) {
        return em.find(Produit.class, code);
    }

    // 📋 Afficher tous
    @Override
    public List<Produit> afficherListProduits() {
        return em.createQuery("SELECT p FROM Produit p", Produit.class)
                .getResultList();
    }
}