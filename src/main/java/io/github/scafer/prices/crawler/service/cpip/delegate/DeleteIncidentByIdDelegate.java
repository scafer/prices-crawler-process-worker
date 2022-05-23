package io.github.scafer.prices.crawler.service.cpip.delegate;

import io.github.scafer.prices.crawler.service.cpip.ClearProductIncidentsService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteIncidentByIdDelegate implements JavaDelegate {
    @Autowired
    private ClearProductIncidentsService clearProductIncidentsService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        var productId = delegateExecution.getVariable("productId");
        clearProductIncidentsService.deleteIncident(productId.toString());
    }
}
