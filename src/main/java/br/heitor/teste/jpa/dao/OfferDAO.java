package br.heitor.teste.jpa.dao;

import br.heitor.teste.jpa.entity.Offer;
import br.heitor.teste.jpa.entity.Purchase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author heitor
 */
public class OfferDAO {

    @PersistenceContext(unitName = "TestePU")
    private EntityManager em;

    public Offer getOffer(Long id) {
        TypedQuery<Offer> q = em.createQuery(
                "SELECT o FROM Offer o"
                + " WHERE o.id = :id", Offer.class);
        q.setParameter("id", id);

        return q.getSingleResult();
    }

}
