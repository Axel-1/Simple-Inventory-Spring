package fr.axel.simpleinventoryspring.repository;

import fr.axel.simpleinventoryspring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
