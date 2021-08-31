package fr.axel.simpleinventoryspring.service;

import fr.axel.simpleinventoryspring.entity.Product;
import fr.axel.simpleinventoryspring.entity.Site;
import fr.axel.simpleinventoryspring.repository.SiteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService extends fr.axel.simpleinventoryspring.service.Service {

    private final SiteRepository siteRepository;

    @Autowired
    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public Site addNewSite(Site site) {
        return siteRepository.save(site);
    }

    public List<Site> getSite() {
        return siteRepository.findAll();
    }

    public void deleteSiteById(Long siteId) {
        siteRepository.deleteById(siteId);
    }

    public Site updateSite(Site updates, Long siteId) {
        Site currentSite = siteRepository.getById(siteId);
        BeanUtils.copyProperties(updates, currentSite, getNullPropertyNames(updates));
        return siteRepository.save(currentSite);
    }

    public Site getSiteById(Long siteId) {
        return siteRepository.findById(siteId).get();
    }

    public Site addSiteProduct(Long siteId, Product product) {
        Site site = siteRepository.findById(siteId).get();
        site.addProducts(product);
        product.setSite(site);
        return siteRepository.save(site);
    }
}
