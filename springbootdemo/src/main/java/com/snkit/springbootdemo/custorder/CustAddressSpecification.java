package com.snkit.springbootdemo.custorder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class CustAddressSpecification implements Specification<CustomerEntity> {
	
	private static final long serialVersionUID = 1L;
	
	CustomerOrderReq filter;

	public CustAddressSpecification(CustomerOrderReq req) {
		this.filter = req;
	}

	@Override
	public Predicate toPredicate(Root<CustomerEntity> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {		
		
		Predicate predicate = criteriaBuilder.conjunction();
		
			Join<CustomerEntity,OrderEntity> custOrderJoin=	root.join("orderEntityList", JoinType.LEFT);
	
	
			
		if (filter.getAddhar() != null) {
			System.out.println("    getCustBySpecification  filter.getAddhar() != null  ============================ ");
			predicate.getExpressions().add(
					criteriaBuilder.equal(root.get("addhar"), filter.getAddhar()));
		}
				
		if (filter.getEmail() != null) {
			predicate.getExpressions().add(criteriaBuilder.like(root.get("email"),
					
					"%"+filter.getEmail()+"%"));
		}
		
		if (filter.getName() != null) {
			
			System.out.println("    getCustBySpecification  filter.getName()!= null  ============================ ");
			predicate.getExpressions().add(criteriaBuilder.equal(root.get("name"),
					filter.getName() ));
		}
		
		
		/*if (filter.getQuantiy() != null) {
			predicate.getExpressions().add(
					criteriaBuilder.greaterThanOrEqualTo(custOrderJoin.get("quantity"),
					filter.getQuantiy() ));
		}*/
		query.distinct(true);

		return predicate;
	}

}
