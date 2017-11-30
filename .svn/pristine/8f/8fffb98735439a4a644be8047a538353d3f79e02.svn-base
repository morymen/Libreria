package com.grupoatrium.persistencia.impl.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;

public class MapeadorEditorial implements RowMapper<Editorial> {
	
	
	private DireccionDAO direccionDAO;
	
	public DireccionDAO getDireccionDAO() {
		return direccionDAO;
	}


	public void setDireccionDAO(DireccionDAO direccionDAO) {
		this.direccionDAO = direccionDAO;
	}



	public Editorial mapRow(ResultSet rs, int rowNum) throws SQLException {
		Editorial editorial = new Editorial();
		
		Direccion direccion = new Direccion();
		direccion.setId(rs.getInt("direccion_id"));
		direccion = direccionDAO.read(direccion);
		
		editorial.setId(rs.getInt("id"));
		editorial.setNombre(rs.getString("nombre"));
		editorial.setNif(rs.getString("nif"));
		editorial.setDireccion(direccion);
		
		return editorial;
	}

}
