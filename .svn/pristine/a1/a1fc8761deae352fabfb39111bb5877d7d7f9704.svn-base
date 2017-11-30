package com.grupoatrium.persistencia.impl.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.LibrosAutores;

public class MapeadorLibrosAutores implements RowMapper<LibrosAutores> {
	
	private AutorDAO autorDAO;
	
	

	public AutorDAO getAutorDAO() {
		return autorDAO;
	}



	public void setAutorDAO(AutorDAO autorDAO) {
		this.autorDAO = autorDAO;
	}



	public LibrosAutores mapRow(ResultSet rs, int rowNum) throws SQLException {
		LibrosAutores librosAutores = new LibrosAutores();
		Autor autor = new Autor();
		librosAutores.setId(rs.getInt("id"));
		//librosAutores.getLibro().setId(rs.getInt("libro_id"));
		//librosAutores.getAutor().setId(rs.getInt("autor_id"));
		autor.setId(rs.getInt("autor_id"));
		
		librosAutores.setAutor(autorDAO.read(autor));
		
		return librosAutores;
	}

}
