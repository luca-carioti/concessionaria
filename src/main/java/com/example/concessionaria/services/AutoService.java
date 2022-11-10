package com.example.concessionaria.services;

import com.example.concessionaria.models.Auto;
import com.example.concessionaria.models.Marca;
import com.example.concessionaria.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AutoService {
    @Autowired
    private AutoRepository autoRepository;

    public Auto add(Auto auto){return autoRepository.save(auto);}
    public void delete(Long id){autoRepository.deleteById(id);}
    public Optional<Auto> getById(Long id){return autoRepository.findById(id);}
    public List<Auto> getAll(int pageNumber, int pageSize, String sortBy){
        Pageable pageable= PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
        Page<Auto> page=autoRepository.findAll(pageable);
        if(page.hasContent()){
            return page.getContent();
        }
        return new ArrayList<>();
    }
    public void update(Auto auto){autoRepository.update(auto.chilometraggio(),auto.cilindrata(),auto.colore(),
            auto.modello(),auto.targa(),auto.tipoCarburante(),auto.id());}
}
