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
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "combos")
    private Set<Pedido> pedidos = new HashSet<>();
	
	private Boolean activo;
	
	private Double precioFinal;
	
	@ManyToOne(fetch = FetchType.EAGER)
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
	
	public Combo(Long idCombo, String descripcion, Double precioFinal) 
	{this.idCombo=idCombo;
   	 this.descripcion=descripcion;
   	 this.precioFinal=precioFinal;
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
	public Double getPrecioFinal() {
		return precioFinal;
	}
	
	
	public void setPrecioFinal(Double precioFinal)throws Exception {
		if(precioFinal!=null && precioFinal>0)
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
	public Usuario getUsuarioCreador() {
		return usuarioCreador;
	}
	public void setUsuarioCreador(Usuario usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}
	public Set<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
