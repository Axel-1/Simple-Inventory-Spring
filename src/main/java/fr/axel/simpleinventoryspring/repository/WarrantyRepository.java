package fr.axel.simpleinventoryspring.repository;

import fr.axel.simpleinventoryspring.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarrantyRepository extends JpaRepository<Warranty, Long> {
}
