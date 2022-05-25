package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.AtividadeDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Atividade;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.AtividadeRepository;

@Service
public class AtividadeService {
	@Autowired
	private AtividadeRepository atividadeRepository;

	public List<Atividade> findAllAtividade() {
		return atividadeRepository.findAll();
	}

	public Atividade findAtividadeById(Integer id) {
		return atividadeRepository.findById(id).isPresent() ? atividadeRepository.findById(id).get() : null;
	}

	public AtividadeDTO findAtividadeDTOById(Integer id) {
		Atividade atividade = atividadeRepository.findById(id).isPresent() ? atividadeRepository.findById(id).get()
				: null;

		AtividadeDTO atividadeDTO = new AtividadeDTO();
		if (atividade != null) {
			atividadeDTO = converterEntidadeParaDto(atividade);
		}
		return atividadeDTO;
	}

	public Atividade saveAtividade(Atividade atividade) {
		return atividadeRepository.save(atividade);
	}

	public Atividade saveAtividadeDTO(AtividadeDTO atividadeDTO) {
		Atividade atividade = converterDtoParaEntidade(atividadeDTO);
		return atividadeRepository.save(atividade);
	}

	public Atividade updateAtividade(Atividade atividade) {
		return atividadeRepository.save(atividade);
	}

	public void deleteAtividade(Integer id) {
		atividadeRepository.deleteById(id);
	}

	public AtividadeDTO converterEntidadeParaDto(Atividade atividade) {
		AtividadeDTO atividadeDTO = new AtividadeDTO();
		atividadeDTO.setIdAtividade(atividade.getIdAtividade());
		atividadeDTO.setNomeAtividade(atividade.getNomeAtividade());

		List<TurmaDTO> listTurmaDTO = new ArrayList<>();
		for (Turma turma : atividade.getTurmaList()) {
			TurmaDTO turmaDTO = new TurmaDTO();
			turmaDTO.setDataFim(turma.getDataFim());
			turmaDTO.setDataInicio(turma.getDataInicio());
			turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
			turmaDTO.setHorarioTurma(turma.getHorarioTurma());
			turmaDTO.setIdTurma(turma.getIdTurma());

			listTurmaDTO.add(turmaDTO);
		}

		atividadeDTO.setTurmaDTOList(listTurmaDTO);

		return atividadeDTO;
	}

	public Atividade converterDtoParaEntidade(AtividadeDTO atividadeDTO) {
		Atividade atividade = new Atividade();

		atividade.setIdAtividade(atividadeDTO.getIdAtividade());
		atividade.setNomeAtividade(atividadeDTO.getNomeAtividade());

		return atividade;
	}

}
