package br.com.endersonlg.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.endersonlg.gestao_vagas.exceptions.UserNotFoundException;
import br.com.endersonlg.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.endersonlg.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;

@Service
public class ProfileCandidateUseCase {

  @Autowired
  private CandidateRepository candidateRepository;

  public ProfileCandidateResponseDTO execute(UUID idCandidate) {
    var candidate = this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
      throw new UserNotFoundException();
    });

    var candidateDTO = ProfileCandidateResponseDTO.builder()
        .id(candidate.getId())
        .email(candidate.getEmail())
        .name(candidate.getName())
        .description(candidate.getDescription())
        .build();

    return candidateDTO;
  }
}
