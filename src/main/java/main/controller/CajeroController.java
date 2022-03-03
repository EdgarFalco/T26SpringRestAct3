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

import main.dto.Cajero;
import main.service.CajeroServiceImpl;

@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroServiceImpl cajeroServiceImpl;

	@GetMapping("/cajeros")
	public List<Cajero> listarCajero() {
		return cajeroServiceImpl.listarCajero();
	}
	
	@GetMapping("/cajeros/{id}")
	public Cajero cajeroXID(@PathVariable(name = "id") Integer codigo) {

		Cajero cajero_xid = new Cajero();

		cajero_xid = cajeroServiceImpl.cajeroXID(codigo);

		System.out.println("Cajero XID: " + cajero_xid);

		return cajero_xid;
	}

	@PostMapping("/cajeros")
	public Cajero salvarCajero(@RequestBody Cajero cajero) {

		return cajeroServiceImpl.guardarCajero(cajero);
	}

	@PutMapping("/cajeros/{id}")
	public Cajero actualizarCajero(@PathVariable(name = "id") Integer codigo, @RequestBody Cajero cajero) {

		Cajero cajero_seleccionada = new Cajero();
		Cajero cajero_actualizada = new Cajero();

		cajero_seleccionada = cajeroServiceImpl.cajeroXID(codigo);

		cajero_seleccionada.setNombre(cajero.getNombre());

		cajero_actualizada = cajeroServiceImpl.actualizarCajero(cajero_seleccionada);

		System.out.println("El cajero actualizado es: " + cajero_actualizada);

		return cajero_actualizada;
	}

	@DeleteMapping("/cajeros/{id}")
	public void eliminarCajero(@PathVariable(name = "id") Integer codigo) {
		cajeroServiceImpl.eliminarCajero(codigo);
	}
}
