package com.grupoatrium.cliente;

import java.util.ArrayList;
import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.negocio.test.NegocioAutor;
import com.grupoatrium.negocio.test.NegocioDireccion;
import com.grupoatrium.negocio.test.NegocioEditorial;
import com.grupoatrium.negocio.test.NegocioLibro;

public class AppMainDbTest {

	
	public static void printJson(List<?> string) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(string);
		System.out.println(json);
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-test-db.xml");
		System.out.println("Test DATA BASE");
		
		//"----- AUTOR ------";
		
		NegocioAutor negocioautor = context.getBean("negocioAutor", NegocioAutor.class);
		negocioautor.create("NOMBRE222", "NACIONALIDAD222", "COMENTARIOS2");		
		negocioautor.create("NOMBRE222", "NACIONALIDAD222", "COMENTARIOS2");

		// SIN ERRORES. SI NO EXISTE EL ID NO HACE NADA
		negocioautor.update(1, "NOMRBE EDITADO2", "NACIONALIDAD EDITADO", "COEMTNARIO EDITADO2");

		// SIN ERRORES. SI NO EXISTE EL ID NO HACE NADA
		negocioautor.delete(200);
		
		List<Autor> autor = new ArrayList<Autor>();
		autor.add(negocioautor.read(1));
		
		System.out.println("----- AUTOR ------");
		printJson((List<Autor>) autor);
		printJson(negocioautor.read());
		
		
		
		//"----- DIRECCION ------";
		
		
		NegocioDireccion negocioDireccion = context.getBean("negocioDireccion", NegocioDireccion.class);
		

		negocioDireccion.create("CALLE", 60, "POBLACION", 1234, "PRVINCIA");
		negocioDireccion.update(1, "calle", 2, "poblacio", 1234, "provincia1234");
		negocioDireccion.delete(1);
		
		
		
		List<Direccion> direccion = new ArrayList<Direccion>();
		direccion.add(negocioDireccion.read(2));
		
		System.out.println("----- DIRECCION ------");
		printJson(direccion);
		printJson(negocioDireccion.read());
		
		
		//"----- EDITORIAL ------");
		

		NegocioEditorial negocioEditorial = context.getBean("negocioEditorial", NegocioEditorial.class);
		
		negocioEditorial.create("nombre Editorial","12354K",negocioDireccion.read(2));
		System.out.println("----- EDITORIAL ------");
		printJson(negocioEditorial.read());
		

		//"----- LIBRO ------";
		
		NegocioLibro negocioLibro = context.getBean("negocioLibro", NegocioLibro.class);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		
		List<Autor> autores = new ArrayList<Autor>();
		Autor autor1 = new Autor("nombreTTEST", "nacionaclidadTTEST", "comentariosTTEST");
		autores.add(autor1);
		autores.add(autor1);
		autores.add(autor1);
		
		Direccion direccion1 = new Direccion("CALLE", 60, "POBLACION", 1234, "PRVINCIA");
		Editorial editorial1 = new Editorial("nombre editorial", direccion1,"SADFS");
		
		Libro libro = new Libro("isbn","titulo",autores,editorial1,12,12.3,"descripico");
		negocioLibro.create(libro);
		
		
		System.out.println("----- LIBRO ------");
		List<Libro> libro1 = new ArrayList<Libro>();
		libro1.add(negocioLibro.read(1));
		printJson(negocioLibro.read());
		printJson(libro1);
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		String jsonlibro = gson.toJson(libro);
		System.out.println(jsonlibro);
		
		System.out.println("FIN");
	}
}
