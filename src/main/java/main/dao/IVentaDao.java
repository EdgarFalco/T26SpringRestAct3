package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Venta;

public interface IVentaDao extends JpaRepository<Venta, Integer> {

}
