package fr.axel.simpleinventoryspring.service;

import fr.axel.simpleinventoryspring.entity.Monitoring;
import fr.axel.simpleinventoryspring.entity.Product;
import fr.axel.simpleinventoryspring.entity.Site;
import fr.axel.simpleinventoryspring.entity.Warranty;
import fr.axel.simpleinventoryspring.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends fr.axel.simpleinventoryspring.service.Service {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addNewProduct(Product product, Site site) {
        product.setSite(site);
        return productRepository.save(product);
    }

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    public Product updateProduct(Product updates, Long productId) {
        Product currentProduct = productRepository.getById(productId);
        BeanUtils.copyProperties(updates, currentProduct, getNullPropertyNames(updates));
        return productRepository.save(currentProduct);
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).get();
    }

    public Product addProductMonitoring(Long productId, Monitoring monitoring) {
        Product product = getProductById(productId);
        product.setMonitoring(monitoring);
        monitoring.setProduct(product);
        return productRepository.save(product);
    }

    public Product addProductWarranty(Long productId, Warranty warranty) {
        Product product = getProductById(productId);
        product.setWarranty(warranty);
        warranty.setProduct(product);
        return productRepository.save(product);
    }
}
