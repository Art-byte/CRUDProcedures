package com.ejemplo.CRUDProcedures.Repository;

import com.ejemplo.CRUDProcedures.Entity.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> {

    /*
    Metodo para poder mandar a llamar a un procedimiento
    * */
    @Query(value = "{call list_procedure}", nativeQuery = true)
    List<Coche> listaProcedure();

    @Query(value = "{call id_procedure(:idIn)}", nativeQuery = true)
    Optional<Coche> idProcedure(@Param("idIn") int idIn);

    @Query(value = "{call marca_procedure(:marcaIn)}", nativeQuery = true)
    List<Coche> marcaProcedure(@Param("marcaIn") String marcaIn);

    @Query(value = "{call save_procedure(:marcaIn, :modeloIn, :anioIn, :kmIn)}", nativeQuery = true)
    void saveProcedure(
            @Param("marcaIn") String marca,
            @Param("modeloIn") String modelo,
            @Param("anioIn") int anio,
            @Param("kmIn") int km
    );
}
