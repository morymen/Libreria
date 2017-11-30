package com.grupoatrium.negocio.test;

import java.util.List;

import com.grupoatrium.modelo.Libro;
import com.grupoatrium.persistencia.impl.test.LibroDAO;

public class NegocioLibro {
	
	private LibroDAO dao;


	
	public LibroDAO getDao() {
		return dao;
	}



	public void setDao(LibroDAO dao) {
		this.dao = dao;
	}

	public void create(Libro libro) {
		
		dao.create(libro);
	}
		
	public List<Libro> read(){
		return dao.read();
	}
	
	
	public Libro read(int id){
		Libro libro = new Libro();
		libro.setId(id);
		return dao.read(libro);
	}
	
	public void delete(int id){
		Libro libro = new Libro();
		libro.setId(id);
		dao.delete(libro);
	}

}
