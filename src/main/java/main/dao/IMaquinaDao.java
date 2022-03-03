package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Maquina;

public interface IMaquinaDao extends JpaRepository<Maquina, Integer> {

}
