package th.co.geniustree.dental.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderBill.class)
public abstract class OrderBill_ {

	public static volatile SingularAttribute<OrderBill, Bill> bill;
	public static volatile SingularAttribute<OrderBill, Integer> id;
	public static volatile SingularAttribute<OrderBill, DetailHeal> detailHeal;
	public static volatile SingularAttribute<OrderBill, Integer> value;
	public static volatile SingularAttribute<OrderBill, PriceAndExpireProduct> PriceAndExpireProduct;

}

