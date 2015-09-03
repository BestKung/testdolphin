/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import th.co.geniustree.dental.model.Employee;
import th.co.geniustree.dental.model.Employee_;

/**
 *
 * @author Best
 */
public class EmployeeSpec {
    
    public static Specification<Employee> nameLike(final String keyword){
    return new Specification<Employee>() {

        @Override
        public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
            return cb.or(cb.like(root.get(Employee_.nameTh), keyword),cb.like(cb.upper(root.get(Employee_.nameEng)), keyword.toUpperCase()));
        }
    };
    }
    
    public static Specification<Employee> emailLike(final String keyword){
    return new Specification<Employee>() {

        @Override
        public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
           return cb.like(cb.upper(root.get(Employee_.email)), keyword.toUpperCase());
        }
    };
    }
    
    public static Specification<Employee> mobileLike(final String keyword){
    return new Specification<Employee>() {

        @Override
        public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
            return cb.like(root.get(Employee_.mobile), keyword);
        }
    };
    }
    
    public static Specification<Employee> pidLike(final String keyword){
    return new Specification<Employee>() {

        @Override
        public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
           return cb.like(root.get(Employee_.pid), keyword);
        }
    };
    }
}
