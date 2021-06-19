#  DAOFAB APPLICATION

######  TO RUN APPLICATION 
1)	Clone project, navigate to the root folder of your newly cloned project

2)  Run mvn spring-boot:run if using terminal/command_line to run your app

3)  Assuming you are on your local machine and u served your application with default port 8080
	your **APP_BASE_URL is http://localhost:8080/**
	
4)  To get all transactions navigate to **APP_BASE_URL/api/v1/transactions** in your browser

5)  To get all transactions by pagination of two per page starting from first page 
	navigate to **APP_BASE_URL/api/v1/transactions?page=0&size=2** in your browser
	
6)  To get all transactions by pagination of two records per page starting from first page and sorted by Id in Ascending order
navigate to **APP_BASE_URL/api/v1/transactions?page=0&size=2&sort=id,ASC**  in your browser

7)  To get all transactions by pagination of two records per page starting from first page and sorted by Id in Descending order
	navigate to **APP_BASE_URL/api/v1/transactions?page=0&size=2&sort=id,DESC**  in your browser
	
8)  To get all installments paid on a transaction with transaction id of 2
	navigate to **APP_BASE_URL/api/v1/transactions/2/installments**  in your browser
	
9)  Thanks you! 
	