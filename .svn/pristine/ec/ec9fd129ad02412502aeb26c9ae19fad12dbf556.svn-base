package com.grupoatrium.persistencia.impl.test;

import java.util.ArrayList;
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

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.modelo.LibrosAutores;

public class LibroDAO {
	
	private NamedParameterJdbcTemplate plantilla;
	private RowMapper<Libro> mapeador;
	
	private EditorialDAO editorialDAO;
	private AutorDAO autorDAO;
	private LibrosAutoresDAO librosAutoresDAO;
	
	
	
	public LibrosAutoresDAO getLibrosAutoresDAO() {
		return librosAutoresDAO;
	}
	public void setLibrosAutoresDAO(LibrosAutoresDAO librosAutoresDAO) {
		this.librosAutoresDAO = librosAutoresDAO;
	}
	public EditorialDAO getEditorialDAO() {
		return editorialDAO;
	}
	public void setEditorialDAO(EditorialDAO editorialDAO) {
		this.editorialDAO = editorialDAO;
	}
	public AutorDAO getAutorDAO() {
		return autorDAO;
	}
	public void setAutorDAO(AutorDAO autorDAO) {
		this.autorDAO = autorDAO;
	}
	public NamedParameterJdbcTemplate getPlantilla() {
		return plantilla;
	}
	public void setPlantilla(NamedParameterJdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}
	public RowMapper<Libro> getMapeador() {
		return mapeador;
	}
	public void setMapeador(RowMapper<Libro> mapeador) {
		this.mapeador = mapeador;
	}
	
	public List<Libro> read(){
		String sql ="SELECT * FROM LIBRO";
		return plantilla.query(sql, mapeador);
	}
	
	public Libro read (Libro libro) {
		String sql = "SELECT * FROM LIBRO WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", libro.getId());
		Libro response;
		
		try {
			response = plantilla.queryForObject(sql, paramMap, mapeador);
			
		} catch (EmptyResultDataAccessException e) {
			response = new Libro();
		}
		
		return response;
	}
	
	public void create(Libro libro) {
		String sql="INSERT INTO LIBRO (isbn, titulo, publicacion, precio, descripcion, editorial_id) "
				 + "VALUES(:isbn, :titulo, :publicacion, :precio, :descripcion, :editorial_id) ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		
		int editorial_id = editorialDAO.create(libro.getEditorial());
		paramMap.put("isbn", libro.getIsbn());
		paramMap.put("titulo", libro.getTitulo());
		paramMap.put("publicacion",libro.getPublicacion());
		paramMap.put("precio", libro.getPrecio());
		paramMap.put("descripcion", libro.getDescripcion());
		paramMap.put("editorial_id", editorial_id);
		
		
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        KeyHolder keyHolder = new GeneratedKeyHolder();
		plantilla.update(sql, paramSource, keyHolder);
        Map<String,Object> keys = keyHolder.getKeys();
        
        
        int libro_id  = Integer.parseInt(keys.get("GENERATED_KEY").toString());
		libro.setId(libro_id);
		
		
		//SAVE AUTORES
        List<Autor> autores= libro.getAutores();
		List<Integer> autores_id = new ArrayList<Integer>();
		for (Autor autor : autores) {
			autores_id.add(autorDAO.create(autor)); 
		}
		
		for (Integer autor_id : autores_id) {
			Autor autor = new Autor();
			autor.setId(autor_id);
			LibrosAutores librosAutores = new LibrosAutores(0,libro,autor);
			librosAutoresDAO.create(librosAutores);
		}
		
	}
	
	public void delete(Libro libro) {
		String sql = "DELETE FROM LIBRO WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", libro.getId());
		plantilla.update(sql, paramMap);
		
	}
	

}
