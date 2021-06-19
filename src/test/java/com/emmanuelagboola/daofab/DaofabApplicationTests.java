package com.emmanuelagboola.daofab;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.emmanuelagboola.daofab.exceptions.DaofabException;

import io.restassured.RestAssured;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DaofabApplicationTests {
	
	private final static String APP_BASE_URL = "http://localhost";

	private static final String GET_ALL_TRANSACTIONS_URL = "api/v1/transactions";

	private static final String GET_ALL_INSTALLMENTS_PAID_FOR_A_TRANSACTIONS_URL = "api/v1/transactions/1/installments";
	
	@LocalServerPort
	private int port;
	
    @BeforeAll
    void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = APP_BASE_URL;
        RestAssured.port = port;
    }
    
    /**
     * Test to ensure all transactions are gotten
     * @throws DaofabException 
     */
    @Test
    @DisplayName("Get All Transactions")
    void getAllTransactionTests() throws DaofabException {
        given()
        .when()
                .get(DaofabApplicationTests.GET_ALL_TRANSACTIONS_URL)
        .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
        .and()
                .header("Content-Type", "application/hal+json")
        .and()
                .body("_embedded.transactions[0].receiver", equalTo("DOG"))
		        .body("_embedded.transactions[0].totalAmount", equalTo(200))
		        .body("_embedded.transactions[0].sender", equalTo("CAT"));
    }
    
    /**
     * Test to show post method to route is not supported
     * @throws DaofabException 
     */
    @Test
    @DisplayName("Post All Transactions")
    void postAllTransactionTests() throws DaofabException {
        given()
        .when()
                .post(DaofabApplicationTests.GET_ALL_TRANSACTIONS_URL)
        .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }
    
    /**
     * Test to ensure all installments are gottent for a transaction
     * @throws DaofabException 
     */
    @Test
    @DisplayName("Get All Installments for a transaction")
    void getAllInstallmentsPaidForATransactionTests() throws DaofabException {
        given()
        .when()
                .get(DaofabApplicationTests.GET_ALL_INSTALLMENTS_PAID_FOR_A_TRANSACTIONS_URL)
        .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
        .and()
                .header("Content-Type", "application/hal+json")
        .and()
		        .body("_embedded.installments.size()", equalTo(3));
    }

}
