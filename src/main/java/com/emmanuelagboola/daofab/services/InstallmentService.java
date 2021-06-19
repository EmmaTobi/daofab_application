package com.emmanuelagboola.daofab.services;

import com.emmanuelagboola.daofab.models.Installment;

/*
 * Interface encapsulating operations related to Installment model
 */
public interface InstallmentService {
	
	/*
	 * @param Iterable<Installment> list of installments
	 * @return Iterable<Installment> persisted list of installments
	 */
	public Iterable<Installment> saveInstallments(Iterable<Installment> installments);
}
