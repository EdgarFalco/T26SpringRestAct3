package main.service;

import java.util.List;

import main.dto.Maquina;

public interface IMaquinaService {

	public List<Maquina> listarMaquina();
	
	public Maquina maquinaXID(Integer codigo);

	public Maquina guardarMaquina(Maquina maquina);	

	public Maquina actualizarMaquina(Maquina maquina);

	public void eliminarMaquina(Integer codigo);
}
