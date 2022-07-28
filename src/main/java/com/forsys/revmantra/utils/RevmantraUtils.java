package com.forsys.revmantra.utils;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.domain.Specification;

import com.forsys.revmantra.listener.BaseListener;
import com.forsys.revmantra.specification.BaseSpecificationBuilder;

public class RevmantraUtils {
	
	private static Properties prop=null;
	
	public static final String SEARCH_PATTERN = "([\\S\\s]+?)([:<>=])([\\S\\s]+?),";
	
	private static final String DATE_PATTERN1 =  "dd/MM/yyyy";
	private static final String DATE_PATTERN2 = "yyyyMMdd";
	
	private static final Logger logger = LogManager.getLogger(RevmantraUtils.class);
	
	private RevmantraUtils() {
		
	}
	
	public static void createLog(EntityManager entityManager,String entityName,
			String columnName,String operation,String recid,String recname,String username){
		
		StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("RMAN_UESR_LOG_AUDIT_PROC")
				.registerStoredProcedureParameter("p_user_id", BigDecimal.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_modfied_date", Timestamp.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_entity_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_col_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_old_val", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_new_val", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_operation", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_recid", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_recname", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_username", String.class, ParameterMode.IN);
		storedProcedure.setParameter("p_user_id", BaseListener.getCurrentUserId());
		storedProcedure.setParameter("p_modfied_date", new Timestamp(System.currentTimeMillis()));
		storedProcedure.setParameter("p_entity_name", entityName);
		storedProcedure.setParameter("p_col_name", columnName);
		storedProcedure.setParameter("p_old_val", "");
		storedProcedure.setParameter("p_new_val", "");
		storedProcedure.setParameter("p_operation", operation);
		storedProcedure.setParameter("p_recid", recid);
		storedProcedure.setParameter("p_recname", recname);
		storedProcedure.setParameter("p_username", username);
		storedProcedure.execute();

	}

	
	public static Timestamp getTime(String dateValue) {
		OffsetDateTime odt = OffsetDateTime.parse(dateValue);
		Instant instant = odt.toInstant();
		return Timestamp.from(instant);
	}
	
	public static String getFormat(String o){
		
		 List<SimpleDateFormat> dateFormats = new ArrayList<>();
		     dateFormats.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS"));
		     dateFormats.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS XXX"));
		     dateFormats.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
		     dateFormats.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss XXX"));
		     dateFormats.add(new SimpleDateFormat("yyyyMMddHHmmss"));
			 dateFormats.add(new SimpleDateFormat("dd-MMM-yyyy"));
		     dateFormats.add(new SimpleDateFormat("yyyy/MM/dd"));
		     dateFormats.add(new SimpleDateFormat("yyyy-MM-dd"));
		     dateFormats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		     dateFormats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss XXX"));
		     dateFormats.add(new SimpleDateFormat(DATE_PATTERN2));
		     dateFormats.add(new SimpleDateFormat("MM/dd/yyyy"));
		     dateFormats.add(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"));
		     dateFormats.add(new SimpleDateFormat("MM-dd-yyyy"));
		     dateFormats.add(new SimpleDateFormat("MM-dd-yyyy HH:mm:ss"));
		     dateFormats.add(new SimpleDateFormat("MM/dd/yy"));
		     dateFormats.add(new SimpleDateFormat("MM-dd-yy"));
		     dateFormats.add(new SimpleDateFormat(DATE_PATTERN1));
		     dateFormats.add(new SimpleDateFormat("dd-MMM-yy"));
		     dateFormats.add(new SimpleDateFormat("dd-MM-yy"));
		     dateFormats.add(new SimpleDateFormat("dd-MM-yyyy"));
		     dateFormats.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
		     for (SimpleDateFormat format : dateFormats) {
		         try {
		             format.setLenient(false);
		          format.parse(o);
		         return format.toPattern();
		         } catch (ParseException e) {
		        	 logger.error("Error occurred in getFormat method: {}", e.getMessage());
		         }
		     }
		return "null";
		   
		 }
	
	public static Timestamp convertStringtoTimestamp(String pDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN2);
		try {
			if (!pDate.isEmpty() || pDate.length() > 0) {
				Date date = dateFormat.parse(pDate);
				return new Timestamp(date.getTime());
			} else {
				return null;
			}

		} catch (ParseException e) {
			return null;
		}

	}
	
	public static Timestamp getDateValue(String o){
		
		 List<DateFormat> dateFormats = new ArrayList<>();
		 	 dateFormats.add(new SimpleDateFormat("yyyy-MM-dd"));
		 	 dateFormats.add(new SimpleDateFormat("MM/dd/yy"));
		 	 dateFormats.add(new SimpleDateFormat("MM-dd-yy"));
		 	 dateFormats.add(new SimpleDateFormat("dd-MMM-yy"));
		 	 dateFormats.add(new SimpleDateFormat("dd-MM-yy"));
		     dateFormats.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS"));
		     dateFormats.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS XXX"));
		     dateFormats.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
		     dateFormats.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss XXX"));
		     dateFormats.add(new SimpleDateFormat("yyyyMMddHHmmss"));
			 dateFormats.add(new SimpleDateFormat("yyyy/MM/dd"));
		     
		     dateFormats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		     dateFormats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss XXX"));
		     dateFormats.add(new SimpleDateFormat(DATE_PATTERN2));
		     dateFormats.add(new SimpleDateFormat("MM/dd/yyyy"));
		     dateFormats.add(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"));
		     dateFormats.add(new SimpleDateFormat("MM-dd-yyyy"));
		     dateFormats.add(new SimpleDateFormat("MM-dd-yyyy HH:mm:ss"));
		     
		     dateFormats.add(new SimpleDateFormat(DATE_PATTERN1));
		     
		     dateFormats.add(new SimpleDateFormat("dd-MMM-yyyy"));
		     
		     dateFormats.add(new SimpleDateFormat("dd-MM-yyyy"));
		     dateFormats.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
		     for (DateFormat format : dateFormats) {
		    	 try {
		    		format.setLenient(false);
		            DateFormat sdff = new SimpleDateFormat(DATE_PATTERN1);
		            String date = sdff.format(format.parse(o));
			        Date d = sdff.parse(date);
					return new Timestamp(d.getTime());
					
		         } catch (ParseException e) {
		        	 logger.error("Error occurred in getDateValue method: {}", e.getMessage());
		        	 continue; //#AYAR-1816 Added continue command without exist from for loop to process rest of the formats to process
		         }
		     }
		     return null;
		}
	
   	public static String getProperty(String key) {
        if (prop == null) {
            try {
                prop = new Properties();
                InputStream inputStream = RevmantraUtils.class.getClassLoader().getResourceAsStream("META-INF/application.properties");
                prop.load(inputStream);
            }
            catch (Exception e) {
                return null;
            }
        }
        return prop.getProperty(key);
    }
   	
   	public static <T> Specification<T> fetchSpecification(Class<T> paramClass,String search) {
		BaseSpecificationBuilder<T> builder = new BaseSpecificationBuilder<>(paramClass);
	    Pattern pattern = Pattern.compile(SEARCH_PATTERN);
	    Matcher matcher = pattern.matcher(search + ",");
	
	    while (matcher.find()) {
	        builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
	    }
	    
	    return builder.build();
	}

}

