package com.emmanuelagboola.daofab.dto;

import java.util.List;

import com.emmanuelagboola.daofab.models.Installment;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Installment model Data to Object Wrapper
 */
public class InstallmentDto {
	
	/*
	 * @var List<Installment> data list of installments
	 */
    @JsonProperty("data")
	private List<Installment> data;

	/*
	 * @return List<Installment> list of installments
	 */
	public List<Installment> getData() {
		return data;
	}

	/*
	 * @param List<Installment> list of installments
	 */
	public void setData(List<Installment> data) {
		this.data = data;
	}

}
