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

import main.dto.Producto;
import main.service.ProductoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoServiceImpl productoServiceImpl;

	@GetMapping("/productos")
	public List<Producto> listarProducto() {
		return productoServiceImpl.listarProducto();
	}
	
	@GetMapping("/productos/{id}")
	public Producto productoXID(@PathVariable(name = "id") Integer codigo) {

		Producto producto_xid = new Producto();

		producto_xid = productoServiceImpl.productoXID(codigo);

		System.out.println("Producto XID: " + producto_xid);

		return producto_xid;
	}

	@PostMapping("/productos")
	public Producto salvarProducto(@RequestBody Producto producto) {

		return productoServiceImpl.guardarProducto(producto);
	}

	@PutMapping("/productos/{id}")
	public Producto actualizarProducto(@PathVariable(name = "id") Integer codigo, @RequestBody Producto producto) {

		Producto producto_seleccionada = new Producto();
		Producto producto_actualizada = new Producto();

		producto_seleccionada = productoServiceImpl.productoXID(codigo);

		producto_seleccionada.setNombre(producto.getNombre());

		producto_actualizada = productoServiceImpl.actualizarProducto(producto_seleccionada);

		System.out.println("El Producto actualizado es: " + producto_actualizada);

		return producto_actualizada;
	}

	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable(name = "id") Integer codigo) {
		productoServiceImpl.eliminarProducto(codigo);
	}
}
