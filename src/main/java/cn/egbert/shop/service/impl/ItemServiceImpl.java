package cn.egbert.shop.service.impl;

import cn.egbert.shop.dao.ItemDoMapper;
import cn.egbert.shop.dao.ItemStockDoMapper;
import cn.egbert.shop.dataobject.ItemDo;
import cn.egbert.shop.dataobject.ItemStockDo;
import cn.egbert.shop.service.ItemService;
import cn.egbert.shop.service.mode.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDoMapper itemDoMapper;
    @Autowired
    private ItemStockDoMapper stockDoMapper;

    @Override
    @Transactional
    public ItemModel createItem(ItemModel itemModel) {
//        校验入参

//        转化itemmodel->dataobject
        ItemDo itemDo = model2ItemDo(itemModel);

//        写入数据库
        itemDoMapper.insertSelective(itemDo);

        itemModel.setId(itemDo.getId());
        ItemStockDo itemStockDo = model2ItemStockDo(itemModel);
        stockDoMapper.insertSelective(itemStockDo);

//        返回创建完成的对象
        return getItemById(itemModel.getId());
    }

    private ItemDo model2ItemDo(ItemModel model) {
        if (model == null) {
            return null;
        }
        ItemDo itemDo = new ItemDo();
        BeanUtils.copyProperties(model, itemDo);
        itemDo.setPrice(model.getPrice().doubleValue());
        return itemDo;
    }

    private ItemStockDo model2ItemStockDo(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemStockDo itemStockDo = new ItemStockDo();
        itemStockDo.setItemId(itemModel.getId());
        itemStockDo.setStock(itemModel.getStock());
        return itemStockDo;
    }

    @Override
    public List<ItemModel> listItem() {
        List<ItemDo> itemDos = itemDoMapper.listItem();
        List<ItemModel> modelList = itemDos.stream().map(itemDo -> {
            ItemStockDo itemStockDo = stockDoMapper.selectByItemId(itemDo.getId());
            ItemModel itemModel = dataObject2Model(itemDo, itemStockDo);
            return itemModel;
        }).collect(Collectors.toList());
        return modelList;
    }

    @Override
    public ItemModel getItemById(int id) {

        ItemDo itemDo = itemDoMapper.selectByPrimaryKey(id);
        if (itemDo == null) {
            return null;
        }
        ItemStockDo itemStockDo = stockDoMapper.selectByItemId(itemDo.getId());
        return dataObject2Model(itemDo, itemStockDo);
    }

    private ItemModel dataObject2Model(ItemDo itemDo, ItemStockDo itemStockDo) {
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDo, itemModel);
        itemModel.setPrice(new BigDecimal(itemDo.getPrice()));
        itemModel.setStock(itemStockDo.getStock());
        return itemModel;
    }
}
