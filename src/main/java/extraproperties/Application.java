package extraproperties;

import io.micronaut.context.env.MapPropertySource;
import io.micronaut.context.env.PropertySource;
import io.micronaut.runtime.Micronaut;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        Map<String, Object> extra = new HashMap<>();
        extra.put("stringval", "foo");
        extra.put("listval", Arrays.asList("item1", "item2"));

        PropertySource external = MapPropertySource.of(
                "external",
                Collections.singletonMap("extra", extra));

        Micronaut
                .build(args)
                .classes(Application.class)
                .propertySources(external)
                .environmentPropertySource(false)
                .start();
    }
}
