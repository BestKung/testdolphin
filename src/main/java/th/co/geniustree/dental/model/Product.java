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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jasin007
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @SequenceGenerator(name = "PRODUCT", sequenceName = "PRODUCT_SQE", allocationSize = 1)
    @GeneratedValue(generator = "PRODUCT", strategy = GenerationType.AUTO)
    private Integer Id;

    @NotBlank(message = "Name not Empty")
    @Column(name = "NAME")
    private String name;

    @Column(name = "BARCODE_MAIN")
    private String barCode_Main;

    @Column(name = "BARCODE_SUB")
    private String barCode_Sub;

    @ManyToOne
    @JoinColumn(name = "TYPEPRODUCT_ID")
    private TypeProduct typeProduct;

    @ManyToOne
    @JoinColumn(name = "UNIT_ID")
    private UnitProduct unit;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<PriceAndExpireProduct> PriceAndExpireProduct_Product;

    public List<PriceAndExpireProduct> getPriceAndExpireProduct_Product() {
        return PriceAndExpireProduct_Product;
    }

    public void setPriceAndExpireProduct_Product(List<PriceAndExpireProduct> PriceAndExpireProduct_Product) {
        this.PriceAndExpireProduct_Product = PriceAndExpireProduct_Product;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public UnitProduct getUnit() {
        return unit;
    }

    public void setUnit(UnitProduct unit) {
        this.unit = unit;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode_Main() {
        return barCode_Main;
    }

    public void setBarCode_Main(String barCode_Main) {
        this.barCode_Main = barCode_Main;
    }

    public String getBarCode_Sub() {
        return barCode_Sub;
    }

    public void setBarCode_Sub(String barCode_Sub) {
        this.barCode_Sub = barCode_Sub;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.Id);
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

}
