package de.hybris.training.core.sku.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.training.core.sku.SkuService;
import de.hybris.training.core.sku.dao.SkuDao;

import java.util.List;

public class DefaultSkuService implements SkuService {

    private SkuDao dao;

    @Override
    public List<ProductModel> getProducts() {
        return dao.getProducts();
    }

    public void setDao(final SkuDao dao) {
        this.dao = dao;
    }
}
