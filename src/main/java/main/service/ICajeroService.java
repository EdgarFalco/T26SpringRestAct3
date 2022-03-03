package main.service;

import java.util.List;

import main.dto.Cajero;

public interface ICajeroService {
	
	public List<Cajero> listarCajero();
	
	public Cajero cajeroXID(Integer codigo);

	public Cajero guardarCajero(Cajero cajero);	

	public Cajero actualizarCajero(Cajero cajero);

	public void eliminarCajero(Integer codigo);

}
