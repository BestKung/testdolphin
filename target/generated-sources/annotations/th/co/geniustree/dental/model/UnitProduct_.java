package th.co.geniustree.dental.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UnitProduct.class)
public abstract class UnitProduct_ {

	public static volatile SingularAttribute<UnitProduct, String> name;
	public static volatile SingularAttribute<UnitProduct, Integer> id;
	public static volatile ListAttribute<UnitProduct, Product> products_unit;

}

