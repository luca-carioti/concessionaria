package com.example.concessionaria.repositories;

import com.example.concessionaria.models.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AutoRepository extends JpaRepository<Auto,Long> {
    @Transactional(Transactional.TxType.REQUIRED)
    @Modifying
    @Query(
            "update Auto set chilometraggio=?1, cilindrata=?2,colore=?3,modello=?4,targa=?5,tipoCarburante=?6 where id=?7"
    )
    void update(double chilometraggio, double cilindrata, String colore, String modello, String targa, String tipoCarburante, Long id);

}
