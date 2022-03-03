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

import main.dto.Venta;
import main.service.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	VentaServiceImpl ventaServiceImpl;

	@GetMapping("/ventas")
	public List<Venta> listarVenta() {
		return ventaServiceImpl.listarVenta();
	}
	
	@GetMapping("/ventas/{id}")
	public Venta ventaXID(@PathVariable(name = "id") Integer codigo) {

		Venta venta_xid = new Venta();

		venta_xid = ventaServiceImpl.ventaXID(codigo);

		System.out.println("Venta XID: " + venta_xid);

		return venta_xid;
	}

	@PostMapping("/ventas")
	public Venta salvarVenta(@RequestBody Venta venta) {

		return ventaServiceImpl.guardarVenta(venta);
	}

	@PutMapping("/ventas/{id}")
	public Venta actualizarVenta(@PathVariable(name = "id") Integer codigo, @RequestBody Venta venta) {

		Venta venta_seleccionada = new Venta();
		Venta venta_actualizada = new Venta();

		venta_seleccionada = ventaServiceImpl.ventaXID(codigo);
		
		venta_seleccionada.setCodigo(venta.getCodigo());

		venta_actualizada = ventaServiceImpl.actualizarVenta(venta_seleccionada);

		System.out.println("El venta actualizado es: " + venta_actualizada);

		return venta_actualizada;
	}

	@DeleteMapping("/ventas/{id}")
	public void eliminarVenta(@PathVariable(name = "id") Integer codigo) {
		ventaServiceImpl.eliminarVenta(codigo);
	}
}