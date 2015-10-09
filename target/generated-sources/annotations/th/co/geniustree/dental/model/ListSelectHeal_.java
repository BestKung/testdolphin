package th.co.geniustree.dental.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ListSelectHeal.class)
public abstract class ListSelectHeal_ {

	public static volatile SingularAttribute<ListSelectHeal, Double> price;
	public static volatile SingularAttribute<ListSelectHeal, String> name;
	public static volatile SingularAttribute<ListSelectHeal, Integer> id;
	public static volatile ListAttribute<ListSelectHeal, OrderHeal> orderHealListSelectHeals;

}

