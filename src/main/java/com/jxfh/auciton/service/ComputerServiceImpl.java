package com.jxfh.auciton.service;

import com.jxfh.auciton.dao.ComputerDao;
import com.jxfh.auciton.pojo.Computer;
import com.jxfh.auciton.pojo.ProductVO;
import com.jxfh.auciton.pojo.RestResult;
import com.jxfh.auciton.util.WebUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2020/12/28.
 */
@Service
@Transactional
public class ComputerServiceImpl implements ComputerService {
    @Resource
    private ComputerDao computerDao;

    @Override
    public List<Computer> listProduct() {
        //可竞拍商品 卖出的商品 isAuction 为0 反之为1
        List<Computer> computers = computerDao.listProduct(1);
        return computers;
    }

    @Override
    public ProductVO productDetail(String cId) {
        ProductVO productVO=  computerDao.productDetail(cId);
        return productVO;
    }

    @Override
    public RestResult auctionProduct(String uId, String cId, Integer price) {
        Computer productInfo= computerDao.getProductInfo(cId);
        if(productInfo==null){
            return WebUtils.paramError("订单不存在");
        }
        if(productInfo.getCutOffDate().getTime()<new Date().getTime()){
            return WebUtils.paramError("截止日期已过");
        }
        Integer maxPrice=computerDao.maxPrice(cId);
        if(maxPrice==null){
            if(price<productInfo.getStartPrice()+10){
                return WebUtils.paramError("竞拍价格不能低于初始价格加10");
            }
        }else {
            if(price<maxPrice+10){
                return WebUtils.paramError("竞拍价格不能低于当前最高竞拍价格加10");
            }
        }
        int success=0;
        //判断是不是竞拍过该商品 竞拍过就在原基础上+
        int countAuctionProduct= computerDao.countAuctionProduct(uId,cId);
        if(countAuctionProduct>0){
            success +=computerDao.updateAuctionProduct(uId,cId,price);
            return WebUtils.ok(success);
        }
        //新增竞拍
        success +=computerDao.addAuctionProduct(uId,cId,price);
        return WebUtils.ok(success);
    }
}
