package net.catenax.connectorconfiguratorprocess.dto;

import io.fabric8.kubernetes.client.CustomResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguratorDto extends CustomResource {
    public String organization;
    public String instance;
    public Description description;
}
