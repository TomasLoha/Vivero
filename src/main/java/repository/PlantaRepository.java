/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spd.vivero.Planta;

import java.util.List;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Integer> {

    // Método para encontrar plantas que no son semillas
    List<Planta> findByEsSemillaFalse();

    // Método para encontrar plantas que son semillas
    List<Planta> findByEsSemillaTrue();

}