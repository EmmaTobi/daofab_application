package com.emmanuelagboola.daofab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuelagboola.daofab.models.Transaction;
import com.emmanuelagboola.daofab.repositories.TransactionRepository;

/*
 * Concrete class the handles operations related to the transaction models
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	
	private TransactionRepository transactionRepo;
	
	@Autowired
	public TransactionServiceImpl(TransactionRepository transactionRepo) {
		this.transactionRepo = transactionRepo;
	}

	/*
	 * @param Iterable<Transaction> list of transactions
	 * @return Iterable<Transaction> persisted list of transactions
	 */
	@Override
	public Iterable<Transaction> saveTransactions(Iterable<Transaction> transactions) {
		return transactionRepo.saveAll(transactions);
	}
	

}
