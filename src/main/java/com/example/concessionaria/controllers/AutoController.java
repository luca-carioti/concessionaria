package com.example.concessionaria.controllers;

import com.example.concessionaria.models.Auto;
import com.example.concessionaria.repositories.AutoRepository;
import com.example.concessionaria.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/auto")
public class AutoController {
    @Autowired
    private AutoService autoService;
    @GetMapping("/find/bi_id")
    public ResponseEntity<Auto> getById(@RequestParam(value = "id",required = true) Long id){
        Optional<Auto> ris=autoService.getById(id);
        if(ris.isPresent()){
            return new ResponseEntity<>(ris.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find/all")
    public ResponseEntity getAll(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
                             @RequestParam(value = "pageSize", defaultValue = "15")int pageSize,
                             @RequestParam(value = "sortBy", defaultValue = "targa") String sortBy){
        List<Auto> ris=autoService.getAll(pageNumber,pageSize,sortBy);
        if(ris.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ris,HttpStatus.OK);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") Long id){
        autoService.delete(id);
    }

    @PostMapping
    public void add(@RequestBody @Validated Auto auto){
        autoService.add(auto);
    }

    @PutMapping
    public void update(@RequestBody @Validated Auto auto){
        autoService.update(auto);
    }
}
