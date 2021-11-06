package com.devsuperior.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired //ESSA INSTANCIA repository VAI SER INJETADA AUTOMATICAMENTE PELO FRAMEWORK, NÃO SENDO NECESSÁRIO INSTANCIAR COM NEW
	private SaleRepository repository;
	
	@Autowired //EVITA INTERAÇÕES REPETIDAS AO BANCO DE DADOS
	private SellerRepository sellerRepository;	
	
	//CONSULTA PAGINADA DE VENDAS
	@Transactional(readOnly=true)
	public Page<SaleDTO> findAll(Pageable pageable){
		//EVITA INTERAÇÕES REPETIDAS AO BANCO DE DADOS	
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
}
