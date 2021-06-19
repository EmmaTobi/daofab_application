package com.emmanuelagboola.daofab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuelagboola.daofab.models.Installment;
import com.emmanuelagboola.daofab.repositories.InstallmentRepository;

/*
 * Concrete class that handles operations related to the installment models
 */
@Service
public class InstallmentServiceImpl implements InstallmentService {
	
	private InstallmentRepository installmentRepository;
	
	@Autowired
	public InstallmentServiceImpl(InstallmentRepository installmentRepository) {
		this.installmentRepository = installmentRepository;
	}

	/*
	 * @param Iterable<Installment> list of installments
	 * @return Iterable<Installment> persisted list of installments
	 */
	@Override
	public Iterable<Installment> saveInstallments(Iterable<Installment> installments) {
		return installmentRepository.saveAll(installments);
	}

}
