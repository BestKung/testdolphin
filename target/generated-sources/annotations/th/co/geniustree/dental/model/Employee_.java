package th.co.geniustree.dental.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> nation;
	public static volatile SingularAttribute<Employee, Date> startWork;
	public static volatile ListAttribute<Employee, Authority> roles;
	public static volatile SingularAttribute<Employee, String> pid;
	public static volatile SingularAttribute<Employee, String> marryStatus;
	public static volatile SingularAttribute<Employee, String> password;
	public static volatile SingularAttribute<Employee, Bank> bank;
	public static volatile SingularAttribute<Employee, Boolean> enable;
	public static volatile SingularAttribute<Employee, Contact> contact;
	public static volatile SingularAttribute<Employee, String> tel;
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, Department> department;
	public static volatile SingularAttribute<Employee, String> email;
	public static volatile SingularAttribute<Employee, String> nameTh;
	public static volatile SingularAttribute<Employee, String> workStatus;
	public static volatile SingularAttribute<Employee, String> race;
	public static volatile SingularAttribute<Employee, String> sex;
	public static volatile SingularAttribute<Employee, String> mobile;
	public static volatile SingularAttribute<Employee, Date> birthDate;
	public static volatile SingularAttribute<Employee, String> blood;
	public static volatile SingularAttribute<Employee, String> currentAddress;
	public static volatile SingularAttribute<Employee, String> nameEng;
	public static volatile SingularAttribute<Employee, EmployeePicture> employeePicture;
	public static volatile SingularAttribute<Employee, String> addressOfPid;
	public static volatile SingularAttribute<Employee, Date> endWork;
	public static volatile SingularAttribute<Employee, String> soldierStatus;

}

