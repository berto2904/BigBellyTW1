package ar.edu.unlam.tallerweb1.servicios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ComboDao;
import ar.edu.unlam.tallerweb1.dao.EstadoPedidoDao;
import ar.edu.unlam.tallerweb1.dao.PedidoDao;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.EstadoPedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioPedido")
@Transactional
public class ServicioPedidoImpl implements ServicioPedido {
	
	@Inject
	private PedidoDao pedidoDao;
	
	@Inject 
	private ComboDao comboDao;

	@Inject 
	private EstadoPedidoDao estadoPedidoDao;
	
	@Override
	public Pedido consultarPedidoPorId(Long idPedido) {
		Pedido pedido = pedidoDao.consultarPedidoPorId(idPedido);
		return pedido;
	}

	@Override
	public void actualizarEstadoPedidoAPendCoccion(Long idPedido) {
		EstadoPedido estado = estadoPedidoDao.consultarEstadoPorId((long) 1);
		Pedido pedido = pedidoDao.consultarPedidoPorId(idPedido);
		pedido.setEstado(estado);
		pedidoDao.guardarPedido(pedido);
	}

	@Override
	public void actualizarEstadoPedidoAPendEntrega(Long idPedido) {
		EstadoPedido estado = estadoPedidoDao.consultarEstadoPorId((long) 2);
		Pedido pedido = pedidoDao.consultarPedidoPorId(idPedido);
		pedido.setEstado(estado);
		pedidoDao.guardarPedido(pedido);
	}

	@Override
	public void actualizarEstadoPedidoAEntregado(Long idPedido) {
		EstadoPedido estado = estadoPedidoDao.consultarEstadoPorId((long) 3);
		Pedido pedido = pedidoDao.consultarPedidoPorId(idPedido);
		pedido.setEstado(estado);
		pedidoDao.guardarPedido(pedido);
	}

	@Override
	public List<Pedido> listarPedidosPendCoccion() {
		EstadoPedido estado = estadoPedidoDao.consultarEstadoPorId((long) 1);
		List<Pedido> pedidos = pedidoDao.listarPedidosByEstado(estado);
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosPendEntrega() {
		EstadoPedido estado = estadoPedidoDao.consultarEstadoPorId((long) 2);
		List<Pedido> pedidos = pedidoDao.listarPedidosByEstado(estado);
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosEntregados() {
		EstadoPedido estado = estadoPedidoDao.consultarEstadoPorId((long) 3);
		List<Pedido> pedidos = pedidoDao.listarPedidosByEstado(estado);
		return pedidos;
	}
	
	@Override
	public void guardarPedido(Usuario usuario, String direccionUsuario) {
		EstadoPedido estado = estadoPedidoDao.consultarEstadoPorId((long) 1);
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		dateFormat.format(date);
		Date date = new Date();
		Pedido pedido = new Pedido();
		pedido.setDescripcion("Pedido creado por: "+ usuario.getNombre());
		pedido.setFechaHora(date);
		pedido.setUsuario(usuario);
		pedido.setDireccionLocal(direccionUsuario);
		pedido.setEstado(estado);
		List<Combo> combos = comboDao.listarCombosByUsuario(usuario);
		for (Combo combo : combos) {
			pedido.getCombos().add(combo);
			combo.setActivo(false);
			combo.getPedidos().add(pedido);
		}
		comboDao.persistirListaCombo(combos);
		pedidoDao.guardarPedido(pedido);
	}
	
	@Override
	public List<Pedido> listarPedidosByUsuario(Usuario usuario) {
		List<Pedido> pedidos = pedidoDao.listarPedidosByUsuario(usuario);
		return pedidos;
	}
	@Override
	public List<Pedido> listarPedidosPorFecha(Integer year, Integer month, Integer day) {
		//TODO
		return null;
	}
}
