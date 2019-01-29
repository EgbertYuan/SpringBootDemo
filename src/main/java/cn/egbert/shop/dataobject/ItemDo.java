package cn.egbert.shop.dataobject;

public class ItemDo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.id
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.title
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.price
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.descriptions
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    private String descriptions;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.sales
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    private Integer sales;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.img_url
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    private String imgUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.id
     *
     * @return the value of item.id
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.id
     *
     * @param id the value for item.id
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.title
     *
     * @return the value of item.title
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.title
     *
     * @param title the value for item.title
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.price
     *
     * @return the value of item.price
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.price
     *
     * @param price the value for item.price
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.descriptions
     *
     * @return the value of item.descriptions
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    public String getDescriptions() {
        return descriptions;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.descriptions
     *
     * @param descriptions the value for item.descriptions
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions == null ? null : descriptions.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.sales
     *
     * @return the value of item.sales
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.sales
     *
     * @param sales the value for item.sales
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.img_url
     *
     * @return the value of item.img_url
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.img_url
     *
     * @param imgUrl the value for item.img_url
     *
     * @mbg.generated Wed Jan 23 16:39:40 CST 2019
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}