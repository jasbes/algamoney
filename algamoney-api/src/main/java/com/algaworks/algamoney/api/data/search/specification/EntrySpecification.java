package com.algaworks.algamoney.api.data.search.specification;

import com.algaworks.algamoney.api.data.entity.EntryEntity;
import com.algaworks.algamoney.api.data.entity.EntryEntity_;
import com.algaworks.algamoney.api.data.search.filter.EntryFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EntrySpecification implements Specification<EntryEntity> {

    private EntryFilter filter;

    public EntrySpecification(EntryFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<EntryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = null;
        if (!StringUtils.isEmpty(filter.getDescription())) {
            predicate = criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.lower(root.get(EntryEntity_.DESCRIPTION)), "%" + filter.getDescription().toLowerCase() + "%"));
        }

        if (!ObjectUtils.isEmpty(filter.getDueDateFrom())) {
            predicate = criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get(EntryEntity_.DUE_DATE), filter.getDueDateFrom()));
        }

        if (!ObjectUtils.isEmpty(filter.getDueDateTo())) {
            predicate = criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get(EntryEntity_.DUE_DATE), filter.getDueDateTo()));
        }
        return predicate;
    }
}
