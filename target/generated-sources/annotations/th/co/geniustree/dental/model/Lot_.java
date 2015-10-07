package th.co.geniustree.dental.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lot.class)
public abstract class Lot_ {

	public static volatile SingularAttribute<Lot, Date> dateIn;
	public static volatile ListAttribute<Lot, PriceAndExpireProduct> priceAndExpireProducts_lot;
	public static volatile SingularAttribute<Lot, Date> dateOut;
	public static volatile SingularAttribute<Lot, String> nameStaffReam;
	public static volatile SingularAttribute<Lot, Integer> id;

}

