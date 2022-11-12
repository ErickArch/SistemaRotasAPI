package com.erickaraujoreis.sistemarotas.controller.api;

import com.erickaraujoreis.sistemarotas.model.Conta;
import com.erickaraujoreis.sistemarotas.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/conta")
public class ContaController {
	private static ContaService contaService;

	public ContaController(ContaService contaService){
		this.contaService = contaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Conta> geConta(@PathVariable Long id){
		Optional<Conta> contaOp = contaService.findById(id);
		if(contaOp.isPresent()){
			return ResponseEntity.ok().body(contaOp.get());
		}
		else{
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Conta>> getContas(){
		List<Conta> contaList = contaService.findAll();
		if(contaList.size() > 0){
			return ResponseEntity.ok().body(contaList);
		}
		else{
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/")
	public ResponseEntity<Conta> update(@RequestBody Conta conta) {
		if(conta.getId() == null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Conta id = null");
		}
		conta = contaService.save(conta);
		return ResponseEntity.ok().body(conta);
	}

	@PostMapping("/")
	public ResponseEntity<Conta> create(@RequestBody Conta conta){
		if(conta.getId() != null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Conta can't exist.");
		}
		Conta result = contaService.save(conta);
		return ResponseEntity.ok().body(conta);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteConta(@PathVariable Long id){
		contaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
