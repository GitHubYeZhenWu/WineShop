package com.wineshop.mapper;

import com.wineshop.pojo.Shopcart;
import com.wineshop.pojo.ShopcartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopcartMapper {
    int countByExample(ShopcartExample example);

    int deleteByExample(ShopcartExample example);

    int insert(Shopcart record);

    int insertSelective(Shopcart record);

    List<Shopcart> selectByExample(ShopcartExample example);

    int updateByExampleSelective(@Param("record") Shopcart record, @Param("example") ShopcartExample example);

    int updateByExample(@Param("record") Shopcart record, @Param("example") ShopcartExample example);

	List<Shopcart> searchShopCart(String uid);

	void deleteProductFromCart(@Param("uid")String uid, @Param("pid")String pid);

	void clearShopCart(@Param("uid")String uid);

	Shopcart cheackProductExist(@Param("pid")String pid,@Param("uid")String uid);


	void updateProductNum(@Param("uid")String uid,@Param("pid")String pid, @Param("newCount")int newCount);
}