package th.co.geniustree.dental.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Patient.class)
public abstract class Patient_ {

	public static volatile SingularAttribute<Patient, String> address;
	public static volatile SingularAttribute<Patient, String> race;
	public static volatile SingularAttribute<Patient, String> nation;
	public static volatile SingularAttribute<Patient, String> hn;
	public static volatile SingularAttribute<Patient, String> sex;
	public static volatile SingularAttribute<Patient, String> mobile;
	public static volatile SingularAttribute<Patient, String> pid;
	public static volatile SingularAttribute<Patient, Date> birthDate;
	public static volatile SingularAttribute<Patient, String> blood;
	public static volatile SingularAttribute<Patient, PatientPicture> patientPicture;
	public static volatile SingularAttribute<Patient, String> name;
	public static volatile SingularAttribute<Patient, String> tel;
	public static volatile SingularAttribute<Patient, Integer> id;
	public static volatile SingularAttribute<Patient, String> job;
	public static volatile ListAttribute<Patient, MedicalHistory> medicalHistory;
	public static volatile SingularAttribute<Patient, String> email;

}
