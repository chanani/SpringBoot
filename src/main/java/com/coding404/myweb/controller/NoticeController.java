package com.coding404.myweb.controller;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    @Qualifier("noticeService")
    private NoticeService noticeService;

    @RequestMapping("/noticeList")
    public String noticeList(){
        return "/notice/noticeList";
    }

    @RequestMapping("/noticeReg")
    public String noticeReg(Model model){
        ArrayList<ProductVO> list = noticeService.getName("admin");
        System.out.println(list.toString());

        model.addAttribute("list", list);
        return "/notice/noticeReg";
    }
    @RequestMapping("/noticeDetail")
    public String noticeDetail(){
        return "/notice/noticeDetail";
    }

}
