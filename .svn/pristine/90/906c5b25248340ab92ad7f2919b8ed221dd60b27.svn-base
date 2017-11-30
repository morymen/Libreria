package com.grupoatrium.persistencia.impl.test;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;


import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;


public class MapeadorLibros implements RowMapper<Libro> {

	private EditorialDAO editorialDAO;
	
	private LibrosAutoresDAO librosAutoresDAO;
	
	public EditorialDAO getEditorialDAO() {
		return editorialDAO;
	}

	public void setEditorialDAO(EditorialDAO editorialDAO) {
		this.editorialDAO = editorialDAO;
	}

	public LibrosAutoresDAO getLibrosAutoresDAO() {
		return librosAutoresDAO;
	}

	public void setLibrosAutoresDAO(LibrosAutoresDAO librosAutoresDAO) {
		this.librosAutoresDAO = librosAutoresDAO;
	}

	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		Libro libro = new Libro();
		Editorial editorial = new Editorial(); 
		
		libro.setIsbn(rs.getString("isbn"));
		libro.setTitulo(rs.getString("titulo"));
		libro.setPublicacion(rs.getInt("publicacion"));
		libro.setPrecio(rs.getDouble("precio"));
		libro.setDescripcion(rs.getString("descripcion"));
		libro.setId(rs.getInt("id"));
		editorial.setId(rs.getInt("editorial_id"));
		editorial = editorialDAO.read(editorial);
		libro.setEditorial(editorial);
		libro.setAutores(librosAutoresDAO.readAutores(libro));
		
		return libro;
	}
	
}
