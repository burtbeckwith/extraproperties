package extraproperties;

import io.micronaut.context.annotation.Property;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.event.ApplicationStartupEvent;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class ConfigDumper implements ApplicationEventListener<ApplicationStartupEvent> {

    private final FromYml fromYml;
    private final FromExtra fromExtra;
    private final Map<String, String> notextra;
    private final Map<String, String> extra;

    public ConfigDumper(FromYml fromYml,
                        FromExtra fromExtra,
                        @Property(name = "notextra") Map<String, String> notextra,
                        @Property(name = "extra") Map<String, String> extra) {
        this.fromYml = fromYml;
        this.fromExtra = fromExtra;
        this.notextra = notextra;
        this.extra = extra;
    }

    @Override
    public void onApplicationEvent(ApplicationStartupEvent event) {
        System.out.println("\n'foo' from application.yml: " + fromYml.getStringval());
        System.out.println("\n[item1, item2] list from application.yml: " + fromYml.getListval());
        System.out.println("\n'notextra' from application.yml: " + notextra);

        System.out.println("\n'foo' from external: " + fromExtra.getStringval());
        System.out.println("\n[item1, item2] list from external: " + fromExtra.getListval());
        System.out.println("\n'extra' from external: " + extra);
    }
}
