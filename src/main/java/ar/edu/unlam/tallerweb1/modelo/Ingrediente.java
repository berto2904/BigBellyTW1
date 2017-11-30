package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIngrediente;
	private String nombre;
	private Double precio;
	private Long tiempoCoccion;
	private Long stock;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;  
	private Boolean activo;
	@ManyToMany(fetch = FetchType.EAGER)
//	, cascade = { CascadeType.ALL }
    @JoinTable(
        name = "combo_ingrediente", 
        joinColumns = { @JoinColumn(name = "idIngrediente") }, 
        inverseJoinColumns = { @JoinColumn(name = "idCombo") }
    )
    private Set<Combo> combos = new HashSet<>();
	
	public Ingrediente(Long idIngrediente, String nombre, Long stock,Long tiempoCoccion, Double precio, Categoria categoria) {
		this.idIngrediente=idIngrediente;
		this.nombre=nombre;
		this.stock=stock;
		this.precio=precio;
		this.categoria=categoria;
		this.tiempoCoccion=tiempoCoccion;
	}

	public Ingrediente() {}

	public Long getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(Long idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) throws Exception {
		if(precio!=null && precio>0) {
		this.precio = precio;}else {throw new Exception();}
	}
	


	public Long getTiempoCoccion()  {
		return tiempoCoccion;
	}

	public void setTiempoCoccion(Long tiempoCoccion) throws Exception{
	if(tiempoCoccion!=null && tiempoCoccion>0) 	
	{
		this.tiempoCoccion = tiempoCoccion;} else {throw new Exception();}
	}

	public Categoria getCategoria() {
		//Categoria cat = new Categoria();
		return categoria;
	}

	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

	public Set<Combo> getCombos() {
		return combos;
	}

	public void setCombos(Set<Combo> combos) {
		this.combos = combos;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) throws Exception{
		if(stock!=null && stock>0) {
		this.stock = stock;} else {throw new Exception();}
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}	
	
}
