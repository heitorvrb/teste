package br.heitor.teste.jpa.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AssociationOverride;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/**
 *
 * @author heitor
 */
@Entity
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Offer offer;
    @Embedded
    @AssociationOverride(name = "fees",
            joinTable = @JoinTable(
                    name = "purchase_fees",
                    inverseJoinColumns = @JoinColumn(name = "fee_id", referencedColumnName = "id"),
                    joinColumns = @JoinColumn(name = "purchase_id", referencedColumnName = "id")
            )
    )
    private Quote quote;

    public Long getId() {
        return id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Purchase other = (Purchase) obj;
        return Objects.equals(this.id, other.id);
    }

}
