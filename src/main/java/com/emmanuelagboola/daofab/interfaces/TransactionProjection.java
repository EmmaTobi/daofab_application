package com.emmanuelagboola.daofab.interfaces;

import org.springframework.data.rest.core.config.Projection;

import com.emmanuelagboola.daofab.models.Transaction;

/*
 * A projection of Transaction model for presentation in json format
 */
@Projection(name = "customTransaction", types = { Transaction.class }) 
public interface TransactionProjection {

	
	/*
	 * @param Long Get the Total installments paid for a tarnsaction
	 */
	 Long getTotalPaidAmount(); 

	/*
	 * @return String the sender name/id for a transaction
	 */
	 String getSender() ;
	
	/*
	 * @return String the receiver for a transaction
	 */
	 String getReceiver() ;
	
	/*
	 * @return Long the total installments paid for a given transaction
	 */
	 Long getTotalAmount();
	
}
