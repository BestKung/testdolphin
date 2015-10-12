package th.co.geniustree.dental.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TypeProduct.class)
public abstract class TypeProduct_ {

	public static volatile ListAttribute<TypeProduct, Product> products_type;
	public static volatile SingularAttribute<TypeProduct, String> name;
	public static volatile SingularAttribute<TypeProduct, Integer> id;
	public static volatile SingularAttribute<TypeProduct, Date> create_Date;

}

