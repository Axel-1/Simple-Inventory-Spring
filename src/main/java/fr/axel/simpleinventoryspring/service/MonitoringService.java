package fr.axel.simpleinventoryspring.service;

import fr.axel.simpleinventoryspring.entity.Monitoring;
import fr.axel.simpleinventoryspring.entity.Product;
import fr.axel.simpleinventoryspring.repository.MonitoringRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoringService extends fr.axel.simpleinventoryspring.service.Service {

    private final MonitoringRepository monitoringRepository;

    @Autowired
    public MonitoringService(MonitoringRepository monitoringRepository) {
        this.monitoringRepository = monitoringRepository;
    }

    public List<Monitoring> getMonitoring() {
        return monitoringRepository.findAll();
    }

    public Monitoring addNewMonitoring(Monitoring monitoring, Product product) {
        monitoring.setProduct(product);
        return monitoringRepository.save(monitoring);
    }

    public void deleteMonitoringById(Long monitoringId) {
        monitoringRepository.deleteById(monitoringId);
    }

    public Monitoring updateMonitoringById(Monitoring updates, Long monitoringId) {
        Monitoring currentMonitoring = getMonitoringById(monitoringId);
        BeanUtils.copyProperties(updates, currentMonitoring, getNullPropertyNames(updates));
        return monitoringRepository.save(currentMonitoring);
    }

    public Monitoring getMonitoringById(Long monitoringId) {
        return monitoringRepository.findById(monitoringId).get();
    }
}
