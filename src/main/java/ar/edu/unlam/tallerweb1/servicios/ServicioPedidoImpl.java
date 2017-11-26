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

//	@Override
//	public void actualizarEstadoPedidoAPendEntrega(Long idPedido) {
//		pedidoDao.actualizarEstadoPedidoAPendEntrega(idPedido);
//	}
//
//	@Override
//	public void actualizarEstadoPedidoAEntregado(Long idPedido) {
//		pedidoDao.actualizarEstadoPedidoAEntregado(idPedido);
//	}
//
//	@Override
//	public List<Pedido> listarPedidosPendCobro() {
//		List<Pedido> pedidos = pedidoDao.listarPedidosPendCobro();
//		return pedidos;
//	}
//
//	@Override
//	public List<Pedido> listarPedidosPendCoccion() {
//		List<Pedido> pedidos = pedidoDao.listarPedidosPendCoccion();
//		return pedidos;
//	}
//
//	@Override
//	public List<Pedido> listarPedidosPendEntrega() {
//		List<Pedido> pedidos = pedidoDao.listarPedidosPendEntrega();
//		return pedidos;
//	}
//
//	@Override
//	public List<Pedido> listarPedidosEntregados() {
//		List<Pedido> pedidos = pedidoDao.listarPedidosEntregados();
//		return pedidos;
//	}
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
 
}
