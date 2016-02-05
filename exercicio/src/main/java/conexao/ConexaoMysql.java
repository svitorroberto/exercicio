package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoMysql {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/unificada"; 
		String usuario = "root"; 
		String senha = "aluno"; 
		
		Connection con; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,usuario,senha);
			System.out.println("Conectado!");
			con.close();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

}