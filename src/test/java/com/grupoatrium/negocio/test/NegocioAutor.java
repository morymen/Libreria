package com.grupoatrium.negocio.test;

import java.util.List;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.persistencia.impl.test.AutorDAO;

public class NegocioAutor {

	
	private AutorDAO dao;

	public AutorDAO getDao() {
		return dao;
	}

	public void setDao(AutorDAO autorDAO) {
		this.dao = autorDAO;
	}
	
	public void create(String nombre, String nacionalidad, String comentarios) {
		Autor autor = new Autor(nombre, nacionalidad, comentarios);
		dao.create(autor);
	}
	
	public List<Autor> read(){
		return dao.read();
	}
	
	public void update(int id, String nombre, String nacionalidad, String comentarios) {
		Autor autor = new Autor(nombre, nacionalidad, comentarios);
		autor.setId(id);
		dao.update(autor);
		
	}
	
	
	public Autor read(int id){
		Autor autor = new Autor();
		autor.setId(id);
		return dao.read(autor);
	}
	
	public void delete (int id) {
		Autor autor = new Autor();
		autor.setId(id);
		dao.delete(autor);
		
	}
	
	
	
	
	
	
}
