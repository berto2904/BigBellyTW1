package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPan;
	private String nombre;
	private Integer stock;
	private Double precio;
	
	public Pan(String nombre, Integer stock, Double precio) {
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
	}

	public Pan(Long idPan, String nombre, Integer stock, Double precio) {
		super();
		this.idPan = idPan;
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
	}

	public Pan() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdPan() {
		return idPan;
	}

	public void setIdPan(Long idPan) {
		this.idPan = idPan;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	
	
	

}
