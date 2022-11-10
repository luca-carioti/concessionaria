package com.example.concessionaria.services;

import com.example.concessionaria.models.Marca;
import com.example.concessionaria.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public Optional<Marca> getById(Long id){return marcaRepository.findById(id);}
    public void delete(Long id){marcaRepository.deleteById(id);}
    public List<Marca> getAll(int pageNumber,int pageSize, String sortBy){
        Pageable pageable= PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
        Page<Marca> page=marcaRepository.findAll(pageable);
        if(page.hasContent()){
            return page.getContent();
        }
        return new ArrayList<>();
    }
    public void update(Marca marca){marcaRepository.update(marca.nazionalita(),marca.nome(),marca.numeroModelli(),marca.id());}
    public Marca add(Marca marca){
        return marcaRepository.save(marca);
    }

}
