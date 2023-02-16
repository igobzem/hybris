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
//        final String queryString =
//                "SELECT {" + ProductModel.PK + "} "
//                        + "FROM {" + ProductModel._TYPECODE + " as p join "
//                        + StockLevelModel._TYPECODE + " as s on {p."
//                        + ProductModel.CODE + "} = {s." + StockLevelModel.PRODUCTCODE
//                        + "}} where {s." + StockLevelModel.AVAILABLE + "} < '5'";
        final String queryString =
                "SELECT {p.pk} FROM {Product AS p} where EXISTS ({{select * from {StockLevel as s} where {s.productCode} = {p.code} and {s.available} < '5' }})";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return flexibleSearchService.<ProductModel> search(query).getResult();
    }

}