package br.com.teste.assinantes.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(indexes = @Index(columnList = "email"))
public class Assinante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	
	private String email;
	
	@NotBlank
	private String senha;
	
	private Boolean cancelado = false;
	
	private Integer idade = 0;
	
	private String cpf = "";
	
	private String telefone = "";
	
	public Assinante(@NotBlank String nome, @NotBlank String email, @NotBlank String senha, Integer idade, String cpf,
			String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.idade = idade != null ? idade : 0;
		this.cpf = cpf == null ? "" : cpf;
		this.telefone = telefone == null ? "" : telefone;
	}
	
	public Assinante() {
		super();
	}

	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Boolean getCancelado() {
		return cancelado;
	}
	
	public void setCancelado(Boolean cancelado) {
		this.cancelado = cancelado;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
