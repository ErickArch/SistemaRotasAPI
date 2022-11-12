package com.erickaraujoreis.sistemarotas.controller.api;

import com.erickaraujoreis.sistemarotas.model.Trajeto;
import com.erickaraujoreis.sistemarotas.service.TrajetoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/trajeto")
public class TrajetoController {
	private static TrajetoService trajetoService;

	public TrajetoController(TrajetoService trajetoService){
		this.trajetoService = trajetoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Trajeto> geTrajeto(@PathVariable Long id){
		Optional<Trajeto> trajetoOp = trajetoService.findById(id);
		if(trajetoOp.isPresent()){
			return ResponseEntity.ok().body(trajetoOp.get());
		}
		else{
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Trajeto>> getTrajetos(){
		List<Trajeto> trajetoList = trajetoService.findAll();
		if(trajetoList.size() > 0){
			return ResponseEntity.ok().body(trajetoList);
		}
		else{
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/")
	public ResponseEntity<Trajeto> update(@RequestBody Trajeto trajeto) {
		if(trajeto.getId() == null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Trajeto id = null");
		}
		trajeto = trajetoService.save(trajeto);
		return ResponseEntity.ok().body(trajeto);
	}

	@PostMapping("/")
	public ResponseEntity<Trajeto> create(@RequestBody Trajeto trajeto){
		if(trajeto.getId() != null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Trajeto can't exist.");
		}
		Trajeto result = trajetoService.save(trajeto);
		return ResponseEntity.ok().body(trajeto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTrajeto(@PathVariable Long id){
		trajetoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
