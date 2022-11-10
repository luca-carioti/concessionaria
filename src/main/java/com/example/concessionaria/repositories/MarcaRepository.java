package com.example.concessionaria.repositories;

import com.example.concessionaria.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MarcaRepository extends JpaRepository<Marca,Long> {
    @Transactional(Transactional.TxType.REQUIRED)
    @Modifying
    @Query("update Marca m set m.nazionalita=?1,m.nome=?2,m.numeroModelli=?3 where m.id=?4 ")
     void update(String nazionalita, String nome, int numeroModelli, Long id);
}
