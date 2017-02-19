/*
 * Standalone Spring Application
 * Copyright (C) 2017 Sampath Thennakoon
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */
package com.intervest.finance.model.model;

public class Horse {

	private String age;
	private String chipID;
	private String colorMantle;
	private String name;
	private String type;

	public Horse() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	public String getChipID() {
		return chipID;
	}
	/**
	 * @return the colorMantle
	 */
	public String getColorMantle() {
		return colorMantle;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	public void setChipID(String chipID) {
		this.chipID = chipID;
	}
	/**
	 * @param colorMantle the colorMantle to set
	 */
	public void setColorMantle(String colorMantle) {
		this.colorMantle = colorMantle;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Horse [age=" + age + ", chipID=" + chipID + ", colorMantle=" + colorMantle + ", name=" + name
				+ ", type=" + type + "]";
	}
	
}
