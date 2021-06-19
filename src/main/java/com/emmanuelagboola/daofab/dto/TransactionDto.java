package com.emmanuelagboola.daofab.dto;

import java.util.List;

import com.emmanuelagboola.daofab.models.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Transaction model Data to Object Wrapper
 */
public class TransactionDto {
	
	/*
	 * @var List<Transaction> data list of transactions
	 */
    @JsonProperty("data")
	private List<Transaction> data;

	/*
	 * @return List<Transaction> list of transactions
	 */
	public List<Transaction> getData() {
		return data;
	}

	/*
	 * @param List<Transaction> list of transactions
	 */
	public void setData(List<Transaction> data) {
		this.data = data;
	}

}
