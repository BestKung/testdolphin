/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.MERGE;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jasin007
 */
@Entity
@Table(name = "ORDERHEAL")
public class OrderHeal implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "VALUE")
    private Integer value;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DETAILHEAL_ID")
    private DetailHeal detailHeal;

    @ManyToOne
    @JoinColumn(name = "LISTPAYHEAL_ID")
    private ListSelectHeal listSelectHeal;
 
    public DetailHeal getDetailHeal() {
        return detailHeal;
    }

    public void setDetailHeal(DetailHeal detailHeal) {
        this.detailHeal = detailHeal;
    }

    public ListSelectHeal getListPayHeal() {
        return listSelectHeal;
    }

    public void setListPayHeal(ListSelectHeal listSelectHeal) {
        this.listSelectHeal = listSelectHeal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final OrderHeal other = (OrderHeal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

}
