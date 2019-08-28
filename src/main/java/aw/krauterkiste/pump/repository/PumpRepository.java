package aw.krauterkiste.pump.repository;

import aw.krauterkiste.pump.model.Pump;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PumpRepository extends JpaRepository<Pump, Long> {

    Pump findTopByOrderByPumpDateTimeDesc();
}