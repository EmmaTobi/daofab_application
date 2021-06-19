package com.emmanuelagboola.daofab.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.emmanuelagboola.daofab.models.Installment;

/*
 * InstallmentRepository
 */
@RepositoryRestResource
public interface InstallmentRepository extends PagingAndSortingRepository<Installment, Long>{

}
