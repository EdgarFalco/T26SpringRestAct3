package main.service;

import java.util.List;

import main.dto.Producto;

public interface IProductoService {
	
	public List<Producto> listarProducto();
	
	public Producto productoXID(Integer codigo);

	public Producto guardarProducto(Producto cajero);	

	public Producto actualizarProducto(Producto cajero);

	public void eliminarProducto(Integer codigo);

}
