package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.services.SellerService;

@RestController //INDICA QUE ESSA CLASSE É UM CONTROLADOR REST
@RequestMapping(value = "/sellers")//INDICA O CAMINHO DO RECURSO WEB EX: HTTP:/DEVSUP/sellers
public class SellerController {
	
	@Autowired
	private SellerService service; 
	
	/**
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll(){
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
}
