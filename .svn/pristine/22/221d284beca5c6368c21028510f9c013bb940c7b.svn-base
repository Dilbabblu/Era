package com.forsys.revmantra.cpk.id;

import java.io.Serializable;
import java.sql.Timestamp;

public class ConversionRatesPkId implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fromCurrency;
	private String toCurrency;
	private Timestamp conversionDate;
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public Timestamp getConversionDate() {
		return conversionDate;
	}
	public void setConversionDate(Timestamp conversionDate) {
		this.conversionDate = conversionDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conversionDate == null) ? 0 : conversionDate.hashCode());
		result = prime * result + ((fromCurrency == null) ? 0 : fromCurrency.hashCode());
		result = prime * result + ((toCurrency == null) ? 0 : toCurrency.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConversionRatesPkId other = (ConversionRatesPkId) obj;
		if (conversionDate == null) {
			if (other.conversionDate != null)
				return false;
		} else if (!conversionDate.equals(other.conversionDate))
			return false;
		if (fromCurrency == null) {
			if (other.fromCurrency != null)
				return false;
		} else if (!fromCurrency.equals(other.fromCurrency))
			return false;
		if (toCurrency == null) {
			if (other.toCurrency != null)
				return false;
		} else if (!toCurrency.equals(other.toCurrency))
			return false;
		return true;
	}
	
	
	
	
}
