
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Aluno {

	private String nome;
	private String matricula;
	private String curso;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	
	String url = "jdbc:mysql://localhost:3306/unificada"; 
	String usuario = "root"; 
	String senha = "aluno";
	Connection con;
	
	
	public void incluir(){
		try {
			con = DriverManager.getConnection(url,usuario,senha);
		      System.out.println("Conectou!");
		String sql = "insert into aluno (matricula, nome, curso) values (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, matricula);
	    ps.setString(2, nome);
	    ps.setString(3, curso);
	    
	    ps.executeUpdate();
	    System.out.println("Incluiu!");
	    ps.close();
	    con.close();
		} catch(Throwable e) {
		      //Para repassar a exceção para o container tratar.
		      throw new RuntimeException(e);
		    }
	}
	public void excluir(){
		try {
			con = DriverManager.getConnection(url,usuario,senha);
		      System.out.println("Conectou!");
		String sql = "delete from aluno where matricula = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, matricula);
	    
	    
	    ps.executeUpdate();
	    System.out.println("Excluiu!");
	    ps.close();
	    con.close();
		} catch(Throwable e) {
		      //Para repassar a exceção para o container tratar.
		      throw new RuntimeException(e);
		    }
	}
	
	public void alterar(){
		try {
			con = DriverManager.getConnection(url,usuario,senha);
		      System.out.println("Conectou!");
		String sql = "update aluno set nome=?, curso=? where matricula = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, nome);
		ps.setString(2, curso);
		ps.setString(3, matricula);
	    
	    
	    ps.executeUpdate();
	    System.out.println("Alterou!");
	    ps.close();
	    con.close();
		} catch(Throwable e) {
		      //Para repassar a exceção para o container tratar.
		      throw new RuntimeException(e);
		    }
	}
	
	
	public static void main (String args[]){
		Aluno a = new Aluno();
		a.setMatricula("1");
		a.setNome("Joao");
		a.setCurso("Engenharia de Software");
	//	a.setCurso("Sistemas de Informacao");
		a.alterar();
	}
	/*
	public List<Aluno> listar(){
		List<Aluno> alunos = new ArrayList<Aluno>();
		String sql = "select * from aluno order by matricula";
		
		PreparedStatement ps = conn.ps(sql);
		
		ResultSet rs = ps .executeQuery();
		
		while(rs.next()){
			int matricula = rs.getInt("matricula");
			String nome = rs.getString("nome");
			
		}
	}*/
}
