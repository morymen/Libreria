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

import com.grupoatrium.modelo.Direccion;

public class DireccionDAO {
	
	private NamedParameterJdbcTemplate plantilla;
	private RowMapper<Direccion> mapeador;
	
	public NamedParameterJdbcTemplate getPlantilla() {
		return plantilla;
	}
	public void setPlantilla(NamedParameterJdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}
	public RowMapper<Direccion> getMapeador() {
		return mapeador;
	}
	public void setMapeador(RowMapper<Direccion> mapeador) {
		this.mapeador = mapeador;
	}
	
	public int create(Direccion direccion) {
		String sql ="INSERT INTO DIRECCION (calle, numero, poblacion, cp, provincia) VALUES(:calle, :numero, :poblacion, :cp, :provincia)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("calle", direccion.getCalle());
		paramMap.put("numero", direccion.getNumero());
		paramMap.put("poblacion", direccion.getPoblacion());
		paramMap.put("cp", direccion.getCp());
		paramMap.put("provincia", direccion.getProvincia());
		
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        KeyHolder keyHolder = new GeneratedKeyHolder();
		plantilla.update(sql, paramSource, keyHolder);
        Map<String,Object> keys = keyHolder.getKeys();
        
        return Integer.parseInt(keys.get("GENERATED_KEY").toString());
        
    }
	
	
	public List<Direccion> read(){
		String sql= "SELECT * FROM DIRECCION";
		return plantilla.query(sql, mapeador);
	}
	
	public Direccion read (Direccion direccion) {
		String sql = "SELECT * FROM DIRECCION WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", direccion.getId());
		Direccion response;
		
		try {
			response = plantilla.queryForObject(sql, paramMap, mapeador);
			
		} catch (EmptyResultDataAccessException e) {
			response = new Direccion();
		}
		
		return response;
	}
	
	public void update (Direccion direccion) {
		String sql ="UPDATE DIRECCION SET calle=:calle, numero=:numero, poblacion=:poblacion, cp=:cp, provincia=:provincia WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", direccion.getId());
		paramMap.put("calle", direccion.getCalle());
		paramMap.put("numero", direccion.getNumero());
		paramMap.put("poblacion", direccion.getPoblacion());
		paramMap.put("cp", direccion.getCp());
		paramMap.put("provincia", direccion.getProvincia());
		plantilla.update(sql, paramMap);
		
	}
	
	public void delete(Direccion direccion){
		String sql = "DELETE FROM DIRECCION WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", direccion.getId());
		plantilla.update(sql, paramMap);
	}
	
	
	
	
	
	

}
