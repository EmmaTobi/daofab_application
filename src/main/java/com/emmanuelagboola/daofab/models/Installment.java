package com.emmanuelagboola.daofab.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Model representing an installment
 */
@Entity
public class Installment {

	public Installment() {
		
	}
	
	/*
	 * Two args constructor for Installment
	 * @param Transaction transaction a transaction associated with the instalmment payment
	 * @param long paidAmount the installment paid
	 */
	public Installment(Transaction transaction, long paidAmount) {
		this.transaction = transaction;
		this.paidAmount = paidAmount;
	}
	
	/*
	 * @var long id the primary identifier of the transaction
	 */
	@Id
	@JsonProperty("id")
	private long id;
	
	/*
	 * @var Transaction transaction the associated transaction 
	 */
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "parentId")
	private Transaction transaction;
	
	/*
	 * @var long paidAmount the amount paid 
	 */
	@Column
	@JsonProperty("paidAmount")
	private long paidAmount;

	/*
	 * @return long the primary identifier of an installment
	 */
	public long getId() {
		return id;
	}
	/*
	 * @return long id set the primary identifier of an installment
	 */
	public void setId(long id) {
		this.id = id;
	}

	/*
	 * @return long the associated transaction of an installment
	 */
	public Transaction getTransaction() {
		return transaction;
	}

	/*
	 * @param long transaction set the associated transaction of an installment
	 */
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	/*
	 * @return long the amount paid in installment
	 */
	public long getPaidAmount() {
		return paidAmount;
	}

	/*
	 * @param long the amount paid in installment
	 */
	public void setPaidAmount(long paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	/*
	 * Set the parentId/transaction id of an installment
	 * @param Integer the id of associated transaction
	 */
	@JsonProperty("parentId")
	private void setParentId(Integer parentId) {
	    this.transaction = new Transaction();
	    transaction.setId(parentId);
	}

	@Override
	public String toString() {
		return "Child [id=" + id + ", parentId=" + transaction + ", paidAmount=" + paidAmount + "]";
	}
	
}
