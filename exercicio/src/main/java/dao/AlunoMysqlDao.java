package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoMysqlDao implements AlunoDao{

	public void incluir(Aluno aluno){
		String url = "jdbc:mysql://localhost:3306/unificada,root,aluno";
		Connection con;
		try {
			con = DriverManager.getConnection(url);
		      System.out.println("Conectou!");
		String sql = "insert into aluno (matricula, nome, curso) values (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, aluno.getMatricula());
	    ps.setString(2, aluno.getNome());
	    ps.setString(3, aluno.getCurso());
	    
	    ps.executeUpdate();
	    System.out.println("Incluiu!");
	    ps.close();
	    con.close();
		} catch(Throwable e) {
		      //Para repassar a exceção para o container tratar.
		      throw new RuntimeException(e);
		    }
	}
	

	public void excluir(Aluno aluno){
		String url = "jdbc:mysql://localhost:3306/unificada,root,aluno";
		Connection con;
		try {
			con = DriverManager.getConnection(url);
		      System.out.println("Conectou!");
		String sql = "delete from aluno where matricula = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, aluno.getMatricula());
	    
	    
	    ps.executeUpdate();
	    System.out.println("Excluiu!");
	    ps.close();
	    con.close();
		} catch(Throwable e) {
		      //Para repassar a exceção para o container tratar.
		      throw new RuntimeException(e);
		    }
	}
	public void alterar(Aluno aluno){
		Aluno a = new Aluno();
		String url = "jdbc:mysql://localhost:3306/unificada,root,aluno";
		Connection con;
		try {
			con = DriverManager.getConnection(url);
		      System.out.println("Conectou!");
		String sql = "update aluno set nome=?, curso=? where matricula = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, aluno.getNome());
		ps.setString(2, aluno.getCurso());
		ps.setString(3, aluno.getMatricula());
	    
	    
	    ps.executeUpdate();
	    System.out.println("Alterou!");
	    ps.close();
	    con.close();
		} catch(Throwable e) {
		      //Para repassar a exceção para o container tratar.
		      throw new RuntimeException(e);
		    }
	}
	
	public List<Aluno> listar(){

		String url = "jdbc:mysql://localhost:3306/unificada,root,aluno";
		Connection con;
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			con = DriverManager.getConnection(url);
		      System.out.println("Conectou!");
		String sql = "select * from aluno order by matricula";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Aluno a = new Aluno();
			String matricula = rs.getString("matricula");
			String nome = rs.getString("nome");
			String curso = rs.getString("curso");
			
			alunos.add(a);
		}
		rs.close();
		ps.close();
		
	}
		catch(Throwable e){
			throw new RuntimeException(e);
		}
		return alunos;
	}



}
