/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jasin007
 */
@Entity
@Table(name = "PRICEANDEXPIREPRODUCT")
public class PriceAndExpireProduct implements Serializable {

    @GeneratedValue
    @Id
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date expire;

    @Column(name = "VALUE")
    private Integer value;

    @Column(name = "PRICEBUY")
    private Double priceBuy;

    @Column(name = "PRICESELL")
    private Double priceSell;

    @ManyToOne
    @JoinColumn(name = "LOT_ID")
    private Lot lot;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @JsonIgnore
    @OneToMany(mappedBy = "PriceAndExpireProduct")
    private List<OrderBill> orderBills;

    public List<OrderBill> getOrderBills() {
        return orderBills;
    }

    public void setOrderBills(List<OrderBill> orderBills) {
        this.orderBills = orderBills;
    }

    public Double getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(Double priceBuy) {
        this.priceBuy = priceBuy;
    }

    public Double getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(Double priceSell) {
        this.priceSell = priceSell;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PriceAndExpireProduct other = (PriceAndExpireProduct) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
