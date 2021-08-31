package fr.axel.simpleinventoryspring.repository;

import fr.axel.simpleinventoryspring.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

}
