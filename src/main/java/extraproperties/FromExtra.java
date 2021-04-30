package extraproperties;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.Nullable;

import java.util.List;

@ConfigurationProperties("extra")
public interface FromExtra {

    String getStringval();

    @Nullable
    List<String> getListval();
}
