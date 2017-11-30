package com.grupoatrium.negocio.test;

import java.util.List;

import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.persistencia.impl.test.DireccionDAO;

public class NegocioDireccion{

	
	private DireccionDAO dao;

	public DireccionDAO getDao() {
		return dao;
	}

	public void setDao(DireccionDAO DireccionDAO) {
		this.dao = DireccionDAO;
	}
	
	public int create(String calle, int numero, String poblacion, int cp, String provincia) {
		Direccion direccion = new Direccion(calle, numero, poblacion, cp, provincia);
		return dao.create(direccion);
	}
	
	public List<Direccion> read(){
		return dao.read();
	}
	
	public Direccion read(int id) {
		Direccion direccion = new Direccion();
		direccion.setId(id);
		return dao.read(direccion);
		
	}
	
	public void update(int id, String calle, int numero, String poblacion, int cp, String provincia) {
		Direccion direccion = new Direccion (calle, numero, poblacion, cp, provincia);
		direccion.setId(id);
		dao.update(direccion);
		
	}
	
	public void delete(int id) {
		Direccion direccion = new Direccion();
		direccion.setId(id);
		dao.delete(direccion);
		
	}
}

