package br.com.agencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agencia.model.Hospedagem;
import br.com.agencia.repository.HospedagemRepository;



	@CrossOrigin(origins = "*")
	@RestController
	@RequestMapping(value = "/hospedagem")
	public class hospedagemController {

		@Autowired
		private HospedagemRepository hospedagemRepository;
		
			// GET
			@GetMapping
			public ResponseEntity<List<Hospedagem>> findAll() {
				
				List<Hospedagem> hospedagens = hospedagemRepository.findAll();
				
				return ResponseEntity.ok().body(hospedagens);
			}			
		
		// GET por id
			@GetMapping(value = "/{id}")
			public ResponseEntity<Hospedagem> findById(@PathVariable Long id) {
				
				Hospedagem hospedagem = hospedagemRepository.findById(id).get();
				
				return ResponseEntity.ok().body(hospedagem);
			}
			
		// CREATE
	    @PostMapping
	    public Hospedagem create(@RequestBody Hospedagem hospedagem) {
	    	
	        return hospedagemRepository.save(hospedagem);
	    }
	    
	          
	    // UPDATE
	    @PutMapping("{id}")
	    public ResponseEntity<Hospedagem> update(@PathVariable long id,@RequestBody Hospedagem hospedagemDetails) {
	    	Hospedagem updateHospedagem = hospedagemRepository.findById(id).get();

	    	updateHospedagem.setNome(hospedagemDetails.getNome());
	    	

	        hospedagemRepository.save(updateHospedagem);

	        return ResponseEntity.ok(updateHospedagem);
	    }

	    // DELETE
	    @DeleteMapping("{id}")
	    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {

	    	Hospedagem hospedagem = hospedagemRepository.findById(id).get();

	    	hospedagemRepository.delete(hospedagem);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    }
	}