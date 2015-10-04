package th.co.geniustree.dental.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PriceAndExpireProduct.class)
public abstract class PriceAndExpireProduct_ {

	public static volatile SingularAttribute<PriceAndExpireProduct, Double> priceSell;
	public static volatile SingularAttribute<PriceAndExpireProduct, Lot> lot;
	public static volatile SingularAttribute<PriceAndExpireProduct, Product> product;
	public static volatile SingularAttribute<PriceAndExpireProduct, Double> priceBuy;
	public static volatile ListAttribute<PriceAndExpireProduct, OrderBill> orderBills;
	public static volatile SingularAttribute<PriceAndExpireProduct, Date> expire;
	public static volatile SingularAttribute<PriceAndExpireProduct, Integer> id;
	public static volatile SingularAttribute<PriceAndExpireProduct, Integer> value;

}

