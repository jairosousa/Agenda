package br.com.bpmlab.agenda.entidade;

public class Cliente {

	private Integer id;
	private String nome;
	private String email;
	private String endereco;
	private String telefone;
	
	

	public Cliente() {
		
	}

	public Cliente(Integer id, String nome, String email, String endereco,
			String telefone) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
