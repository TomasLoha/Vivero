package servicio;

import com.spd.vivero.Planta;

import java.util.List;

public interface PlantaService {

    // Obtener todas las plantas no semillas
    List<Planta> findAllPlants();

    // Guardar una planta no semilla
    Planta savePlant(Planta planta);

    // Obtener una planta por id
    Planta findPlantById(Integer idPlanta);

    // Actualizar una planta por id
    Planta updatePlant(Planta planta);

    // Eliminar una planta por id
    void deletePlant(Integer idPlanta);
}