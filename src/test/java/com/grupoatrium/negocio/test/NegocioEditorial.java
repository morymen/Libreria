package com.grupoatrium.negocio.test;

import java.util.List;

import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.persistencia.impl.test.EditorialDAO;

public class NegocioEditorial {
	
	private EditorialDAO dao;

	public EditorialDAO getDao() {
		return dao;
	}

	public void setDao(EditorialDAO dao) {
		this.dao = dao;
	}
	
	public void create(Editorial editorial) {
		
		
	}
	
	public List<Editorial> read(){
		
		return dao.read();
	}
	
	public Editorial read(int id){
		
		Editorial editorial = new Editorial();
		editorial.setId(id);
		return dao.read(editorial);
	}

	public void create(String nombre, String nif, Direccion direccion) {
		Editorial editorial = new Editorial(nombre,direccion,nif);
		dao.create(editorial);
		
	}
	
	public void delete(int id){
		Editorial editorial = new Editorial();
		editorial.setId(id);
		dao.delete(editorial);
		
	}

	

}
