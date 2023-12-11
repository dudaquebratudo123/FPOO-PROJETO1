package br.org.sesisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.org.sesisp.controller.Conexao;
import br.org.sesisp.model.Aluno;

public class CrudDAO {
	//CRUD	C-Create R-Read U-Update D-Delete
	
	//CREATE (inserir dados)
	public void create(Aluno aluno) {
		String sql = "INSERT INTO alunos(nome, idade) VALUES (?,?)";
		//linka o banco com a aplicação
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql); //cast
			p.setString(1, aluno.getNome());
			p.setInt(2, aluno.getIdade());
			p.execute(); // nao vai pro banco se nao coloca isso
		}catch(Exception e) { 
			JOptionPane.showMessageDialog(null, "Erro ao inserir os dados! \nERRO: " + e);
		}finally { //fim try-catch
			try {
				if(p != null) {
					p.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//fim finally
		
	}//fim CREATE
	//*******************************************************************

	//UPDATE (atualizar dados)
	public void update(Aluno aluno) {
		String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE ra = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			p.setString(1, aluno.getNome());
			p.setInt(2, aluno.getIdade());
			p.setInt(3, aluno.getRa());
			p.execute(); //"executa inst para gravar" dados no banco
			JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
			System.out.println("Dados atualizados com sucesso!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar os dados! \nERRO: " + e);
		}finally {
			try {
				if(p != null) {
					p.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//fim finally
		
	}//fim UPDATE
	//*******************************************************************
	
	//READ (ler dados)
	public List<Aluno> read(){
		String sql = "SELECT * FROM alunos";
		List<Aluno> alunos = new ArrayList<Aluno>();
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet resultado = null;
		
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			resultado = p.executeQuery();//mostra os dados da consulta sql
			while(resultado.next()) {
				Aluno ver_aluno = new Aluno();
				//reculperar RA
				ver_aluno.setRa(resultado.getInt("ra"));
				//reculperar o nome 
				ver_aluno.setNome(resultado.getString ("nome"));
				//reculperar a idade 
				ver_aluno.setIdade(resultado.getInt("idade"));
				//adicionar na lista
				alunos.add(ver_aluno);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(p != null) {
					p.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//fim finally
		return alunos;
	}//fim READ
	//*******************************************************************
	
	//DELETE (deletar dados)
	public boolean delete(int ra) {
		String sql = "DELETE FROM alunos WHERE ra = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			p.setInt(1, ra);
			p.execute();
			JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
			System.out.println("Dados excluidos com sucesso!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir os dados! \nERRO: " + e);
		}finally {
			try {
				if(p != null) {
					p.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//fim finally
		return false;
	}//fim DELETE
	
}//fim class



