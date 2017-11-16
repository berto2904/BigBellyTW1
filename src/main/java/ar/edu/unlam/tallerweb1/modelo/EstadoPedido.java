package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EstadoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstadoPedido;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	private Pedido pedido;
	
	@OneToMany (mappedBy="estado", cascade=CascadeType.ALL)
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	private String descripcion;
	
	public String getDescrpicion() {
		return descripcion;
	}

	public void setDescrpicion(String descripcion) {
		this.descripcion = descripcion;
	}
}
