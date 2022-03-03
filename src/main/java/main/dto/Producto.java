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
@Table(name = "producto")
public class Producto {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private int precio;

	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Venta> venta;

	// Constructores
	public Producto() {
	}
	
	public Producto(int codigo, String nombre, int precio) {		
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	// Getters y setters
	public int getCodigo() {
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	//toString
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
}
