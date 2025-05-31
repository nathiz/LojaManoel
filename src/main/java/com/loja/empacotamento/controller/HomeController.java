package com.loja.empacotamento.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/home")
    @Operation(summary = "Verifica se a API está no ar")
    public ResponseEntity<String> home() {
        logger.info(">>> Entrou no endpoint /api/home");
        return ResponseEntity.ok("API Loja Manoel está no ar!");
    }
}
