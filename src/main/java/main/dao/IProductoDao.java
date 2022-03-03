package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Producto;


public interface IProductoDao extends JpaRepository<Producto, Integer> {

}
