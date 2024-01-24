package com.questoesCM.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_questoes")
public class Questao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_questao")
	private int idQuestao;
	
	@Column(name = "ano_prova", length = 4, nullable = false)
	private int anoProva;

	@Column(name = "numero_questao", length = 2, nullable = false)
	private int numeroQuestao;
	
	@Column(name = "enunciado", nullable = false)
	private String enunciado;

	@Column(name = "resposta_a", nullable = false)
	private String respostaA;
	
	@Column(name = "resposta_b", nullable = false)
	private String respostaB;
	
	@Column(name = "resposta_c", nullable = false)
	private String respostaC;
	
	@Column(name = "resposta_d", nullable = false)
	private String respostaD;
	
	@Column(name = "resposta_e", nullable = false)
	private String respostaE;
	
	@Column(name = "gabarito", length = 1, nullable = false)
	@Enumerated(EnumType.STRING)
	private GabaritoEnum gabarito;
	
	@Column(name = "materia", length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
//	opções: MATEMATICA ou PORTUGUES
	private MateriaEnum materia;
	
	@Column(name = "endereco_video")
	private String enderecoVideo;
		
	public Questao(int anoProva, int numeroQuestao, String enunciado,
			String respostaA, String respostaB, String respostaC, String respostaD, String respostaE,
			GabaritoEnum gabarito, MateriaEnum materia, String enderecoVideo) {
		super();
		this.anoProva = anoProva;
		this.numeroQuestao = numeroQuestao;
		this.enunciado = enunciado;
		this.respostaA = respostaA;
		this.respostaB = respostaB;
		this.respostaC = respostaC;
		this.respostaD = respostaD;
		this.respostaE = respostaE;
		this.gabarito = gabarito;
		this.materia = materia;
		this.enderecoVideo = enderecoVideo;
	}

	
	public Questao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdQuestao() {
		return idQuestao;
	}

//	public void setIdQuestao(int idQuestao) {
//		this.idQuestao = idQuestao;
//	}

	public int getAnoProva() {
		return anoProva;
	}

	public void setAnoProva(int anoProva) {
		this.anoProva = anoProva;
	}

	public int getNumeroQuestao() {
		return numeroQuestao;
	}

	public void setNumeroQuestao(int numeroQuestao) {
		this.numeroQuestao = numeroQuestao;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getRespostaA() {
		return respostaA;
	}

	public void setRespostaA(String respostaA) {
		this.respostaA = respostaA;
	}

	public String getRespostaB() {
		return respostaB;
	}

	public void setRespostaB(String respostaB) {
		this.respostaB = respostaB;
	}

	public String getRespostaC() {
		return respostaC;
	}

	public void setRespostaC(String respostaC) {
		this.respostaC = respostaC;
	}

	public String getRespostaD() {
		return respostaD;
	}

	public void setRespostaD(String respostaD) {
		this.respostaD = respostaD;
	}

	public String getRespostaE() {
		return respostaE;
	}

	public void setRespostaE(String respostaE) {
		this.respostaE = respostaE;
	}

	public GabaritoEnum getGabarito() {
		return gabarito;
	}

	public void setGabarito(GabaritoEnum gabarito) {
		this.gabarito = gabarito;
	}

	public MateriaEnum getMateria() {
		return materia;
	}

	public void setMateria(MateriaEnum materia) {
		this.materia = materia;
	}

	public String getEnderecoVideo() {
		return enderecoVideo;
	}

	public void setEnderecoVideo(String enderecoVideo) {
		this.enderecoVideo = enderecoVideo;
	}

}
