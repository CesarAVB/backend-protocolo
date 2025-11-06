package br.com.redelognet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.redelognet.entities.Protocolo;

@Repository
public interface ProtocoloRepository extends JpaRepository<Protocolo, Integer>{

}
