package de.hybris.training.facades.converters;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.ordersplitting.model.StockLevelModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.training.facades.product.data.TrainingSkuData;

import java.util.ArrayList;
import java.util.List;

public class SkuConverter implements Converter<ProductModel, TrainingSkuData> {
    @Override
    public TrainingSkuData convert(final ProductModel productModel) throws ConversionException {
        final TrainingSkuData data = new TrainingSkuData();
        return convert(productModel, data);
    }

    @Override
    public TrainingSkuData convert(final ProductModel productModel, final TrainingSkuData trainingSkuData) throws ConversionException {
        trainingSkuData.setDescription(productModel.getDescription());
        trainingSkuData.setName(productModel.getCode() + " : " +productModel.getName());
        trainingSkuData.setStatus(productModel.getApprovalStatus().getCode());
        List<String> warehouses = new ArrayList<>();
        for (StockLevelModel stockLevelModel: productModel.getStockLevels()) {
            warehouses.add(stockLevelModel.getWarehouse().getCode());
        }
        trainingSkuData.setWarehouses(warehouses);
        return trainingSkuData;
    }
}
