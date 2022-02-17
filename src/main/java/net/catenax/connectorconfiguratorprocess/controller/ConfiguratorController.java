package net.catenax.connectorconfiguratorprocess.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catenax.connectorconfiguratorprocess.dto.ConfiguratorDto;
import net.catenax.connectorconfiguratorprocess.service.ConfiguratorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("connectorconfigurator")
@RequiredArgsConstructor
@Slf4j
public class ConfiguratorController {

    @Autowired
    public ConfiguratorService configuratorService;


    @PostMapping(path = "/v1/configurator")
    public void configurateConnector(ConfiguratorDto configuratorDto) {
        configuratorService.configurateController(configuratorDto);
    }

}
