package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @authorj joao horacio do lago 09/05/2020.
 */
@Entity
@Table(name = "poi")
public class Poi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nome_poi")
	private String nomeDoPoi;

	@Column(name = "coordenada_x")
	private Integer coordenadaX;

	@Column(name = "coordenada_y")
	private Integer coordenadaY;

	public Poi() {

	}

	/**
	 *
	 * @param id
	 * @param nomeDoPoi
	 * @param coordenadaX
	 * @param coordenadaY
	 */
	public Poi(Integer id, String nomeDoPoi, Integer coordenadaX, Integer coordenadaY) {

		this.id = id;
		this.nomeDoPoi = nomeDoPoi;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

	/**
	 * @return current id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id id to set (in cents)
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return current nomeDoPoi
	 */
	public String getNomeDoPoi() {
		return nomeDoPoi;
	}

	/**
	 * 
	 * @param nomeDoPoi nomeDoPoi to set
	 */
	public void setNomeDoPoi(String nomeDoPoi) {
		this.nomeDoPoi = nomeDoPoi;
	}

	/**
	 * @return current coordenadaX
	 */
	public Integer getCoordenadaX() {
		return coordenadaX;
	}

	/**
	 * 
	 * @param coordenadaX coordenadaX to set
	 */
	public void setCoordenadaX(Integer coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	/**
	 * @return current coordenadaY
	 */
	public Integer getCoordenadaY() {
		return coordenadaY;
	}

	/**
	 * 
	 * @param coordenadaY coordenadaY to set
	 */
	public void setCoordenadaY(Integer coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
}
