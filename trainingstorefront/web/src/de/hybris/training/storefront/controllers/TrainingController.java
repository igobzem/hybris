package de.hybris.training.storefront.controllers;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.training.core.sku.SkuService;
import de.hybris.training.facades.sku.SkuFacade;
import de.hybris.training.facades.product.data.TrainingSkuData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TrainingController {
    @Autowired
    SkuFacade facade;

    @RequestMapping(value = "/lowStockSKU")
    public String showBands(final Model model)
    {
        List<TrainingSkuData> dataList = facade.getSkuData();
        model.addAttribute("SKU", dataList.size());
        List<String> products = new ArrayList<String>();
        for(TrainingSkuData data: dataList) {
            products.add(data.getDescription() + ":" + data.getName());
        }
        model.addAttribute("products", products);
        return "pages/error/lowStockSKU";
    }

}
