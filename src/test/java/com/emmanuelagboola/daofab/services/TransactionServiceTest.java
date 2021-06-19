package com.emmanuelagboola.daofab.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.emmanuelagboola.daofab.models.Transaction;
import com.emmanuelagboola.daofab.repositories.TransactionRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class TransactionServiceTest {

	@InjectMocks
	@Autowired
	private TransactionServiceImpl transactionService;
	
	@Mock
	private TransactionRepository transactionRep;
	
	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeEach
	public void init() {
		reset(transactionRep);
	}
	
	/*
	 * Test saveTransactions functionality on Transaction service given a list of transactions
	 */
	@Test
	@DisplayName("Test transaction service saves and returns a list transactions")
    public void saveTransactionsTest() {
    	
    	List<Transaction> transactions = new ArrayList<>();
    	transactions.add(  new Transaction("Daniel", "Emma", 1000L ) );
    	transactions.add(  new Transaction("Mary", "Joseph", 2300L ) );
    	transactions.add(  new Transaction("Vector", "Chang", 4500L ) );
    	
    	Iterable<Transaction> expectedIterable = transactions;
    	
    	when(transactionRep.saveAll( Mockito.anyIterable() )).thenReturn(expectedIterable);
    	
    	Iterable<Transaction> actualResult = transactionService.saveTransactions(transactions);
    	
    	assertEquals(StreamSupport.stream(expectedIterable.spliterator(), false).count(), StreamSupport.stream(actualResult.spliterator(), false).count());
    	assertEquals(expectedIterable.iterator().next().getSender(), actualResult.iterator().next().getSender());
    	assertEquals(expectedIterable.iterator().next().getReceiver(), actualResult.iterator().next().getReceiver());
    	assertEquals(expectedIterable.iterator().next().getTotalAmount(), actualResult.iterator().next().getTotalAmount());
    }
	
	/*
	 * Test saveTransactions functionality on Transaction service given a empty list of transactions
	 */
	@Test
	@DisplayName("Test transaction service thows an error when saving an empty list of transactions")
    public void saveEmptyListOfTransactionsTest() {
    	
    	when(transactionRep.saveAll( (List<Transaction>)new ArrayList<Transaction>()  )).thenThrow(IllegalArgumentException.class);
    	
    	assertThrows(IllegalArgumentException.class, () -> {
    		transactionService.saveTransactions((List<Transaction>)new ArrayList<Transaction>());
    	});
    
    }
    
	/*
	 * Test saveTransactions functionality on Transaction service given a null list of transactions
	 */
	@Test
	@DisplayName("Test transaction service throw error an attempt to save a null transactions")
    public void saveNullListTransactionsTest() {
		
    	Iterable<Transaction> expectedIterable = null;
    	
    	when(transactionRep.saveAll( expectedIterable) ).thenThrow(IllegalArgumentException.class);
    	
    	assertThrows(IllegalArgumentException.class, () -> {
    		transactionService.saveTransactions(null);
    	});

    }
}
