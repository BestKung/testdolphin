package th.co.geniustree.dental.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderHeal.class)
public abstract class OrderHeal_ {

	public static volatile SingularAttribute<OrderHeal, Integer> id;
	public static volatile SingularAttribute<OrderHeal, DetailHeal> detailHeal;
	public static volatile SingularAttribute<OrderHeal, Integer> value;
	public static volatile SingularAttribute<OrderHeal, ListSelectHeal> ListSelectHeal;

}

