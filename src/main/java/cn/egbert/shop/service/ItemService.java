package cn.egbert.shop.service;

import cn.egbert.shop.service.mode.ItemModel;

import java.util.List;

public interface ItemService {
    //    创建商品
    ItemModel createItem(ItemModel itemModel);

    //商品列表浏览
    List<ItemModel> listItem();

    //    商品详情浏览
    ItemModel getItemById(int id);
}
