package com.brunoandreotti.deliveryapi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brunoandreotti.deliveryapi.domain.dtos.cozinha.CozinhaRequestDTO;
import com.brunoandreotti.deliveryapi.domain.dtos.cozinha.CozinhaResponseDTO;
import com.brunoandreotti.deliveryapi.services.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

  @Autowired
  private CozinhaService cozinhaService;



  @GetMapping()
  public ResponseEntity<List<CozinhaResponseDTO>> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(cozinhaService.findAll());

  }

  @GetMapping("/{id}")
  public ResponseEntity<CozinhaResponseDTO> findById(@PathVariable Long id) {
    System.out.println("teste");
    return ResponseEntity.status(HttpStatus.OK).body(cozinhaService.findById(id));

  }

  @PostMapping()
  public ResponseEntity<CozinhaResponseDTO> create(@RequestBody CozinhaRequestDTO cozinhaData) {


    return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaService.create(cozinhaData));
  }

  @PutMapping("/{id}")
  public ResponseEntity<CozinhaResponseDTO> updateById(@PathVariable Long id,
      @RequestBody CozinhaRequestDTO cozinhaData) {

    return ResponseEntity.status(HttpStatus.OK).body(cozinhaService.updateById(id, cozinhaData));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CozinhaResponseDTO> deleteById(@PathVariable Long id) {
    cozinhaService.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}
