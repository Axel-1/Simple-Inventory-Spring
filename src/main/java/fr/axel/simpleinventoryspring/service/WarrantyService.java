package fr.axel.simpleinventoryspring.service;

import fr.axel.simpleinventoryspring.entity.Product;
import fr.axel.simpleinventoryspring.entity.Warranty;
import fr.axel.simpleinventoryspring.repository.WarrantyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyService extends fr.axel.simpleinventoryspring.service.Service {
    private final WarrantyRepository warrantyRepository;

    @Autowired
    public WarrantyService(WarrantyRepository warrantyRepository) {
        this.warrantyRepository = warrantyRepository;
    }

    public List<Warranty> getWarranty() {
        return warrantyRepository.findAll();
    }

    public Warranty addNewWarranty(Warranty warranty, Product product) {
        warranty.setProduct(product);
        return warrantyRepository.save(warranty);
    }

    public Warranty getWarrantyById(Long warrantyId) {
        return warrantyRepository.findById(warrantyId).get();
    }

    public void deleteWarrantyById(Long warrantyId) {
        warrantyRepository.deleteById(warrantyId);
    }

    public Warranty updateWarranty(Long warrantyId, Warranty updates) {
        Warranty currentWarranty = getWarrantyById(warrantyId);
        BeanUtils.copyProperties(updates, currentWarranty, getNullPropertyNames(updates));
        return warrantyRepository.save(currentWarranty);
    }
}
