/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jasin007
 */
@Entity
@Table(name = "LISTSELECTHEAL")
public class ListSelectHeal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Double price;
  
    @JsonIgnore
    @OneToMany(mappedBy = "listSelectHeal")
    private List<OrderHeal> OrderHeal_ListSelectHeal;

    public List<OrderHeal> getPayHeals_ListPayHeal() {
        return OrderHeal_ListSelectHeal;
    }

    public void setPayHeals_ListPayHeal(List<OrderHeal> OrderHeal_ListPayHeal) {
        this.OrderHeal_ListSelectHeal = OrderHeal_ListPayHeal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final ListSelectHeal other = (ListSelectHeal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }



}
