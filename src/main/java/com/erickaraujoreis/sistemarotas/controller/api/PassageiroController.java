package com.erickaraujoreis.sistemarotas.controller.api;

import com.erickaraujoreis.sistemarotas.model.Passageiro;
import com.erickaraujoreis.sistemarotas.service.PassageiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/passageiro")
public class PassageiroController {
	private static PassageiroService passageiroService;

	public PassageiroController(PassageiroService passageiroService){
		this.passageiroService = passageiroService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Passageiro> gePassageiro(@PathVariable Long id){
		Optional<Passageiro> passageiroOp = passageiroService.findById(id);
		if(passageiroOp.isPresent()){
			return ResponseEntity.ok().body(passageiroOp.get());
		}
		else{
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Passageiro>> getPassageiros(){
		List<Passageiro> passageiroList = passageiroService.findAll();
		if(passageiroList.size() > 0){
			return ResponseEntity.ok().body(passageiroList);
		}
		else{
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/")
	public ResponseEntity<Passageiro> update(@RequestBody Passageiro passageiro) {
		if(passageiro.getId() == null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Passageiro id = null");
		}
		passageiro = passageiroService.save(passageiro);
		return ResponseEntity.ok().body(passageiro);
	}

	@PostMapping("/")
	public ResponseEntity<Passageiro> create(@RequestBody Passageiro passageiro){
		if(passageiro.getId() != null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Passageiro can't exist.");
		}
		Passageiro result = passageiroService.save(passageiro);
		return ResponseEntity.ok().body(passageiro);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePassageiro(@PathVariable Long id){
		passageiroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
