package com.grupoatrium.persistencia.impl.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grupoatrium.modelo.Autor;

public class MapeadorAutor implements RowMapper<Autor> {
	
	public Autor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Autor autor = new Autor();
		autor.setId(rs.getInt("id"));
		autor.setNombre(rs.getNString("NOMBRE"));
		autor.setNacionalidad(rs.getString("NOMBRE"));
		autor.setComentarios(rs.getString("COMENTARIOS"));
		return autor;
	}
	
}


