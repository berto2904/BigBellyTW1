package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Combo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCombo;
	private String descripcion;
	
	@ManyToMany(mappedBy = "combos")
    private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	private Boolean activo;
	
	private Double precioFinal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	private Usuario usuarioCreador;
	
	@ManyToMany(fetch = FetchType.EAGER ,mappedBy = "combos")
    private Set<Ingrediente> ingredientes = new HashSet<>();
	
	
	
	public Combo(Set<Ingrediente> ingredientes) {
		super();
		this.ingredientes = ingredientes;
	}
	public Combo() {
		super();
	}

	public Long getIdCombo() {
		return idCombo;
	}
	public void setIdCombo(Long idCombo) {
		this.idCombo = idCombo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public Double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}
	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
		
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
