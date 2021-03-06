package br.com.zup.mayconkevin.nossobanco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.mayconkevin.nossobanco.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
