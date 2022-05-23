package io.github.scafer.prices.crawler.service.dbrp;

import io.github.scafer.prices.crawler.service.dbrp.delegate.LocaleAndCatalogImporterDelegate;
import io.github.scafer.prices.crawler.service.dbrp.delegate.ProductImporterDelegate;
import io.github.scafer.prices.crawler.service.dbrp.delegate.ProductIncidentImporterDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseRestoreAdapter {
    @Bean
    public LocaleAndCatalogImporterDelegate localeAndCatalogImporterDelegate() {
        return new LocaleAndCatalogImporterDelegate();
    }

    @Bean
    public ProductImporterDelegate productImporterDelegate() {
        return new ProductImporterDelegate();
    }

    @Bean
    public ProductIncidentImporterDelegate productIncidentImporterDelegate() {
        return new ProductIncidentImporterDelegate();
    }
}
