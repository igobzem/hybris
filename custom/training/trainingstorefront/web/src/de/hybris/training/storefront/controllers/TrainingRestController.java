package de.hybris.training.storefront.controllers;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.training.core.sku.SkuService;
import de.hybris.training.facades.product.data.TrainingSkuData;
import de.hybris.training.facades.sku.SkuFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingRestController {
    private static final Logger LOG = LoggerFactory.getLogger(TrainingRestController.class);
    @Autowired
    SkuService service;
    @Autowired
    SkuFacade facade;

    @RequestMapping(value = "/skuService")
    public List<ProductModel> showModel()
    {
        return service.getProducts();
    }
    @RequestMapping(value = "/skuFacade")
    public List<TrainingSkuData> showFacade()
    {
        return facade.getSkuData();
    }


}
