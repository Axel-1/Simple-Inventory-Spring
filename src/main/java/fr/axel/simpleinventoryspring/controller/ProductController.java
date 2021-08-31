package fr.axel.simpleinventoryspring.controller;

import fr.axel.simpleinventoryspring.entity.Monitoring;
import fr.axel.simpleinventoryspring.entity.Product;
import fr.axel.simpleinventoryspring.entity.Warranty;
import fr.axel.simpleinventoryspring.service.MonitoringService;
import fr.axel.simpleinventoryspring.service.ProductService;
import fr.axel.simpleinventoryspring.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final MonitoringService monitoringService;
    private final WarrantyService warrantyService;

    @Autowired
    public ProductController(ProductService productService, MonitoringService monitoringService, WarrantyService warrantyService) {
        this.productService = productService;
        this.monitoringService = monitoringService;
        this.warrantyService = warrantyService;
    }

    @GetMapping
    public List<Product> getProduct() {
        return productService.getProduct();
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProductById(productId);
    }

    @PatchMapping(path = "{productId}")
    public Product updateProduct(@RequestBody Product updates, @PathVariable("productId") Long productId) {
        return productService.updateProduct(updates, productId);
    }

    @GetMapping(path = "{productId}")
    public Product getProductById(@PathVariable("productId") Long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping(path = "{productId}/productMonitoring")
    public Monitoring addNewMonitoring(@PathVariable("productId") Long productId, @RequestBody Monitoring monitoring) {
        return monitoringService.addNewMonitoring(monitoring, productService.getProductById(productId));
    }

    @GetMapping(path = "{productId}/productMonitoring")
    public Monitoring getProductMonitoring(@PathVariable("productId") Long productId) {
        return productService.getProductById(productId).getMonitoring();
    }

    @PutMapping(path = "{productId}/productMonitoring/{monitoringId}")
    public Product addProductMonitoring(@PathVariable("productId") Long productId, @PathVariable("monitoringId") Long monitoringId) {
        return productService.addProductMonitoring(productId, monitoringService.getMonitoringById(monitoringId));
    }

    @PostMapping(path = "{productId}/productWarranty")
    public Warranty addNewWarranty(@PathVariable("productId") Long productId, @RequestBody Warranty warranty) {
        return warrantyService.addNewWarranty(warranty, productService.getProductById(productId));
    }

    @GetMapping(path = "{productId}/productWarranty")
    public Warranty getProductWarranty(@PathVariable("productId") Long productId) {
        return productService.getProductById(productId).getWarranty();
    }

    @PutMapping(path = "{productId}/productWarranty/{warrantyId}")
    public Product addProductWarranty(@PathVariable("productId") Long productId, @PathVariable("warrantyId") Long warrantyId) {
        return productService.addProductWarranty(productId, warrantyService.getWarrantyById(warrantyId));
    }
}
