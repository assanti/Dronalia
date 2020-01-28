package com.dronalia.dto;

import com.dronalia.enumClass.SkinTypeEnum;

public class Skin {
	
	private int id;
	private SkinTypeEnum type;
	private String cover;
	private double price;
	private String description;
	
	public Skin(int id) {
		super();
		this.id = id;
	}
	
	public Skin(int id, SkinTypeEnum type, String cover, double price,String description) {
		super();
		this.id = id;
		this.type = type;
		this.cover = cover;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SkinTypeEnum getType() {
		return type;
	}

	public void setType(SkinTypeEnum type) {
		this.type = type;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

}
