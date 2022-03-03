package main.dto;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_cajero")
	private int codigo_cajero;
	Cajero cajero;
	
	@ManyToOne
	@JoinColumn(name = "codigo_maquina")
	private int codigo_maquina;
	Maquina maquina;
	
	@ManyToOne
	@JoinColumn(name = "codigo_producto")
	private int codigo_producto;
	Producto producto;

	// Constructores
	public Venta() {
	}	

	public Venta(int codigo, int codigo_cajero, Cajero cajero, int codigo_maquina, Maquina maquina, int codigo_producto,
			Producto producto) {		
		this.codigo = codigo;
		this.codigo_cajero = codigo_cajero;
		this.cajero = cajero;
		this.codigo_maquina = codigo_maquina;
		this.maquina = maquina;
		this.codigo_producto = codigo_producto;
		this.producto = producto;
	}

	//Getters and Setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo_cajero() {
		return codigo_cajero;
	}

	public void setCodigo_cajero(int codigo_cajero) {
		this.codigo_cajero = codigo_cajero;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public int getCodigo_maquina() {
		return codigo_maquina;
	}

	public void setCodigo_maquina(int codigo_maquina) {
		this.codigo_maquina = codigo_maquina;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Venta [codigo=" + codigo + ", codigo_cajero=" + codigo_cajero + ", cajero=" + cajero
				+ ", codigo_maquina=" + codigo_maquina + ", maquina=" + maquina + ", codigo_producto=" + codigo_producto
				+ ", producto=" + producto + "]";
	}
}
