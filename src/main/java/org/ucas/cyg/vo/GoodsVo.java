package org.ucas.cyg.vo;

import org.ucas.cyg.domain.Goods;

import java.util.Date;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/3 16:06
 * @Description:
 */
public class GoodsVo extends Goods {
    private double miaoshaPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;

    public double getMiaoshaPrice() {
        return miaoshaPrice;
    }

    public void setMiaoshaPrice(double miaoshaPrice) {
        this.miaoshaPrice = miaoshaPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "GoodsVo{" +
                "miaoshaPrice=" + miaoshaPrice +
                ", stockCount=" + stockCount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
