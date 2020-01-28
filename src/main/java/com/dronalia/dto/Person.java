package com.dronalia.dto;

import com.dronalia.enumClass.PersonGenreEnum;

public class Person {
	
	private int dni;
	private String name;
	private String surnames;
	private String email;
	private String tlf;
	private PersonGenreEnum genre;
	private Factura fac;
	
	public Person(int dni) {
		super();
		this.dni = dni;
	}

	public Person(int dni, String name, String surnames, String email, String tlf, PersonGenreEnum genre) {
		super();
		this.dni = dni;
		this.name = name;
		this.surnames = surnames;
		this.email = email;
		this.tlf = tlf;
		this.genre = genre;
	}

	public Person(int dni, String name, String surnames, String email, String tlf, PersonGenreEnum genre, Factura fac) {
		super();
		this.dni = dni;
		this.name = name;
		this.surnames = surnames;
		this.email = email;
		this.tlf = tlf;
		this.genre = genre;
		this.fac = fac;
	}
	
	
	
	
	
	
	

}
