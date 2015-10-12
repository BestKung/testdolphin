package th.co.geniustree.dental.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientPicture.class)
public abstract class PatientPicture_ {

	public static volatile SingularAttribute<PatientPicture, String> nameXrayFilm;
	public static volatile SingularAttribute<PatientPicture, byte[]> contentAfter;
	public static volatile SingularAttribute<PatientPicture, byte[]> contentBefore;
	public static volatile SingularAttribute<PatientPicture, String> nameAfter;
	public static volatile SingularAttribute<PatientPicture, String> mimeTypeAfter;
	public static volatile SingularAttribute<PatientPicture, byte[]> contentXrayFilm;
	public static volatile SingularAttribute<PatientPicture, byte[]> contentCurrent;
	public static volatile SingularAttribute<PatientPicture, String> nameCurrent;
	public static volatile SingularAttribute<PatientPicture, String> mimeTypeXrayFilm;
	public static volatile SingularAttribute<PatientPicture, String> mimeTypeBefore;
	public static volatile SingularAttribute<PatientPicture, Integer> id;
	public static volatile SingularAttribute<PatientPicture, String> nameBefore;
	public static volatile SingularAttribute<PatientPicture, String> mimeTypeCurrent;

}

