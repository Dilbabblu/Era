package com.forsys.revmantra.specification;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.domain.Specification;

import com.forsys.revmantra.model.AyaraSspGroupingRules;
import com.forsys.revmantra.model.RmanArrangementsAllV;
import com.forsys.revmantra.model.RmanEntityParametersV;
import com.forsys.revmantra.model.RmanLookupsV;
import com.forsys.revmantra.utils.CONSTANTS;

public class BaseSpecification<T> implements Specification<T> {

	private static final Logger logger = LogManager.getLogger(BaseSpecification.class);
	
	private static final long serialVersionUID = 1L;
	
	private SearchCriteria criteria;
	
	private final Class<T> genericTypeClass;
	
	public BaseSpecification(SearchCriteria criteria, Class<T> genericTypeClass) {
	 
	        this.criteria = criteria;
	        
	        this.genericTypeClass = genericTypeClass;
	
	}
    
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
    	// logger.info("Entered the Search Crietria into Predicate");
    	
    	if(this.genericTypeClass.isInstance(new RmanArrangementsAllV())) {
    		final List<Predicate> predicates = new ArrayList<>();
    		try {
    			if (criteria.getOperation().equalsIgnoreCase(">") && criteria.getKey().equalsIgnoreCase("startDate")) {
    				predicates.add(builder.greaterThanOrEqualTo(root.get(CONSTANTS.CREATION_DATE), fetchDate(criteria)));
    			}
    			if (criteria.getOperation().equalsIgnoreCase("<") && criteria.getKey().equalsIgnoreCase("endDate")) {
    				predicates.add(builder.lessThanOrEqualTo(root.get(CONSTANTS.CREATION_DATE), fetchDate(criteria)));
    			}

    			if (criteria.getOperation().equalsIgnoreCase(">") && criteria.getKey().equalsIgnoreCase("modStartDate")) {
    				predicates.add(builder.greaterThanOrEqualTo(root.get(CONSTANTS.LAST_ARRG_MODIFIED_DATE), fetchDate(criteria)));
    			}

    			if (criteria.getOperation().equalsIgnoreCase("<") && criteria.getKey().equalsIgnoreCase("modEndDate")) {
    				predicates.add(builder.lessThanOrEqualTo(root.get(CONSTANTS.LAST_ARRG_MODIFIED_DATE), fetchDate(criteria)));
    			}

    			if (criteria.getOperation().equalsIgnoreCase(">") && criteria.getKey().equalsIgnoreCase("lUpdateDate")) {
    				predicates.add(builder.greaterThanOrEqualTo(root.get(CONSTANTS.LAST_UPDATED_DATE), fetchDateFromTimestamp(criteria)));
    			}

    			if (criteria.getOperation().equalsIgnoreCase("<") && criteria.getKey().equalsIgnoreCase("lUpdateDate")) {
    				predicates.add(builder.lessThanOrEqualTo(root.get(CONSTANTS.LAST_UPDATED_DATE), fetchDateFromTimestamp(criteria)));
    			}

    			if (criteria.getOperation().equalsIgnoreCase("=") && criteria.getKey().equalsIgnoreCase("globalSearch")) {
    				Predicate p1 = builder.like(builder.upper(root.get("arrangementNumber")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");
    				Predicate p2 = builder.like(builder.upper(root.get("groupingRule")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");
    				Predicate p3 = builder.like(builder.upper(root.get("dealNum")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");
    				Predicate p4 = builder.like(builder.upper(root.get("projectNumber")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");
    				Predicate p5 = builder.like(builder.upper(root.get("dealNumber")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");
    				Predicate p6 = builder.like(builder.upper(root.get("customerPoNum")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");

    				Predicate p7 = null;
    				Predicate p12 = null;
    				String regex = "[0-9]+";
    				Pattern p = Pattern.compile(regex);
    				Matcher m = p.matcher(criteria.getValue().toString());
    				if (m.matches()) {
    					p7 = builder.equal(root.get("orderNumber"), new BigDecimal(criteria.getValue().toString()));
    					p12 = builder.equal(root.get("arrangementTotal"), new BigDecimal(criteria.getValue().toString()));
    				}

    				Predicate p8 = builder.like(builder.upper(root.get("endCustomerName")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");
    				Predicate p9 = builder.like(builder.upper(root.get("endCustomerNumber")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");
    				Predicate p10 = builder.like(builder.upper(root.get("legalEntityName")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");
    				Predicate p11 = builder.like(builder.upper(root.get("arrangementCurrency")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");
    				Predicate p14 = builder.like(builder.upper(root.get("arrangementSource")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");
    				Predicate p15 = builder.like(builder.upper(root.get("contApplied")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");
    				Predicate p16 = builder.like(builder.upper(root.get("arrangementType")),
    						"%" + criteria.getValue().toString().toUpperCase() + "%");

    				if (p7 != null && p12 != null)
    					predicates.add(builder.or(p1, p2, p3, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p14, p15, p16));
    				else
    					predicates.add(builder.or(p1, p2, p3, p3, p4, p5, p6, p8, p9, p10, p11, p14, p15, p16));
    			}

    			if (criteria.getOperation().equalsIgnoreCase(":")) {
    				if (!criteria.getKey().equalsIgnoreCase(CONSTANTS.CREATION_DATE)
    						&& !criteria.getKey().equalsIgnoreCase(CONSTANTS.LAST_UPDATED_DATE)
    						&& !criteria.getKey().equalsIgnoreCase(CONSTANTS.LAST_ARRG_MODIFIED_DATE)) {
    					if (root.get(criteria.getKey()).getJavaType() == String.class) {
    						predicates.add(builder.like(builder.upper(root.<String>get(criteria.getKey())),
    								"%" + criteria.getValue().toString().toUpperCase() + "%"));
    					} else {
    						predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
    					}
    				} else {
    					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(criteria.getValue().toString());
    					Timestamp ts = new Timestamp(date.getTime());
    					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
    					predicates.add(builder.equal(root.get(criteria.getKey()), formatter.format(ts)));
    				}
    			}
    		} catch (Exception e) {
    			logger.error(e);
    		}
    		return builder.and(predicates.toArray(new Predicate[predicates.size()]));
    	} else {
    	      if (criteria.getOperation().equalsIgnoreCase(">")) {
    	    	  	if (root.get(criteria.getKey()).getJavaType() == Timestamp.class) {
						try {
							return builder.greaterThanOrEqualTo(root.<Timestamp> get(criteria.getKey()), new Timestamp(
									new SimpleDateFormat("yyyyMMdd").parse(criteria.getValue().toString()).getTime()));
						} catch (ParseException e) {
							logger.error(e);
						}
					} else{
						return builder.greaterThanOrEqualTo(root.<String> get(criteria.getKey()),
								criteria.getValue().toString());
					}
		            
		        } 
		        else if (criteria.getOperation().equalsIgnoreCase("<")) {
		        	if (root.get(criteria.getKey()).getJavaType() == Timestamp.class) {
						try {
							return builder.lessThanOrEqualTo(root.<Timestamp> get(criteria.getKey()), new Timestamp(
									new SimpleDateFormat("yyyyMMdd").parse(criteria.getValue().toString()).getTime()));
						} catch (ParseException e) {
							logger.error(e);
						}
					} else {
						return builder.lessThanOrEqualTo(root.<String> get(criteria.getKey()), criteria.getValue().toString());
					}
		        } 
		        else if (criteria.getOperation().equalsIgnoreCase(":")) {
		        		if (root.get(criteria.getKey()).getJavaType() == String.class) {
			        		if(this.genericTypeClass.isInstance(new RmanEntityParametersV()) ||
			        		   this.genericTypeClass.isInstance(new AyaraSspGroupingRules()) ||
			        		   this.genericTypeClass.isInstance(new RmanLookupsV())
			        		  ) {
			        			return builder.equal(root.get(criteria.getKey()), criteria.getValue());
			        		   }
			                return builder.like(
			                        builder.upper(root.<String>get(criteria.getKey())), "%" + criteria.getValue().toString().toUpperCase() + "%");
			            } else {
			                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
			            }
		        }
    	}
    	return null;
    }
    
    public static Date fetchDate(SearchCriteria criteria) {
    	Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(criteria.getValue().toString());
			return date;
		} catch (ParseException e) {
			logger.error(e);
			return null;
		}
    }
    
    public static Date fetchDateFromTimestamp(SearchCriteria criteria) {

		Date date = null;
		try {
			Timestamp lut = new Timestamp(Long.parseLong(criteria.getValue().toString()));
			date = new Date(lut.getTime());
			return date;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
    }

}
