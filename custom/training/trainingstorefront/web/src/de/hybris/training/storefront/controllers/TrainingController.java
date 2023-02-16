package de.hybris.training.storefront.controllers;

import de.hybris.training.facades.sku.SkuFacade;
import de.hybris.training.facades.product.data.TrainingSkuData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TrainingController {
    @Autowired
    SkuFacade facade;

    @RequestMapping(value = "/lowStockSKU")
    public String showLowStockSKU(final Model model)
    {
        List<TrainingSkuData> dataList = facade.getSkuData();
        model.addAttribute("SKU", dataList.size());
        List<String> products = new ArrayList<String>();
        for(TrainingSkuData data: dataList) {
            products.add(data.getName() + " status:" + data.getStatus());
            for (String warehouse : data.getWarehouses()) {
                products.add(" warehouse:"+ warehouse);
            }
        }
        model.addAttribute("products", products);
        return "pages/error/lowStockSKU";
    }

}
