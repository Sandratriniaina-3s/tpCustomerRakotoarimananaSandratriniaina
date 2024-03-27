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
import mg.itu.tpcustomerrakotoarimananasandratriniaina.entity.Customer;

/**
 * Façade pour gérer les Customers
 *
 * @author Sandratriniaina
 */

@RequestScoped
public class CustomerManager {
    
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    /**
     * Ajoute un nouveau Customer dans la base de données
     *
     * @param customer Le Customer à ajouter
     */
    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }
    
    /**
     * Récupère tous les Customers dans la base de données
     *
     * @return La liste des Customers
     */
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }
    
    /**
     * Met à jour un Customer dans la base de donnees
     *
     * @param customer Le Customer à mettre à jour
     * @return Le Customer mis à jour
     */
    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }

    /**
     * Récupère un Customer dans la base de données
     *
     * @param idCustomer
     * @return
     */
    public Customer findById(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }
    
}
