package servicio;

import com.spd.vivero.Planta;
import repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlantaServiceImpl implements PlantaService {

    @Autowired
    private PlantaRepository plantaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Planta> findAllPlants() {
        return plantaRepository.findByEsSemillaFalse();
    }

    @Override
    @Transactional
    public Planta savePlant(Planta planta) {
        return plantaRepository.save(planta);
    }

    @Override
    @Transactional(readOnly = true)
    public Planta findPlantById(Integer idPlanta) {
        return plantaRepository.findById(idPlanta).orElse(null);
    }

    @Override
    @Transactional
    public Planta updatePlant(Planta planta) {
        return plantaRepository.save(planta);
    }

    @Override
    @Transactional
    public void deletePlant(Integer idPlanta) {
        plantaRepository.deleteById(idPlanta);
    }
}
