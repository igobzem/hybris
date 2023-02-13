package de.hybris.training.facades.sku.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.training.core.sku.SkuService;
import de.hybris.training.facades.sku.SkuFacade;
import de.hybris.training.facades.product.data.TrainingSkuData;

import java.util.ArrayList;
import java.util.List;

public class DefaultSkuFacade implements SkuFacade {

    private SkuService service;
    @Override
    public List<TrainingSkuData> getSkuData() {
        List<ProductModel> productModelList = service.getProducts();
        TrainingSkuData data = new TrainingSkuData();
        List<TrainingSkuData> dataList = new ArrayList<>();
        for (ProductModel productModel : productModelList) {
            data.setDescription(productModel.getCode());
            data.setName(productModel.getName());
            dataList.add(data);
        }
        return dataList;
    }

    public void setService(final SkuService service) {
        this.service = service;
    }
}
