/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpcustomerrakotoarimananasandratriniaina.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.itu.tpcustomerrakotoarimananasandratriniaina.entity.Customer;
import mg.itu.tpcustomerrakotoarimananasandratriniaina.entity.Discount;
import mg.itu.tpcustomerrakotoarimananasandratriniaina.service.CustomerManager;
import mg.itu.tpcustomerrakotoarimananasandratriniaina.service.DiscountManager;

/**
 * Backing bean pour la page customerDetails.xhtml.
 *
 * @author Sandratriniaina
 */

@Named(value = "customerDetailsBean")
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    @Inject
    private CustomerManager customerManager;
    
    @Inject
    private DiscountManager discountManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (contenu dans l'attribut customer
     * de cette classe).
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        customer = customerManager.update(customer);
        return "customerList";
    }
    
    /**
     * Retourne la liste de tous les Discount
     *
     * @return
     */
    public List<Discount> getDiscounts() {
        return discountManager.getAllDiscounts();
    }
    
    public List<Discount> getDiscountsInAscendingOrder() {
        return discountManager.getAllDiscountsInAscendingOrder();
    }
    
    public List<Discount> getDiscountsInDescendingOrder() {
        return discountManager.getAllDiscountsInDescendingOrder();
    }
    
}
