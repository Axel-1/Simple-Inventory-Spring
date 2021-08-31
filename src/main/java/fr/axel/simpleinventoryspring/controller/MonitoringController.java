package fr.axel.simpleinventoryspring.controller;

import fr.axel.simpleinventoryspring.entity.Monitoring;
import fr.axel.simpleinventoryspring.service.MonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/monitorings")
public class MonitoringController {

    private final MonitoringService monitoringService;

    @Autowired
    public MonitoringController(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @GetMapping
    public List<Monitoring> getMonitoring() {
        return monitoringService.getMonitoring();
    }

    @DeleteMapping(path = "{monitoringId}")
    public void deleteMonitoring(@PathVariable("monitoringId") Long monitoringId) {
        monitoringService.deleteMonitoringById(monitoringId);
    }

    @PatchMapping(path = "{monitoringId}")
    public Monitoring updateMonitoring(@PathVariable("monitoringId") Long monitoringId, @RequestBody Monitoring updates) {
        return monitoringService.updateMonitoringById(updates, monitoringId);
    }

    @GetMapping(path = "{monitoringId}")
    public Monitoring getMonitoringById(@PathVariable("monitoringId") Long monitoringId) {
        return monitoringService.getMonitoringById(monitoringId);
    }
}
