package extraproperties;

import io.micronaut.context.annotation.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("notextra")
public interface FromYml {

    String getStringval();

    List<String> getListval();
}
