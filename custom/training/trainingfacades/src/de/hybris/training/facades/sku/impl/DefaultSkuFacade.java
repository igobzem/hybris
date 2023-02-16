package de.hybris.training.facades.sku.impl;

import de.hybris.platform.converters.Converters;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.training.core.sku.SkuService;
import de.hybris.training.facades.converters.SkuConverter;
import de.hybris.training.facades.sku.SkuFacade;
import de.hybris.training.facades.product.data.TrainingSkuData;

import java.util.List;

public class DefaultSkuFacade implements SkuFacade {

    private SkuService service;
    private SkuConverter converter;
    @Override
    public List<TrainingSkuData> getSkuData() {
        List<ProductModel> productModelList = service.getProducts();
        return Converters.convertAll(productModelList, converter);
    }

    public void setService(final SkuService service) {
        this.service = service;
    }

    public void setConverter(final SkuConverter converter) {
        this.converter = converter;
    }
}
