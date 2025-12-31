package br.com.redelognet.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "protocolo")
public class Protocolo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "protocolo")
	private Long protocolo;

	@Column(name = "telefone", length = 20, nullable = false)
	private String telefone;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "cpf_cnpj", length = 20)
	private String cpfCnpj;

	@Column(name = "context", length = 50, nullable = false)
	private String context;

	@Column(name = "data_geracao", nullable = false)
	private LocalDateTime dataGeracao;

	@Column(name = "timestamp_unix")
	private Long timestamp;

	public Protocolo() {
		// TODO Auto-generated constructor stub
	}

	public Protocolo(Long protocolo, String telefone, String nome, String cpfCnpj, String context,
			LocalDateTime dataGeracao, Long timestamp) {
		super();
		this.protocolo = protocolo;
		this.telefone = telefone;
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.context = context;
		this.dataGeracao = dataGeracao;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Protocolo [id=" + id + ", protocolo=" + protocolo + ", telefone=" + telefone + ", nome=" + nome
				+ ", cpfCnpj=" + cpfCnpj + ", context=" + context + ", dataGeracao=" + dataGeracao + ", timestamp="
				+ timestamp + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(Long protocolo) {
		this.protocolo = protocolo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public LocalDateTime getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(LocalDateTime dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}
