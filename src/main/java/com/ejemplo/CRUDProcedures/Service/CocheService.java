package com.ejemplo.CRUDProcedures.Service;

import com.ejemplo.CRUDProcedures.Entity.Coche;
import com.ejemplo.CRUDProcedures.Repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService {

    @Autowired
    CocheRepository cocheRepository;

    public List<Coche> lista(){
        //Llamamos a procedure en vez de a findAll()
        return cocheRepository.listaProcedure();
    }

    public Optional<Coche> getById(int id){
        return cocheRepository.idProcedure(id);
    }

    public List<Coche> getByMarca(String marca){
        return cocheRepository.marcaProcedure(marca);
    }

    public void saveProcedure(Coche coche){
        cocheRepository.saveProcedure(
                coche.getMarca(),
                coche.getModelo(),
                coche.getAnio(),
                coche.getKm());
    }
}
