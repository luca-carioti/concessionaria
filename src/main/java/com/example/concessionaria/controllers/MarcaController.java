package com.example.concessionaria.controllers;

import com.example.concessionaria.models.Auto;
import com.example.concessionaria.models.Marca;
import com.example.concessionaria.services.AutoService;
import com.example.concessionaria.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;
    @GetMapping("/find/by_id")
    public ResponseEntity<Marca> getById(@RequestParam(value = "id",required = true) Long id){
        Optional<Marca> ris=marcaService.getById(id);
        if(ris.isPresent()){
            return new ResponseEntity<>(ris.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/find/all")
    public ResponseEntity<List<Marca>> getAll(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
                             @RequestParam(value = "pageSize", defaultValue = "15")int pageSize,
                             @RequestParam(value = "sortBy", defaultValue = "nome") String sortBy){
        List<Marca> ris=marcaService.getAll(pageNumber,pageSize,sortBy);
        if(ris.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") Long id){
        marcaService.delete(id);
    }

    @PostMapping
    public void add(@RequestBody @Validated Marca marca){
        marcaService.add(marca);
    }

    @PutMapping
    public void update(@RequestBody @Validated Marca marca){
        marcaService.update(marca);
    }
}
