package th.co.geniustree.dental.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Staff.class)
public abstract class Staff_ extends th.co.geniustree.dental.model.Employee_ {

	public static volatile SingularAttribute<Staff, String> nameTh;
	public static volatile SingularAttribute<Staff, String> workStatus;
	public static volatile SingularAttribute<Staff, String> race;
	public static volatile SingularAttribute<Staff, String> nation;
	public static volatile SingularAttribute<Staff, Date> startWork;
	public static volatile SingularAttribute<Staff, String> sex;
	public static volatile SingularAttribute<Staff, String> mobile;
	public static volatile SingularAttribute<Staff, String> pid;
	public static volatile SingularAttribute<Staff, Date> birthDate;
	public static volatile SingularAttribute<Staff, String> blood;
	public static volatile SingularAttribute<Staff, String> marryStatus;
	public static volatile SingularAttribute<Staff, String> currentAddress;
	public static volatile SingularAttribute<Staff, String> nameEng;
	public static volatile SingularAttribute<Staff, Bank> bank;
	public static volatile SingularAttribute<Staff, Contact> contact;
	public static volatile SingularAttribute<Staff, String> addressOfPid;
	public static volatile SingularAttribute<Staff, Date> endWork;
	public static volatile SingularAttribute<Staff, StaffPicture> staffPicture;
	public static volatile SingularAttribute<Staff, String> tel;
	public static volatile SingularAttribute<Staff, String> soldierStatus;
	public static volatile SingularAttribute<Staff, Department> department;

}

