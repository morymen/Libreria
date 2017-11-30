package com.grupoatrium.persistencia.impl.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.modelo.LibrosAutores;

public class LibrosAutoresDAO {
	
	private NamedParameterJdbcTemplate plantilla;
	private RowMapper<LibrosAutores> mapeador;
	
	public NamedParameterJdbcTemplate getPlantilla() {
		return plantilla;
	}
	public void setPlantilla(NamedParameterJdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}
	public RowMapper<LibrosAutores> getMapeador() {
		return mapeador;
	}
	public void setMapeador(RowMapper<LibrosAutores> mapeador) {
		this.mapeador = mapeador;
	}
	
	
	public void create(LibrosAutores librosAutores) {
		String sql ="INSERT INTO LIBROS_AUTORES (libro_id,autor_id) VALUES(:libro_id, :autor_id)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("libro_id", librosAutores.getLibro().getId());
		paramMap.put("autor_id", librosAutores.getAutor().getId());
		plantilla.update(sql, paramMap);
	}
	
	public List<LibrosAutores> read(){
		String sql ="SELECT * FROM LIBROS_AUTORES";
		return  plantilla.query(sql, mapeador);
	}
	
	
	public List<Autor> readAutores(Libro libro){
		String sql ="SELECT * FROM LIBROS_AUTORES WHERE libro_id=:libro_id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("libro_id", libro.getId());
		
		List<LibrosAutores> result = plantilla.query(sql, paramMap, mapeador);

		List<Autor> autores = new ArrayList<Autor>();
        for (LibrosAutores librosAutores : result) {
			Autor autor1 = librosAutores.getAutor();
			autores.add(autor1);
		}
		
		return autores; 
	}
	
	public LibrosAutores read(LibrosAutores librosAutores) {
		String sql ="SELECT * FROM LIBROS_AUTORES WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", librosAutores.getId());
		return  plantilla.queryForObject(sql, paramMap, mapeador);
		
	}
	
	public void delete(LibrosAutores librosAutores) {
		String sql ="DELETE FROM LIBROS_AUTORES WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", librosAutores.getId());
		plantilla.update(sql, paramMap);
	}

}
