package br.heitor.teste.jpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

/**
 *
 * @author heitor
 */
@Embeddable
public class Quote implements Serializable {

    @Column(precision = 13, scale = 3)
    private BigDecimal price;
    @OneToMany
    private List<Fee> fees = new ArrayList<>();

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Fee> getFees() {
        return fees;
    }

    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }

}
