package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Maquina;
import main.service.MaquinaServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinaController {

	@Autowired
	MaquinaServiceImpl maquinaServiceImpl;

	@GetMapping("/maquinas")
	public List<Maquina> listarMaquina() {
		return maquinaServiceImpl.listarMaquina();
	}
	
	@GetMapping("/maquinas/{id}")
	public Maquina maquinaXID(@PathVariable(name = "id") Integer codigo) {

		Maquina maquina_xid = new Maquina();

		maquina_xid = maquinaServiceImpl.maquinaXID(codigo);

		System.out.println("Maquina XID: " + maquina_xid);

		return maquina_xid;
	}

	@PostMapping("/maquinas")
	public Maquina salvarMaquina(@RequestBody Maquina maquina) {

		return maquinaServiceImpl.guardarMaquina(maquina);
	}

	@PutMapping("/maquinas/{id}")
	public Maquina actualizarMaquina(@PathVariable(name = "id") Integer codigo, @RequestBody Maquina maquina) {

		Maquina maquina_seleccionada = new Maquina();
		Maquina maquina_actualizada = new Maquina();

		maquina_seleccionada = maquinaServiceImpl.maquinaXID(codigo);
		
		maquina_seleccionada.setCodigo(maquina.getCodigo());

		maquina_actualizada = maquinaServiceImpl.actualizarMaquina(maquina_seleccionada);

		System.out.println("La maquina actualizada es: " + maquina_actualizada);

		return maquina_actualizada;
	}

	@DeleteMapping("/maquinas/{id}")
	public void eliminarMaquina(@PathVariable(name = "id") Integer codigo) {
		maquinaServiceImpl.eliminarMaquina(codigo);
	}
}
