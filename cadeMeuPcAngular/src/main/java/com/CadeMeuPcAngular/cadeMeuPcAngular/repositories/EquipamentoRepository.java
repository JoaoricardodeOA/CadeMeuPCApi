package com.CadeMeuPcAngular.cadeMeuPcAngular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CadeMeuPcAngular.cadeMeuPcAngular.models.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento,Long>{
	
}
