package fr.axel.simpleinventoryspring.controller;

import fr.axel.simpleinventoryspring.entity.Product;
import fr.axel.simpleinventoryspring.entity.Site;
import fr.axel.simpleinventoryspring.service.ProductService;
import fr.axel.simpleinventoryspring.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sites")
public class SiteController {

    private final SiteService siteService;
    private final ProductService productService;

    @Autowired
    public SiteController(SiteService siteService, ProductService productService) {
        this.siteService = siteService;
        this.productService = productService;
    }

    @GetMapping
    public List<Site> getSite() {
        return siteService.getSite();
    }

    @PostMapping
    public Site addNewSite(@RequestBody Site site) {
        return siteService.addNewSite(site);
    }

    @DeleteMapping(path = "{siteId}")
    public void deleteSite(@PathVariable("siteId") Long siteId) {
        siteService.deleteSiteById(siteId);
    }

    @PatchMapping(path = "{siteId}")
    public Site updateSite(@RequestBody Site updates, @PathVariable("siteId") Long siteId) {
        return siteService.updateSite(updates, siteId);
    }

    @GetMapping(path = "{siteId}")
    public Site updateSite(@PathVariable("siteId") Long siteId) {
        return siteService.getSiteById(siteId);
    }

    @PostMapping(path = "{siteId}/siteProducts")
    public Product addNewProduct(@PathVariable("siteId") Long siteId, @RequestBody Product product) {
        return productService.addNewProduct(product, siteService.getSiteById(siteId));
    }

    @PutMapping(path = "{siteId}/siteProducts/{productId}")
    public Site addSiteProduct(@PathVariable("productId") Long productId, @PathVariable("siteId") Long siteId) {
        return siteService.addSiteProduct(siteId, productService.getProductById(productId));
    }

    @GetMapping(path = "{siteId}/siteProducts")
    public List<Product> getSiteProducts(@PathVariable("siteId") Long siteId) {
        return siteService.getSiteById(siteId).getProducts();
    }

}
