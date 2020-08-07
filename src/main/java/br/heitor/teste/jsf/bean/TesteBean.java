package br.heitor.teste.jsf.bean;

import br.heitor.teste.jpa.dao.OfferDAO;
import br.heitor.teste.jpa.dao.PurchaseDAO;
import br.heitor.teste.jpa.entity.Offer;
import br.heitor.teste.jpa.entity.Purchase;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author heitor
 */
@Named(value = "teste")
public class TesteBean {

    @Inject
    private PurchaseDAO purchaseDao;
    @Inject
    private OfferDAO offerDao;

    private List<Purchase> purchases;

    public TesteBean() {
    }

    public List<Purchase> getPurchases() {
        if (purchases == null) {
            Offer offer = offerDao.getOffer(1L);
            purchases = purchaseDao.getPurchases(offer.getQuote().getPrice());
        }
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

}
