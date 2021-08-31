package fr.axel.simpleinventoryspring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Monitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ip;
    private LocalDateTime lastPing;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonBackReference
    private Product product;

    public Monitoring() {
    }

    public Monitoring(Long id, String ip, LocalDateTime lastPing, Product product) {
        this.id = id;
        this.ip = ip;
        this.lastPing = lastPing;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getLastPing() {
        return lastPing;
    }

    public void setLastPing(LocalDateTime lastPing) {
        this.lastPing = lastPing;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Monitoring{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", lastPing=" + lastPing +
                ", product=" + product +
                '}';
    }
}
