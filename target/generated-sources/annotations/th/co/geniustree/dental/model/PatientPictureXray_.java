package th.co.geniustree.dental.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientPictureXray.class)
public abstract class PatientPictureXray_ {

	public static volatile SingularAttribute<PatientPictureXray, String> nameXrayFilm;
	public static volatile SingularAttribute<PatientPictureXray, byte[]> contentXrayFilm;
	public static volatile SingularAttribute<PatientPictureXray, String> mimeTypeXrayFilm;
	public static volatile SingularAttribute<PatientPictureXray, Integer> id;

}

