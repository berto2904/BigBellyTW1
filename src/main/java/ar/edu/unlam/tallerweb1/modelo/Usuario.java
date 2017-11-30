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
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String nombre;
	private String email;
	private String password;
	private String apellido;
	private String celular;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idRol")
	private Rol rol;
	
	@OneToMany (mappedBy="usuarioCreador", cascade=CascadeType.ALL)
	private List<Combo> combos = new ArrayList<Combo>();
	
	@OneToMany (mappedBy="usuario", cascade=CascadeType.ALL)
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	

	public Usuario() {
		super();
	}

	public Usuario(Long idUsuario, String nombre, String email, String password, Rol rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Combo> getCombos() {
		return combos;
	}

	public void setCombos(List<Combo> combos) {
		this.combos = combos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
}
