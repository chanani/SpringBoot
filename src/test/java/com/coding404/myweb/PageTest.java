package com.coding404.myweb;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.service.ProductMapper;
import com.coding404.myweb.util.Criteria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class PageTest {

    @Autowired
    private ProductMapper productMapper;

//    @Test
//    public void testCode1(){
//
//        for (int i = 1; i <= 100; i++) {
//        ProductVO vo = ProductVO.builder()
//                .prod_enddate("2023-05-15")
//                .prod_writer("aaa123")
//                .prod_name("test" + i)
//                .prod_price(1000 + i)
//                .prod_count(100 + i)
//                .prod_discount(1 + i)
//                .prod_purchase_yn("Y")
//                .prod_content("abcdefg" + i)
//                .prod_comment("test")
//                .build();
//
//        productMapper.productRegist(vo);
//        }
//    }
    @Test
    public void testCode02()  {
        //Criteria cri = new Criteria(1, 10);
        //Criteria cri = new Criteria(2, 10);
        Criteria cri = new Criteria(1, 100);
        ArrayList<ProductVO> list = productMapper.getList("admin", cri);
        System.out.println(list.toString());
    }



}
