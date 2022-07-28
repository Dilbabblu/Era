package com.forsys.revmantra.validators;

import java.math.BigDecimal;

import com.forsys.revmantra.exceptions.AyaraCustomException;
import com.opencsv.bean.BeanField;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.processor.StringProcessor;
import com.opencsv.bean.validators.StringValidator;
import com.opencsv.exceptions.CsvValidationException;

public class NumberValidator implements StringValidator, StringProcessor{

	@Override
	public boolean isValid(String value) {
		return false;
	}

	@Override
	public void validate(String value, BeanField field) throws CsvValidationException {
		if(!value.isEmpty()) {
			try {
				new BigDecimal(value);
			}catch(Exception e){
				throw new AyaraCustomException(field.getField().getAnnotation(CsvBindByName.class).column() + " not in Numeric format - " + value);
			}
		}
	}
	
	@Override
	public String processString(String value) {
		return value.replace(",", "");
	}

	@Override
	public void setParameterString(String value) {
		//no implementation
	}
	


}
