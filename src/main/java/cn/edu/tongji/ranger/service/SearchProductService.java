package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.Location;
import cn.edu.tongji.ranger.model.Product;
import cn.edu.tongji.ranger.model.SimpleProduct;
import cn.edu.tongji.ranger.utils.SearchCondition;
import cn.edu.tongji.ranger.utils.SearchProductOrderEnum;

import java.util.List;

/**
 * Created by daidongyang on 5/14/16.
 */


public interface SearchProductService {
    List<SimpleProduct>  listProducts(SearchCondition searchCondition);
    List<Location> listLocations(long fatherId);
    Product getProductInfor(long productId);
}
