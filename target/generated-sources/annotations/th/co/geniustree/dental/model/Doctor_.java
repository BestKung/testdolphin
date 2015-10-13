package th.co.geniustree.dental.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Doctor.class)
public abstract class Doctor_ extends th.co.geniustree.dental.model.Employee_ {

	public static volatile SingularAttribute<Doctor, String> workStatus;
	public static volatile SingularAttribute<Doctor, String> nameEng;
	public static volatile SingularAttribute<Doctor, String> permitType;
	public static volatile SingularAttribute<Doctor, String> address;
	public static volatile SingularAttribute<Doctor, String> sex;
	public static volatile SingularAttribute<Doctor, DoctorPicture> doctorPicture;
	public static volatile SingularAttribute<Doctor, String> mobile;
	public static volatile SingularAttribute<Doctor, String> pid;
	public static volatile SingularAttribute<Doctor, String> tel;
	public static volatile SingularAttribute<Doctor, Date> birthDate;
	public static volatile SingularAttribute<Doctor, String> blood;
	public static volatile SingularAttribute<Doctor, String> permitNo;

}

