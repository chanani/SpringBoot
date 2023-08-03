package com.coding404.myweb.product.service;


import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public interface ProductService {

    public int productRegist(ProductVO vo);
    public ArrayList<ProductVO> getList(String writer, Criteria cri); // 조회
    public int getTotal(String writer, Criteria cri); // 전체게시글 수
    public ProductVO getDetail(int prod_id); // 상세 -  prod_id(pk) 필요 1행
    public int productUpdate(ProductVO vo);
    public void productDelete(int prod_id);

    // 카테고리처리
    public ArrayList<CategoryVO> getCategory();
    public ArrayList<CategoryVO> getCategoryChild(CategoryVO vo);






}
