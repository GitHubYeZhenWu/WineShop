package com.wineshop.mapper;

import com.wineshop.pojo.Category;
import com.wineshop.pojo.Product;
import com.wineshop.pojo.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String pid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String pid);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    List<Category> categoryList();
    
    List<Product> findHotProduct();
    
    List<Product> findNewProduct();

	List<Product> findProductList(String cid);

	List<Product> searchProduct(String keyword);
}