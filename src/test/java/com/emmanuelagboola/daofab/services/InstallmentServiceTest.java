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

import com.emmanuelagboola.daofab.models.Installment;
import com.emmanuelagboola.daofab.models.Transaction;
import com.emmanuelagboola.daofab.repositories.InstallmentRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class InstallmentServiceTest {

	@InjectMocks
	@Autowired
	private InstallmentServiceImpl installmentService;
	
	@Mock
	private InstallmentRepository installmentRep;
	
	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeEach
	public void init() {
		reset(installmentRep);
	}
	
	/*
	 * Test saveInstallment installments functionality on Installment service given a list of installments
	 */
	@Test
	@DisplayName("Test installments service saves and returns a list installments")
    public void saveInstallmentsTest() {
    	
    	List<Installment> installments = new ArrayList<>();
    	installments.add(  new Installment(new Transaction("Daniel", "Emma", 1000L )  , 300));
    	installments.add(  new Installment(new Transaction("John", "Emma", 4000L )  , 1500));
    	
    	Iterable<Installment> expectedIterable = installments;
    	
    	when(installmentRep.saveAll( Mockito.anyIterable() )).thenReturn(expectedIterable);
    	
    	Iterable<Installment> actualResult = installmentService.saveInstallments(installments);
    	
    	assertEquals(StreamSupport.stream(expectedIterable.spliterator(), false).count(), StreamSupport.stream(actualResult.spliterator(), false).count());
    	assertEquals(expectedIterable.iterator().next().getPaidAmount(), actualResult.iterator().next().getPaidAmount());
    	assertEquals(expectedIterable.iterator().next().getPaidAmount(), actualResult.iterator().next().getPaidAmount());
    }
	
	/*
	 * Test saveInstallment functionality on installment service given a empty list of installments
	 */
	@Test
	@DisplayName("Test installments service thows an error when saving an empty list of installments")
    public void saveEmptyListOfTransactionsTest() {
    	
    	when(installmentRep.saveAll( (List<Installment>)new ArrayList<Installment>()  )).thenThrow(IllegalArgumentException.class);
    	
    	assertThrows(IllegalArgumentException.class, () -> {
    		installmentService.saveInstallments((List<Installment>)new ArrayList<Installment>());
    	});
    
    }
    
	/*
	 * Test saveInstallment functionality on Transaction service given a null list of transactions
	 */
	@Test
	@DisplayName("Test transaction service throw error an attempt to save a null transactions")
    public void saveNullListTransactionsTest() {
		
    	Iterable<Installment> expectedIterable = null;
    	
    	when(installmentRep.saveAll( expectedIterable) ).thenThrow(IllegalArgumentException.class);
    	
    	assertThrows(IllegalArgumentException.class, () -> {
    		installmentService.saveInstallments(null);
    	});

    }
}
