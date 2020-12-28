package com.jxfh.auciton.dao;

import com.jxfh.auciton.pojo.Computer;
import com.jxfh.auciton.pojo.ProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by pc on 2020/12/28.
 */
public interface ComputerDao {
    //不可竞拍的列表
    List<Computer> listProduct(@Param("flag") Integer flag);

    ProductVO productDetail(@Param("cId") String cId);

    /**
     *
     * @param cId
     * @return 获取商品详情
     */
    Computer getProductInfo(@Param("cId") String cId);

    /**
     *
     * @param cId
     * @return 获取最高价格
     */
    Integer maxPrice(@Param("cId") String cId);

    int updateAuctionProduct(@Param("uId") String uId,@Param("cId") String cId,@Param("price") Integer price);

    int countAuctionProduct(@Param("uId") String uId,@Param("cId") String cId);

    int addAuctionProduct(@Param("uId") String uId,@Param("cId") String cId,@Param("price") Integer price);
}
