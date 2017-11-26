package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Pan;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ComboDao {

	void guardarCombo(Combo combo);
	Boolean validarCombo (Combo c1);
	void desactivarCombo(Long id, Boolean estado);
	Combo consultaComboById(Long id);
	List<Combo> listarCombosByUsuarioTrue(Usuario usuario);
	void persistirListaCombo(List<Combo> combos);
	
	
	

}
