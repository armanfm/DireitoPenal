package helper;

import java.util.List;

import classes.Direito;

public interface IDireitoDAO {
    public boolean salvar(Direito direito);
    public boolean deletar(Direito direito);
    public boolean alterar(Direito direito);
    public List<Direito> listar();
}
