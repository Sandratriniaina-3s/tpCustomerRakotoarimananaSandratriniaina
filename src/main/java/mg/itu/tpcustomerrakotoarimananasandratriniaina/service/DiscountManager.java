/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpcustomerrakotoarimananasandratriniaina.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.itu.tpcustomerrakotoarimananasandratriniaina.entity.Discount;

/**
 * Façade pour gérer les Discounts
 *
 * @author Sandratriniaina
 */

@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * Récupère tous les Discounts dans la base de données
     *
     * @return La liste des Discounts
     */
    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    /**
     * Met à jour un Discount dans la base de donnees
     *
     * @param discount Le Discount à mettre à jour
     * @return Le Discount mis à jour
     */
    @Transactional
    public Discount update(Discount discount) {
        return em.merge(discount);
    }

    /**
     * Récupère un Discount dans la base de données
     *
     * @param code
     * @return
     */
    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }

}
