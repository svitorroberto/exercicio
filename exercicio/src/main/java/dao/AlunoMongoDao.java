package dao;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoMongoDao implements AlunoDao{

	public void incluir(Aluno aluno) {
	    System.out.println("AlunoMongoDao.incluir()");
	    //TODO Incluir o aluno no Mongo DB.
	  }
	
	public void excluir(Aluno aluno) {
	    System.out.println("AlunoMongoDao.excluir()");
	    //TODO Incluir o aluno no Mongo DB.
	  }
	
	public void alterar(Aluno aluno) {
	    System.out.println("AlunoMongoDao.alterar()");
	    //TODO Incluir o aluno no Mongo DB.
	  }
	
	  public List<Aluno> listar() {
	    System.out.println("AlunoMongoDao.listar()");
	    //Obter Alunos do Mongo.
	    return new ArrayList<Aluno>();
	  }

}
