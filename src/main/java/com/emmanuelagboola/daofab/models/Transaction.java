package com.emmanuelagboola.daofab.models;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Model representing a transaction
 */
@Entity
public class Transaction {

	/*
	 * Id of the transaction
	 */
	@Id
    @JsonProperty("id")
	private long id;
	
	/*
	 * sender of the transaction
	 */
	@Column
    @JsonProperty("sender")
	private String sender;
	
	/*
	 * Receiver of the transaction
	 */
	@Column
    @JsonProperty("receiver")
	private String receiver;
	
	/*
	 * Total amount expected to be paid for a transaction
	 */
	@Column
	private long totalAmount;

	/*
	 * Installlments paid on a transaction
	 */
	@OneToMany(mappedBy = "transaction")
	private List<Installment> installments;

	/*
	 * No Args Transaction Constructor
	 */
	public Transaction() {}
	/*
	 * Transaction Constructor with three args
	 * @param String sender the sender who initiated the transaction
	 * @param String receiver the receiver who receives the amount paid by a sender
	 * @param Long totalAmount the total amount paid by the sender
	 * @return long receiver the receiver of a transaction
	 */
	public Transaction(String sender, String receiver, Long totalAmount) {
		this.sender = sender;
		this.receiver = receiver;
		this.totalAmount = totalAmount;
	}
	
	/*
	 * Getter method to get the Id of the transaction
	 * @return long receiver the receiver of a transaction
	 */
	public long getId() {
		return id;
	}

	/*
	 * Setter method to set the id of the transaction
	 * @param long id the id of a transaction
	 */
	public void setId(long id) {
		this.id = id;
	}

	/*
	 * Getter method to get the sender of the transaction
	 * @return String the sender of current transaction
	 */
	public String getSender() {
		return sender;
	}

	/*
	 * Setter method to set the sender of the transaction
	 * @return String sender the sender of a transaction
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/*
	 * Getter method to get the receiver of the transaction
	 * @return String the receiver 
	 */
	public String getReceiver() {
		return receiver;
	}

	/*
	 * Setter method to set the receiver of the transaction
	 * @param String receiver the receiver of a transaction
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/*
	 * Getter method to get the total amount of the transaction
	 * return long the total amount tp be paid on a transacton
	 */
	public long getTotalAmount() {
		return totalAmount;
	}

	/*
	 * Setter method to set the total amount of the transaction
	 * @param long totalAmount the total amount tp be paid on a transacton
	 */
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	/*
	 * Getter method to set the total installments paid on a transaction
	 * @return List<Installment> list of installments paid
	 */
	public List<Installment> getInstallments() {
		return installments;
	}

	/*
	 * Setter method to set the total installments paid on a transaction
	 * @param List<Installment> child the list of installments paid
	 */
	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}

	/*
	 * To get the total installments paid on a transaction
	 */
	public Long getTotalPaidAmount() {
		Optional<Long> optionalAmounts = installments.stream().map((installment)-> installment.getPaidAmount()).reduce(Long::sum);
		return optionalAmounts.orElse(0L);
	}

	/*
	 * Get the String representation of the entity
	 */
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", totalAmount=" + totalAmount
				+ ", installments=" + installments + "]";
	}
	
}
