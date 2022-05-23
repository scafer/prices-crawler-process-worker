package io.github.scafer.prices.crawler.service.pdcp.delegate;

import io.github.scafer.prices.crawler.content.domain.repository.ProductDataRepository;
import io.github.scafer.prices.crawler.content.domain.repository.dao.ProductDao;
import lombok.extern.log4j.Log4j2;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.Spin;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Log4j2
public class FindProductsDelegate implements JavaDelegate {
    @Autowired
    private ProductDataRepository productDataRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        var products = productDataRepository.findAll();
        var productsIds = products.stream().map(ProductDao::getId).collect(Collectors.toList());

        delegateExecution.setVariable("productsIds", Spin.JSON(productsIds));
        log.info("Products List Size: {}", products.size());
    }
}
