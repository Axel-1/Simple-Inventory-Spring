package fr.axel.simpleinventoryspring.controller;

import fr.axel.simpleinventoryspring.entity.Warranty;
import fr.axel.simpleinventoryspring.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/warranties")
public class WarrantyController {
    private final WarrantyService warrantyService;

    @Autowired
    public WarrantyController(WarrantyService warrantyService) {
        this.warrantyService = warrantyService;
    }

    @GetMapping
    public List<Warranty> getWarranty() {
        return warrantyService.getWarranty();
    }

    @GetMapping(path = "{warrantyId}")
    public Warranty getWarrantyById(@PathVariable("warrantyId") Long warrantyId) {
        return warrantyService.getWarrantyById(warrantyId);
    }

    @DeleteMapping(path = "{warrantyId}")
    public void deleteWarranty(@PathVariable("warrantyId") Long warrantyId) {
        warrantyService.deleteWarrantyById(warrantyId);
    }

    @PatchMapping(path = "{warrantyId}")
    public Warranty updateWarranty(@PathVariable("warrantyId") Long warrantyId, @RequestBody Warranty updates) {
        return warrantyService.updateWarranty(warrantyId, updates);
    }
}
