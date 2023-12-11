package br.org.sesisp.view;
import br.org.sesisp.dao.CrudDAO;
import br.org.sesisp.model.Aluno;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TelaMain {

	public static void main(String[] args) {
		//SISTEMA DE ESCOLHAS CRUD
		Scanner entrada = new Scanner(System.in);
		//instanciando alunos
		CrudDAO inserir_aluno = new CrudDAO();
		Aluno aluno1 = new Aluno();
		int escolha1;
			do{
				String tela1 = JOptionPane.showInputDialog("Escolha uma das opcoes CRUD . . . \n"
						+ "1- CREATE aluno \n2- READ alunos \n3- UPDATE aluno \n4- DELETE aluno");
				escolha1 = Integer.parseInt(tela1);
				switch(escolha1) {
					//CREATE
					case 1:
						//interação com o console
						String nome1 = JOptionPane.showInputDialog("Digite o nome do aluno:");
						aluno1.setNome(nome1);
						String idade1 = JOptionPane.showInputDialog("Digite a idade do aluno:");
						int i1 = Integer.parseInt(idade1);
						aluno1.setIdade(i1);
						//inserindo aluno na banco
						inserir_aluno.create(aluno1);
						JOptionPane.showMessageDialog(null, "Nome: " + aluno1.getNome() + "\nIdade: " + aluno1.getIdade());
						break;
					
					//READ
					case 2:
						System.out.println("Lendo a lista . . . ");
						for(Aluno aluno : inserir_aluno.read()) {//Aluno percorre alunos
							JOptionPane.showMessageDialog(null, "Dados do aluno: " + "\n" + aluno.getRa() + "\n" 
									+ aluno.getNome() + "\n" + aluno.getIdade() + "\n");
						}
						break;
					
					//UPDATE
					case 3:
						String raAtualizar = JOptionPane.showInputDialog("Atualize o aluno de RA:");
						int ra1 = Integer.parseInt(raAtualizar);
						aluno1.setRa(ra1);
						System.out.println("Atualize o nome do aluno:");
						String nomeAtualizar = JOptionPane.showInputDialog("Atualize o nome do aluno:");
						aluno1.setNome(nomeAtualizar);
						System.out.println("Atualize o idade do aluno:");
						String idadeAtualizar = JOptionPane.showInputDialog("Atualize a idade do aluno:");
						int i2 = Integer.parseInt(idadeAtualizar);
						aluno1.setIdade(i2);
						System.out.println("Nome: " + aluno1.getNome() + "\nIdade: " + aluno1.getIdade() + "\nRA: " +aluno1.getRa());
						inserir_aluno.update(aluno1);
						break;
						
					//DELETE
					case 4:
						String ra= JOptionPane.showInputDialog("Digite o RA que deseja deletar");
						int raParaDeletar = Integer.parseInt(ra);
						CrudDAO deletar_aluno = new CrudDAO();
						deletar_aluno.delete(raParaDeletar);
						break;
						
					default:
						JOptionPane.showMessageDialog(null, "Insira o número para uma operação válida");
						break;
				}
			
			}while(escolha1 != 0);
		
	}//fim main
	
}//fim classe
