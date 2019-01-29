package cn.egbert.shop.controller;

import cn.egbert.shop.controller.viewobject.ItemVO;
import cn.egbert.shop.response.CommonReturnType;
import cn.egbert.shop.service.ItemService;
import cn.egbert.shop.service.mode.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller("/item")
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/createItem", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType createItem(@RequestParam(name = "title") String title) {
        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setDescriptions("Descriptions");
        itemModel.setStock(100);
        itemModel.setPrice(new BigDecimal(100.001));
        itemModel.setImgUrl("https://url");
        itemModel.setSales(100);
        ItemModel model = itemService.createItem(itemModel);
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(model, itemVO);
        return CommonReturnType.create(itemVO);
    }

    @RequestMapping(value = "/getItem", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getItem(@RequestParam(name = "id") Integer id) {
        ItemModel model = itemService.getItemById(id);
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(model, itemVO);
        return CommonReturnType.create(itemVO);
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType listItem() {
        List<ItemModel> itemModels = itemService.listItem();
        List<ItemVO> collect = itemModels.stream().map(model -> {
            ItemVO itemVO = new ItemVO();
            BeanUtils.copyProperties(model, itemVO);
            return itemVO;
        }).collect(Collectors.toList());
        return CommonReturnType.create(collect);
    }
}
