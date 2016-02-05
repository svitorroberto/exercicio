import model.Aluno;
import model.AlunoDAO;


public class AlunoBo {
	AlunoDAO alunoDAO;
	
	public alunoBo(String tipoDeAluno){
		alunoDAO = FabricaDeAluno
	}

	public void incluir(Aluno aluno){
		if(!aluno.getMatricula()){
			aluno.incluir();
		}
	}
	
}
