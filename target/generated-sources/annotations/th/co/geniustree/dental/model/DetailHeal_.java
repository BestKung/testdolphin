package th.co.geniustree.dental.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetailHeal.class)
public abstract class DetailHeal_ {

	public static volatile SingularAttribute<DetailHeal, Doctor> doctor;
	public static volatile SingularAttribute<DetailHeal, Date> dateHeal;
	public static volatile ListAttribute<DetailHeal, OrderHeal> OrderHeal_DetailHeal;
	public static volatile SingularAttribute<DetailHeal, Integer> id;
	public static volatile SingularAttribute<DetailHeal, String> detail;
	public static volatile SingularAttribute<DetailHeal, Customer> customer;

}

