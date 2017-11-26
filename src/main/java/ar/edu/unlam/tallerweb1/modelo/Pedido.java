package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	private String descripcion;
	private Date fechaHora;
	
	@ManyToMany(fetch = FetchType.EAGER)
//	(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "combo_pedido", 
        joinColumns = { @JoinColumn(name = "idPedido") }, 
        inverseJoinColumns = { @JoinColumn(name = "idCombo") }
    )
    private Set<Combo> combos = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEstadoPedido")
	private EstadoPedido estado;
	private String direccionLocal;
	
    public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Set<Combo> getCombos() {
		return combos;
	}

	public void setCombos(Set<Combo> combos) {
		this.combos = combos;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDireccionLocal() {
		return direccionLocal;
	}

	public void setDireccionLocal(String direccionLocal) {
		this.direccionLocal = direccionLocal;
	}	
	
}
