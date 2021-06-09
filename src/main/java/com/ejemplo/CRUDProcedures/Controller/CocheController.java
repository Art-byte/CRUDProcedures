package com.ejemplo.CRUDProcedures.Controller;

import com.ejemplo.CRUDProcedures.Entity.Coche;
import com.ejemplo.CRUDProcedures.Service.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/coche")
public class CocheController {

    @Autowired
    CocheService cocheService;

    @GetMapping("/lista")
    public ResponseEntity<List<Coche>> lista(){
        List<Coche> lista = cocheService.lista();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/verid/{id}")
    public ResponseEntity<Coche> verId(@PathVariable("id") int id){
        Optional<Coche> coche = cocheService.getById(id);
        return new ResponseEntity(coche, HttpStatus.OK);
    }

    @GetMapping("/vermarca/{marca}")
    public ResponseEntity<Coche> verMarca(@PathVariable("marca") String marca){
        List<Coche> coche = cocheService.getByMarca(marca);
        return new ResponseEntity(coche, HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Coche> save(@RequestBody Coche coche){
        cocheService.saveProcedure(coche);
        return new ResponseEntity("Nuevo coche guardado", HttpStatus.CREATED);
    }
}
