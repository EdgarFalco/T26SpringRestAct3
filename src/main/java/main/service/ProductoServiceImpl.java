package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IProductoDao;
import main.dto.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	IProductoDao iProductoDao;

	@Override
	public List<Producto> listarProducto() {
		
		return iProductoDao.findAll();
	}
	
	@Override
	public Producto productoXID(Integer codigo) {
		
		return iProductoDao.findById(codigo).get();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		
		return iProductoDao.save(producto);
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		
		return iProductoDao.save(producto);
	}

	@Override
	public void eliminarProducto(Integer codigo) {
		
		iProductoDao.deleteById(codigo);
	}
}