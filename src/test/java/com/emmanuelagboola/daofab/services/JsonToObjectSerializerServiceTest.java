package com.emmanuelagboola.daofab.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.emmanuelagboola.daofab.dto.InstallmentDto;
import com.emmanuelagboola.daofab.dto.TransactionDto;
import com.emmanuelagboola.daofab.exceptions.DaofabException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class JsonToObjectSerializerServiceTest {
	
	private final static String TRANSACTIONS_FILE_NAME = "transactions.json";
	private final static String MALFORMED_INSTALLMENTS_FILE_NAME = "malformedinstallments.json";
	
	@InjectMocks
	@Autowired
	private JsonToObjectSerializerImpl jsonToObjectSerializerService;
	
	@Mock
	private ObjectMapper mapper;

	
	/*
	 * Test serializeTo functionality on JsonToObjectSerializer service
	 */
	@Test
	@DisplayName("Test serializeTo functionality on JsonToObjectSerializer service")
    public void serializeToMethod_onJsonToObjectSerializerServiceTest() throws DaofabException, JsonParseException, JsonMappingException, IOException {

		Resource resource  = new ClassPathResource(TRANSACTIONS_FILE_NAME);
		File file = resource.getFile();
		TransactionDto expectedTransactionDto =  new ObjectMapper().readValue(file , TransactionDto.class);
		
		when( mapper.readValue(  file,  TransactionDto.class  ) ).thenReturn(expectedTransactionDto);
		
		TransactionDto actualTransactionDto = (TransactionDto) jsonToObjectSerializerService.serializeTo(TransactionDto.class, resource);
		
		assertEquals(expectedTransactionDto.getData().size(), actualTransactionDto.getData().size()); //There are seven transactions in the specified resource file
		assertEquals(expectedTransactionDto.getData().get(0).getSender(), "CAT"); //first transaction in specified list sender name is CAT
		assertEquals(expectedTransactionDto.getData().get(6).getReceiver(), "PQRS");//last transaction in specified list receiver name is PQRS
		
    }
	
	
	/*
	 * Test serializeTo functionality on JsonToObjectSerializer service
	 * Expect an exception is thrown on malformed json parsed
	 */
	@Test
	@DisplayName("Test serializeTo functionality on JsonToObjectSerializer service")
    public void serializeToMethodThrowsExceptionOnMalformedJson_onJsonToObjectSerializerServiceTest() throws Exception {
		
		assertThrows( Exception.class, () ->{
			Resource resource  = new ClassPathResource(MALFORMED_INSTALLMENTS_FILE_NAME);
			File file = resource.getFile();
			
			when( mapper.readValue(  file,  InstallmentDto.class  ) ).thenThrow(DaofabException.class);
			jsonToObjectSerializerService.serializeTo(InstallmentDto.class, resource);
		}); 
		
    }

}
