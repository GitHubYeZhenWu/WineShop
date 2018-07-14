package com.wineshop.mapper;

import com.wineshop.pojo.Shoporders;
import com.wineshop.pojo.ShopordersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopordersMapper {
    int countByExample(ShopordersExample example);

    int deleteByExample(ShopordersExample example);

    int deleteByPrimaryKey(String oid);

    int insert(Shoporders record);

    int insertSelective(Shoporders record);

    List<Shoporders> selectByExample(ShopordersExample example);

    Shoporders selectByPrimaryKey(String oid);

    int updateByExampleSelective(@Param("record") Shoporders record, @Param("example") ShopordersExample example);

    int updateByExample(@Param("record") Shoporders record, @Param("example") ShopordersExample example);

    int updateByPrimaryKeySelective(Shoporders record);

    int updateByPrimaryKey(Shoporders record);

	List<Shoporders> searchOrders(String uid);
}