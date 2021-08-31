package fr.axel.simpleinventoryspring.repository;

import fr.axel.simpleinventoryspring.entity.Monitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringRepository extends JpaRepository<Monitoring, Long> {
}
