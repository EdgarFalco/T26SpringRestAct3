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
@Table(name = "maquina")
public class Maquina {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private int piso;

	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Venta> venta;

	// Constructores
	public Maquina() {
	}

	public Maquina(int codigo, int piso) {		
		this.codigo = codigo;
		this.piso = piso;
	}

	// Getters y setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	//ToString
	@Override
	public String toString() {
		return "Maquina [codigo=" + codigo + ", piso=" + piso + "]";
	}	
}
