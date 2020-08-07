package br.heitor.teste.jpa.dao;

import br.heitor.teste.jpa.entity.Offer;
import br.heitor.teste.jpa.entity.Purchase;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author heitor
 */
public class PurchaseDAO {

    @PersistenceContext(unitName = "TestePU")
    private EntityManager em;

    public List<Purchase> getPurchases() {
        TypedQuery<Purchase> q = em.createQuery(
                "SELECT p FROM Purchase p", Purchase.class);

        return q.getResultList();
    }

    public List<Purchase> getPurchases(Offer offer) {
        TypedQuery<Purchase> q = em.createQuery(
                "SELECT p FROM Purchase p"
                + " WHERE p.offer = :offer", Purchase.class);
        q.setParameter("offer", offer);

        return q.getResultList();
    }

    public List<Purchase> getPurchases(BigDecimal price) {
        TypedQuery<Purchase> q = em.createQuery(
                "SELECT p FROM Purchase p"
                + " WHERE p.offer.quote.price = :price", Purchase.class);
        q.setParameter("price", price);

        return q.getResultList();
    }

}
