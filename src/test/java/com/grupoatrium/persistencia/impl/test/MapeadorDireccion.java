
package com.grupoatrium.persistencia.impl.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grupoatrium.modelo.Direccion;

public class MapeadorDireccion implements RowMapper<Direccion> {
	
	public Direccion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Direccion Direccion = new Direccion();
		Direccion.setId(rs.getInt("id"));
		Direccion.setCalle(rs.getString("calle"));
		Direccion.setCp(rs.getInt("cp"));
		Direccion.setNumero(rs.getInt("numero"));
		Direccion.setPoblacion(rs.getString("poblacion"));
		Direccion.setProvincia(rs.getString("provincia"));
		return Direccion;
	}
	
}


