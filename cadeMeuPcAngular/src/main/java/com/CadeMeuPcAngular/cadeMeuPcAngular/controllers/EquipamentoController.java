package com.CadeMeuPcAngular.cadeMeuPcAngular.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.CadeMeuPcAngular.cadeMeuPcAngular.exceptions.ResourceNotFoundException;
import com.CadeMeuPcAngular.cadeMeuPcAngular.models.Equipamento;
import com.CadeMeuPcAngular.cadeMeuPcAngular.repositories.EquipamentoRepository;

@RestController @CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class EquipamentoController {
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	@GetMapping("/Equipamentos")
	public List<Equipamento> todosEquipamentos(){
		return equipamentoRepository.findAll();
	}
	
	@GetMapping("/Equipamentos/{id}")
	public ResponseEntity<Equipamento> getEquipamentoById(@PathVariable(value = "id")long id) 
			throws ResourceNotFoundException{
		Equipamento equipamento = equipamentoRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Equipamento não encontrado por esse id:: "+ id));
		return ResponseEntity.ok().body(equipamento);
		
	}
	
	@PostMapping("/Equipamentos")
	public Equipamento criarQuarto(@Valid @RequestBody Equipamento equipamento) {
		return equipamentoRepository.save(equipamento);
	}
	
	@PutMapping("/Equipamentos/{id}")
	public ResponseEntity<Equipamento> updateEquipamento(@PathVariable (value = "id") long id,
			@Valid @RequestBody Equipamento equipamentoDetalhes) throws ResourceNotFoundException{
		Equipamento equipamento = equipamentoRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Equipamento não encontrado por esse id:: "+ id));
		equipamento.setEmpresa(equipamentoDetalhes.getEmpresa());
		equipamento.setResponsavel(equipamentoDetalhes.getResponsavel());
		final Equipamento equipamentoAtualizado = equipamentoRepository.save(equipamento);
		return ResponseEntity.ok(equipamentoAtualizado);
		
	}
	@DeleteMapping("/Equipamentos/{id}")
	public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
		Equipamento equipamento = equipamentoRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Equipamento não encontrado por esse id:: "+ id));
		equipamentoRepository.delete(equipamento);
		Map<String, Boolean> resposta = new HashMap<>();
		resposta.put("deletado", Boolean.TRUE);
		return resposta;
	}

}
