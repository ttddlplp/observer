
package org.gzeng.observer;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.ws.rs.core.Configurable;
import java.util.Properties;

public class ObserverWebServiceApplication extends ResourceConfig {
    public ObserverWebServiceApplication() {
        packages("org.gzeng.observer_ws.resources");
        registerCompressionComponents(this);
        registerJacksonComponents(this);

        register(new AbstractBinder() {
            @Override
            protected void configure() {
            }

            SessionFactory provideSessionFactory() {
                try {
                    Properties properties = new Properties();
                    properties.load(getClassLoader().getResourceAsStream("/Hibernate.properties"));
                    Configuration configuration = new Configuration();
                    configuration.setProperties(properties);

                    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                    return configuration.buildSessionFactory(builder.build());
                } catch (Throwable ex) {
                    System.err.println("Initial SessionFactory creation failed." + ex);
                    throw new ExceptionInInitializerError(ex);
                }
            }
        });
    }

    public static void registerCompressionComponents(Configurable<?> config) {
        config.register(EncodingFilter.class);
        config.register(GZipEncoder.class);
    }

    public static void registerJacksonComponents(Configurable<?> config) {
        config.register(JacksonFeature.class);
    }
}