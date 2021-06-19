package com.emmanuelagboola.daofab.services;

import com.emmanuelagboola.daofab.models.Transaction;

/*
 * Interface encapsulating operations related to Transaction model
 */
public interface TransactionService {
	
	/*
	 * @param Iterable<Transaction> list of transactions
	 * @return Iterable<Transaction> persisted list of transactions
	 */
	Iterable<Transaction> saveTransactions(Iterable<Transaction> transactions);
}
