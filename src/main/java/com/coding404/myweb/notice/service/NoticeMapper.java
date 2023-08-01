package com.coding404.myweb.notice.service;

import com.coding404.myweb.command.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface NoticeMapper {
    public ArrayList<ProductVO> getName(String prod_id);

}
