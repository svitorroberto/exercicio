package dao;

import java.util.List;

import model.Aluno;

public interface AlunoDao {
	
	public void incluir(Aluno aluno);
	public void excluir(Aluno aluno);
	public void alterar(Aluno aluno);
	public List<Aluno> listar();

}
