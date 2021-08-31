package fr.axel.simpleinventoryspring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private String manufacturer;
    @ManyToOne
    @JoinColumn(name = "site_id", referencedColumnName = "id")
    @JsonBackReference
    private Site site;
    @Nullable
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Monitoring monitoring;
    @Nullable
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Warranty warranty;

    public Product() {
    }

    public Product(Long id, String productName, String manufacturer, Site site, @Nullable Monitoring monitoring, @Nullable Warranty warranty) {
        this.id = id;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.site = site;
        this.monitoring = monitoring;
        this.warranty = warranty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    @Nullable
    public Monitoring getMonitoring() {
        return monitoring;
    }

    public void setMonitoring(@Nullable Monitoring monitoring) {
        this.monitoring = monitoring;
    }

    @Nullable
    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(@Nullable Warranty warranty) {
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", site=" + site +
                ", monitoring=" + monitoring +
                ", warranty=" + warranty +
                '}';
    }
}
