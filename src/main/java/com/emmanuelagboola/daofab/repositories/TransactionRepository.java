package com.emmanuelagboola.daofab.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.emmanuelagboola.daofab.interfaces.TransactionProjection;
import com.emmanuelagboola.daofab.models.Transaction;

/*
 * Transaction Repository 
 */
@RepositoryRestResource(excerptProjection = TransactionProjection.class)
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
	 
}
