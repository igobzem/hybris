package de.hybris.training.core.sku.dao.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.training.core.sku.dao.SkuDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultSkuDao extends AbstractItemDao implements SkuDao {
    @Autowired
    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<ProductModel> getProducts() {
        final String queryString = //
                "SELECT {" + ProductModel.PK + "}, {" + ProductModel.CODE + "},{" + ProductModel.NAME + "[de]}" //
                        + "FROM {" + ProductModel._TYPECODE + "} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return flexibleSearchService.<ProductModel> search(query).getResult();
    }

}