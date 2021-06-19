package com.emmanuelagboola.daofab;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import com.emmanuelagboola.daofab.dto.InstallmentDto;
import com.emmanuelagboola.daofab.dto.TransactionDto;
import com.emmanuelagboola.daofab.exceptions.DaofabException;
import com.emmanuelagboola.daofab.models.Installment;
import com.emmanuelagboola.daofab.models.Transaction;
import com.emmanuelagboola.daofab.services.InstallmentService;
import com.emmanuelagboola.daofab.services.JsonToObjectSerializer;
import com.emmanuelagboola.daofab.services.TransactionService;

@SpringBootApplication
public class DaofabApplication {
	
	/*
	 * @var Resource Transactions source
	 */
	@Value("${daofab.transactions.classpath.filename}")
	private Resource transactionsJsonResource;
	
	/*
	 * @var Resource Installments source
	 */
	@Value("${daofab.installments.classpath.filename}")
	private Resource installmentsJsonResource;
	
	/*
	 * @var TransactionService transactionService the transaction service that handles operations on a transaction
	 */
	private TransactionService transactionService;
	
	/*
	 * @var InstallmentService installmentService the installment service that handles operations on a installments
	 */
	private InstallmentService installmentService;
	
	/*
	 * @var JsonToObjectSerializer jsonToObjectSerializer thw service that handles operations about deserializing a json file into objects
	 */
	private JsonToObjectSerializer jsonToObjectSerializer;
	
	@Autowired
	public DaofabApplication(TransactionService transactionService, 
							 InstallmentService installmentService,
							 JsonToObjectSerializer jsonToObjectSerializer) {
		
		this.transactionService = transactionService;
		this.installmentService = installmentService;
		this.jsonToObjectSerializer = jsonToObjectSerializer;
	}

	public static void main(String[] args) {
		SpringApplication.run(DaofabApplication.class, args);
	}
	
	/*
	 * Initialize database on startup
	 * @throws Exception
	 */
	@PostConstruct
	public void initDb() throws Exception {
		initParentDb();
		initChildDb();
	}
	
	/*
	 * Initialize transactions table in database on startup
	 * @throws Exception
	 */
	private void initParentDb() throws DaofabException {
		Iterable<Transaction> transactions =  ((TransactionDto)jsonToObjectSerializer.serializeTo(TransactionDto.class, transactionsJsonResource)).getData();
		transactionService.saveTransactions(transactions);
	}
	
	/*
	 * Initialize installments table in database on startup
	 * @throws Exception
	 */
	private void initChildDb() throws DaofabException {
		Iterable<Installment> installments =  ((InstallmentDto)jsonToObjectSerializer.serializeTo(InstallmentDto.class, installmentsJsonResource)).getData();
		installmentService.saveInstallments(installments);
	}

}
