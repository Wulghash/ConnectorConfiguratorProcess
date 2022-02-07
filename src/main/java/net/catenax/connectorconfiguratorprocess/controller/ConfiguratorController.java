package net.catenax.connectorconfiguratorprocess.controller;

import net.catenax.connectorconfiguratorprocess.dto.ConfiguratorDto;
import net.catenax.connectorconfiguratorprocess.service.ConfiguratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfiguratorController {

    @Autowired
    public ConfiguratorService configuratorService;


    @GetMapping
    public void getConfiguratorData(ConfiguratorDto configuratorDto) {
        configuratorService.configurateController(configuratorDto);
    }

}
