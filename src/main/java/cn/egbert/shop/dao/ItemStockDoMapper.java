package cn.egbert.shop.dao;

import cn.egbert.shop.dataobject.ItemStockDo;

public interface ItemStockDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    int insert(ItemStockDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    int insertSelective(ItemStockDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    ItemStockDo selectByPrimaryKey(Integer id);

    ItemStockDo selectByItemId(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    int updateByPrimaryKeySelective(ItemStockDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    int updateByPrimaryKey(ItemStockDo record);
}