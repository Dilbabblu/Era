package com.forsys.revmantra.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

public class BaseSpecificationBuilder<T> {
	
	 private final List<SearchCriteria> params;
	 
	 private final Class<T> genericTypeClass;
	 
	 
	    public BaseSpecificationBuilder(Class<T> genericTypeClass) {
	        params = new ArrayList<>();
	        this.genericTypeClass = genericTypeClass;
	    }
	 
	    public BaseSpecificationBuilder<T> with(String key, String operation, Object value) {
	        params.add(new SearchCriteria(key, operation, value));
	        return this;
	    }
	 
	    public Specification<T> build() {
	        if (params.isEmpty()) {
	            return null;
	        }
	 
	        List<Specification<T>> specs = new ArrayList<>();
	        for (SearchCriteria param : params) {
	            specs.add(new BaseSpecification<>(param,this.genericTypeClass));
	        }
	 
	        Specification<T> result = specs.get(0);
	        for (int i = 1; i < specs.size(); i++) {
	            result = Specification.where(result).and(specs.get(i));
	        }
	        return result;
	    }
	    
}
