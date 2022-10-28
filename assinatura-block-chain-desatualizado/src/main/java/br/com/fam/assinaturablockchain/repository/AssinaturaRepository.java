package br.com.fam.assinaturablockchain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fam.assinaturablockchain.entity.AssinaturaEntity;

@Repository
public interface AssinaturaRepository extends JpaRepository<AssinaturaEntity, Long> {

	AssinaturaEntity findBySignerName(String signerName);

	AssinaturaEntity findBySignerEmail(String signerEmail);

}
