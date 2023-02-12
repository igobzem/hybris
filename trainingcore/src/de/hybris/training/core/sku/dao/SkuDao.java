package de.hybris.training.core.sku.dao;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.internal.dao.Dao;

import java.util.List;

public interface SkuDao extends Dao {
    List<ProductModel> getProducts();
}
