package com.coding404.myweb.notice.service;

import com.coding404.myweb.command.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public ArrayList<ProductVO> getName(String prod_id) {
        return noticeMapper.getName(prod_id);
    }
}
