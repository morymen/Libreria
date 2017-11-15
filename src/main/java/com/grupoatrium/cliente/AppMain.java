package com.grupoatrium.cliente;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.persistencia.impl.ConnectionMgr;
import com.grupoatrium.persistencia.impl.LibrosDAO;

public class AppMain {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Autor autor = context.getBean("autor", Autor.class);
		System.out.println("AUTOR");
		System.out.println(autor.toString());
		
		System.out.println("DIRECCION");
		Direccion direccion = context.getBean("direccion", Direccion.class);
		System.out.println(direccion.toString());
		
		System.out.println("EDITORIAL");
		Editorial editorial = context.getBean("editorial", Editorial.class);
		System.out.println(editorial.toString());
		
		System.out.println("LIBRO");
		Libro libro = context.getBean("libro", Libro.class);
		System.out.println(libro.toString());
		
		System.out.println("CONNECTIONMGR");
		ConnectionMgr conectionMgr = context.getBean("connectionMgr", ConnectionMgr.class);
		System.out.println(conectionMgr.toString());
		
		System.out.println("LIBROSDAO");
		LibrosDAO librosdao = context.getBean("librosDAO", LibrosDAO.class);
		System.out.println(librosdao.toString());
		
		System.out.println();
		
		
	}

}

