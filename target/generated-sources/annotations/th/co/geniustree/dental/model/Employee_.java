package th.co.geniustree.dental.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> nameTh;
	public static volatile SingularAttribute<Employee, String> password;
	public static volatile SingularAttribute<Employee, Boolean> enable;
	public static volatile ListAttribute<Employee, Authority> roles;
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, String> type;
	public static volatile SingularAttribute<Employee, String> email;

}

