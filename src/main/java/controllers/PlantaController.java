package controllers;

import com.spd.vivero.Planta;
import repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class PlantaController {

    @Autowired
    private PlantaRepository plantaRepository;

    // Obtener todas las plantas
    @GetMapping("/plantas")
    public List<Planta> findAllPlants() {
        return plantaRepository.findByEsSemillaFalse();
    }

    // Obtener todas las plantas semillas
    @GetMapping("/semillas")
    public List<Planta> findAllSemillas() {
        return plantaRepository.findByEsSemillaTrue();
    }

    // Guardar una planta/semilla
    @PostMapping("/plantas")
    public Planta savePlant(@Validated @RequestBody Planta planta) {
        return plantaRepository.save(planta);
    }

    // Obtener una planta por id
    @GetMapping("planta/{id}")
    public ResponseEntity<Planta> findPlantById(@PathVariable(value = "id") Integer idPlanta) {
        Planta planta = plantaRepository.findById(idPlanta).orElse(null);
        if (planta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(planta);
    }

    // Actualizar una planta por id
    @PutMapping("planta/{id}")
    public ResponseEntity<Planta> updatePlant(@PathVariable(value = "id") Integer idPlanta,
            @Validated @RequestBody Planta plantaDetails) {
        Planta planta = plantaRepository.findById(idPlanta).orElse(null);
        if (planta == null) {
            return ResponseEntity.notFound().build();
        }
        planta.setNombre(plantaDetails.getNombre());
        planta.setEspecie(plantaDetails.getEspecie());
        planta.setGenero(plantaDetails.getGenero());
        Planta updatedPlanta = plantaRepository.save(planta);
        return ResponseEntity.ok(updatedPlanta);
    }

    // Eliminar una planta por id
    @DeleteMapping("planta/{id}")
    public ResponseEntity<Planta> deletePlant(@PathVariable(value = "id") Integer idPlanta) {
        Planta planta = plantaRepository.findById(idPlanta).orElse(null);
        if (planta == null) {
            return ResponseEntity.notFound().build();
        }
        plantaRepository.delete(planta);
        return ResponseEntity.ok(planta);
    }
}
