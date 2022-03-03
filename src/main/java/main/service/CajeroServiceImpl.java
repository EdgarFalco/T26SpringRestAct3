package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.ICajeroDao;
import main.dto.Cajero;

@Service
public class CajeroServiceImpl implements ICajeroService {

	@Autowired
	ICajeroDao iCajeroDao;

	@Override
	public List<Cajero> listarCajero() {
		
		return iCajeroDao.findAll();
	}
	
	@Override
	public Cajero cajeroXID(Integer codigo) {
		
		return iCajeroDao.findById(codigo).get();
	}

	@Override
	public Cajero guardarCajero(Cajero cajero) {
		
		return iCajeroDao.save(cajero);
	}

	@Override
	public Cajero actualizarCajero(Cajero cajero) {
		
		return iCajeroDao.save(cajero);
	}

	@Override
	public void eliminarCajero(Integer codigo) {
		
		iCajeroDao.deleteById(codigo);
	}
}
