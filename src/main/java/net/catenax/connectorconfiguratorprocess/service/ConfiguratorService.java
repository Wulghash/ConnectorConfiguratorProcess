package net.catenax.connectorconfiguratorprocess.service;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import net.catenax.connectorconfiguratorprocess.dto.ConfiguratorDto;
import org.springframework.stereotype.Service;

@Service
public class ConfiguratorService {

    public void configurateController(ConfiguratorDto configuratorDto) {
        try (KubernetesClient client = new DefaultKubernetesClient()) {
            CustomResourceDefinition crd = client.apiextensions().v1().customResourceDefinitions()
                    .load(ConfiguratorService.class.getResourceAsStream("/book-crd.yaml"))
                    .get();
            client.apiextensions().v1().customResourceDefinitions().createOrReplace(crd);
        }
    }
}
