package com.jxfh.auciton.service;

import com.jxfh.auciton.pojo.Computer;
import com.jxfh.auciton.pojo.ProductVO;
import com.jxfh.auciton.pojo.RestResult;

import java.util.List;

/**
 * Created by pc on 2020/12/28.
 */
public interface ComputerService {
    List<Computer> listProduct();

    ProductVO productDetail(String cId);

    RestResult auctionProduct(String uId, String cId, Integer price);
}
