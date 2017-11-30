package com.grupoatrium.persistencia.impl.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.grupoatrium.modelo.Autor;


public class AutorDAO {
	
	
	private NamedParameterJdbcTemplate plantilla;
	private MapeadorAutor mapeador;
	
	
	public NamedParameterJdbcTemplate getPlantilla() {
		return plantilla;
	}
	public void setPlantilla(NamedParameterJdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}
	public MapeadorAutor getMapeador() {
		return mapeador;
	}
	public void setMapeador(MapeadorAutor mapeador) {
		this.mapeador = mapeador;
	}
	
	
	
	public int create(Autor autor){
		
		String sql="INSERT INTO AUTOR (nombre, nacionalidad, comentarios) VALUES (:nombre, :nacionalidad, :comentarios)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("nombre", autor.getNombre());
		paramMap.put("nacionalidad", autor.getNacionalidad());
		paramMap.put("comentarios", autor.getComentarios());
		
		
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        KeyHolder keyHolder = new GeneratedKeyHolder();
		plantilla.update(sql, paramSource, keyHolder);
        Map<String,Object> keys = keyHolder.getKeys();
        
        return Integer.parseInt(keys.get("GENERATED_KEY").toString());
		
	}
	
	public List<Autor> read(){
		String sql="SELECT * FROM AUTOR";
		return	plantilla.query(sql, mapeador);
	}
	
	
	public Autor read(Autor autor){
		String sql="SELECT * FROM AUTOR WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", autor.getId());
		Autor response;
		try {
			response =  plantilla.queryForObject(sql, paramMap, mapeador);
		} catch (EmptyResultDataAccessException e) {
			response = new Autor();
		}
		return  response;
	}
	
	public void update(Autor autor){
		String sql ="UPDATE AUTOR SET nombre=:nombre, nacionalidad=:nacionalidad, comentarios=:comentarios WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id",autor.getId());
		paramMap.put("nombre",autor.getNombre());
		paramMap.put("nacionalidad",autor.getNacionalidad());
		paramMap.put("comentarios",autor.getComentarios());
		plantilla.update(sql, paramMap);
	}
	
	
	public void delete(Autor autor) {
		String sql ="DELETE FROM AUTOR WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", autor.getId());
		plantilla.update(sql, paramMap);
	}
	
}
