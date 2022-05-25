package com.residencia.academia.dto;

import java.util.Date;
import java.util.List;

public class InstrutorDTO {

	private Integer idInstrutor;
	private String nomeInstrutor;
	private Date dataNascimento;
	private Integer titulacaoInstrutor;
	private Integer rgInstrutor;
	private List<TurmaDTO> turmaDTOList;

	public Integer getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(Integer idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getTitulacaoInstrutor() {
		return titulacaoInstrutor;
	}

	public void setTitulacaoInstrutor(Integer titulacaoInstrutor) {
		this.titulacaoInstrutor = titulacaoInstrutor;
	}

	public Integer getRgInstrutor() {
		return rgInstrutor;
	}

	public void setRgInstrutor(Integer rgInstrutor) {
		this.rgInstrutor = rgInstrutor;
	}

	public List<TurmaDTO> getTurmaDTOList() {
		return turmaDTOList;
	}

	public void setTurmaDTOList(List<TurmaDTO> turmaDTOList) {
		this.turmaDTOList = turmaDTOList;
	}

	@Override
	public String toString() {
		return "InstrutorDTO [idInstrutor=" + idInstrutor + ", nomeInstrutor=" + nomeInstrutor + ", dataNascimento="
				+ dataNascimento + ", titulacaoInstrutor=" + titulacaoInstrutor + ", rgInstrutor=" + rgInstrutor
				+ ", turmaDTOList=" + turmaDTOList + "]";
	}

}
