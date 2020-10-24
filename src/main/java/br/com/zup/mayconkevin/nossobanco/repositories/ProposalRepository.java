package br.com.zup.mayconkevin.nossobanco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.mayconkevin.nossobanco.domain.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Integer>{

}
