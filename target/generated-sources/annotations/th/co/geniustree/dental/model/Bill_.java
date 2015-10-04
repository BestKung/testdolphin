package th.co.geniustree.dental.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bill.class)
public abstract class Bill_ {

	public static volatile SingularAttribute<Bill, Double> sumPrice;
	public static volatile SingularAttribute<Bill, Date> dateBill;
	public static volatile ListAttribute<Bill, OrderBill> orderBills;
	public static volatile SingularAttribute<Bill, Integer> id;

}

