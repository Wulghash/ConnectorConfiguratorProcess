package net.catenax.connectorconfiguratorprocess.service;

import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
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

            //
            MixedOperation<ConfiguratorDto, KubernetesResourceList<ConfiguratorDto>, Resource<ConfiguratorDto>>
                    configuratorClient = client.customResources(ConfiguratorDto.class);

            String namespace = "default";
            KubernetesResourceList<ConfiguratorDto> configurators = configuratorClient.inNamespace(namespace).list();

        }
    }
}
