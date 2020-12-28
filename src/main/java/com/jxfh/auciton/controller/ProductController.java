package com.jxfh.auciton.controller;

import com.google.common.collect.Maps;
import com.jxfh.auciton.pojo.Computer;
import com.jxfh.auciton.pojo.ProductVO;
import com.jxfh.auciton.pojo.RestResult;
import com.jxfh.auciton.pojo.User;
import com.jxfh.auciton.service.ComputerService;
import com.jxfh.auciton.service.UserService;
import com.jxfh.auciton.util.FileUtil;
import com.jxfh.auciton.util.WebUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2020/12/28.
 */
@RestController
public class ProductController {
    @Resource
    private ComputerService computerService;
    @RequestMapping(value = {"/uploadimg"}, method = RequestMethod.POST)
    public RestResult uploadimg(@RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
        Map<String, String> result = Maps.newHashMap();
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String checkmsg = checkFile(file,extension);
        if("OK".equals(checkmsg)){
            String newFileName = FileUtil.createNewFileName(extension);
            String relativePath = FileUtil.uploadFile(file.getInputStream(), newFileName,FileUtil.getFileType(extension));
            return WebUtils.ok(relativePath);
        }
        return WebUtils.paramError(extension);
    }
    //检查文件大小及格式
    private String checkFile(MultipartFile file,String extension){
        Integer fileType = FileUtil.getFileType(extension);
        if(fileType==null){
            return "文件格式不支持,暂时支持常用图片格式png,jpeg,jpg,bmp,gif";
        }
        long size = file.getSize();
        if(size<=0){
            return "上传文件不能为空";
        }
        return "OK";//检查通过
    }

    //可竞拍的商品列表
    @RequestMapping(value = "/listProduct",method = RequestMethod.GET)
    public RestResult listProduct() {
        List<Computer> listProduct = computerService.listProduct();
        return WebUtils.ok(listProduct);
    }

    //获取商品详情 具有商品竞拍价格的用户
    @RequestMapping(value = "/productDetail",method = RequestMethod.GET)
    public RestResult productDetail(String cId) {
        ProductVO productDetail = computerService.productDetail(cId);
        return WebUtils.ok(productDetail);
    }

    //用户竞拍商品
    @RequestMapping(value = "/auction_product",method = RequestMethod.POST)
    public RestResult auctionProduct(String uId,String cId,Integer price) {
        RestResult restResult= computerService.auctionProduct(uId,cId,price);
        return restResult;
    }
}
