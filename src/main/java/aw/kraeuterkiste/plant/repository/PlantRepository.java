package aw.kraeuterkiste.plant.repository;

import aw.kraeuterkiste.plant.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {

}
