package th.co.geniustree.dental.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, TypeProduct> typeProduct;
	public static volatile SingularAttribute<Product, UnitProduct> unit;
	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, String> barCode_Main;
	public static volatile SingularAttribute<Product, Integer> Id;
	public static volatile ListAttribute<Product, PriceAndExpireProduct> PriceAndExpireProduct_Product;
	public static volatile SingularAttribute<Product, String> barCode_Sub;

}

