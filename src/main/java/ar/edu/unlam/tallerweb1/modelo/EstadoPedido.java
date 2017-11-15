package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EstadoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
	
	private String descripcion;
	
	public String getDescrpicion() {
		return descripcion;
	}

	public void setDescrpicion(String descripcion) {
		this.descripcion = descripcion;
	}
}
