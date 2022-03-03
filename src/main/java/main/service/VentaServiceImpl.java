package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IVentaDao;
import main.dto.Venta;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	IVentaDao iVentaDao;

	@Override
	public List<Venta> listarVenta() {
		
		return iVentaDao.findAll();
	}
	
	@Override
	public Venta ventaXID(Integer codigo) {
		
		return iVentaDao.findById(codigo).get();
	}

	@Override
	public Venta guardarVenta(Venta venta) {
		
		return iVentaDao.save(venta);
	}

	@Override
	public Venta actualizarVenta(Venta venta) {
		
		return iVentaDao.save(venta);
	}

	@Override
	public void eliminarVenta(Integer codigo) {
		
		iVentaDao.deleteById(codigo);
	}
}