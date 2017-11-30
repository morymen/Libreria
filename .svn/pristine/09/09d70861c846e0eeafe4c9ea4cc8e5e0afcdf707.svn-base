package com.grupoatrium.persistencia.impl.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.grupoatrium.modelo.Editorial;

public class EditorialDAO {
	
	private NamedParameterJdbcTemplate plantilla;
	private RowMapper<Editorial> mapeador;
	private DireccionDAO direccionDAO;
	
	public DireccionDAO getDireccionDAO() {
		return direccionDAO;
	}
	public void setDireccionDAO(DireccionDAO direccionDAO) {
		this.direccionDAO = direccionDAO;
	}
	public NamedParameterJdbcTemplate getPlantilla() {
		return plantilla;
	}
	public void setPlantilla(NamedParameterJdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}
	public RowMapper<Editorial> getMapeador() {
		return mapeador;
	}
	public void setMapeador(RowMapper<Editorial> mapeador) {
		this.mapeador = mapeador;
	}
	
	public List<Editorial> read(){
		// TODO HAY que extender esta select para las one to one para la direccion
		String sql="SELECT * FROM EDITORIAL";
		return plantilla.query(sql, mapeador);
		
	}
	
	public Editorial read(Editorial editorial){
		String sql="SELECT * FROM EDITORIAL WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", editorial.getId());
		Editorial response;

		try {
			response = plantilla.queryForObject(sql, paramMap, mapeador);
		} catch (EmptyResultDataAccessException e) {
			response = new Editorial();
		}
		
		return response;
	}
	
	
	public int create(Editorial editorial) {
		int direccion_id = direccionDAO.create(editorial.getDireccion());
		
		String sql ="INSERT INTO EDITORIAL (nombre, nif, direccion_id) VALUES(:nombre, :nif, :direccion_id)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("direccion_id", direccion_id);
		paramMap.put("nombre", editorial.getNombre());
		paramMap.put("nif", editorial.getNif());

		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        KeyHolder keyHolder = new GeneratedKeyHolder();
		plantilla.update(sql, paramSource, keyHolder);
        Map<String,Object> keys = keyHolder.getKeys();
        
        return Integer.parseInt(keys.get("GENERATED_KEY").toString());
	}
	
	public void delete (Editorial editorial) {
		editorial = this.read(editorial);
		direccionDAO.delete(editorial.getDireccion());
		
		String sql = "DELETE FROM EDITORIAL WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", editorial.getId());
		plantilla.update(sql, paramMap);
	}
	

}
