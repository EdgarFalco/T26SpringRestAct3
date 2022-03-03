package main.service;

import java.util.List;

import main.dto.Venta;

public interface IVentaService {
	
	public List<Venta> listarVenta();
	
	public Venta ventaXID(Integer codigo);

	public Venta guardarVenta(Venta venta);	

	public Venta actualizarVenta(Venta venta);

	public void eliminarVenta(Integer codigo);

}
