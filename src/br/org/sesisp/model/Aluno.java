package br.org.sesisp.model;

public class Aluno {

	//atributos
	private int ra;
	private String nome;
	private int idade;
	
	//construtores
	public Aluno() {
		
	}
	public Aluno(int ra, String nome, int idade) {
		this.ra = ra;
		this.nome = nome;
		this.idade = idade;
	}
	
	//getters e setters
	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
		


}
