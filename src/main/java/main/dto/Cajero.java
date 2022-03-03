package main.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cajero")
public class Cajero {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;

	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Venta> venta;

	// Constructores
	public Cajero() {
	}

	public Cajero(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	// Getters y setters
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getSuministra() {
		return venta;
	}

	public void setCaja(List<Venta> venta) {
		this.venta = venta;
	}

	// toString
	@Override
	public String toString() {
		return "Cajero [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
}
