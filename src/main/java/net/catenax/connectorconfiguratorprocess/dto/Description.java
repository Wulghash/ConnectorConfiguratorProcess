package net.catenax.connectorconfiguratorprocess.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Description {
    public Maintainer maintainer;
    public String info;
    public Credentials credentials;
}
