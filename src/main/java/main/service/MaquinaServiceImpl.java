package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IMaquinaDao;
import main.dto.Maquina;

@Service
public class MaquinaServiceImpl implements IMaquinaService {

	@Autowired
	IMaquinaDao iMaquinaDao;

	@Override
	public List<Maquina> listarMaquina() {
		
		return iMaquinaDao.findAll();
	}
	
	@Override
	public Maquina maquinaXID(Integer codigo) {
		
		return iMaquinaDao.findById(codigo).get();
	}

	@Override
	public Maquina guardarMaquina(Maquina maquina) {
		
		return iMaquinaDao.save(maquina);
	}

	@Override
	public Maquina actualizarMaquina(Maquina maquina) {
		
		return iMaquinaDao.save(maquina);
	}

	@Override
	public void eliminarMaquina(Integer codigo) {
		
		iMaquinaDao.deleteById(codigo);
	}
}
