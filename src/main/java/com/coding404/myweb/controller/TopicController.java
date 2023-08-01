package com.coding404.myweb.controller;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    @Qualifier("topicService")
    private TopicService topicService;


    @RequestMapping("/topicReg")
    public String topicReg(TopicVO vo){
        return "/topic/topicReg";
    }

    @RequestMapping("/topicListAll")
    public String topicListAll(Model model){
        ArrayList<TopicVO> list = topicService.getList();
        model.addAttribute("list", list);
        return "/topic/topicListAll";
    }

    @RequestMapping("/topicListMe")
    public String topicListMe(@RequestParam("topic_id") String topic_id,
                              @RequestParam("topic_title") String topic_title,
                              Model model) {
        ArrayList<TopicVO> list = topicService.getListMe(topic_id, topic_title);
        model.addAttribute("list", list);
        return "/topic/topicListMe";
    }

    @RequestMapping("/topicModify")
    public String topicModify(@RequestParam("topic_num") int topic_num,
                              Model model){
        TopicVO vo = topicService.getDetail(topic_num);

        model.addAttribute("vo", vo);

        return "/topic/topicModify";
    }

    @RequestMapping("/topicDetail")
    public String topicDetail(@RequestParam("topic_num") int topic_num,
                              Model model){
        TopicVO vo = topicService.getDetail(topic_num);
        model.addAttribute("vo", vo);
        return "/topic/topicDetail";
    }


    @PostMapping("/registForm")
    public String topic_registForm(TopicVO vo,
                                   RedirectAttributes ra){
        int result = topicService.topicRegist(vo);
        String msg = result == 1 ? "등록에 성공하였습니다." : "등록에 실패하였습니다.";
        ra.addFlashAttribute("msg", msg);
        return "redirect:/topic/topicListAll";
    }

    @PostMapping("/topic_modifyForm")
    public String modifyForm(TopicVO vo,
                             RedirectAttributes ra){
        System.out.println(vo.toString());
        int result = topicService.modify(vo);
        String msg = result == 1 ? "수정이 완료되었습니다." : "수정에 실패하였습니다.";
        ra.addFlashAttribute("msg", msg);
        return "redirect:/topic/topicListAll";
    }

    @RequestMapping("/topic_deleteForm")
    public String topic_deleteForm(@RequestParam("topic_num") int topic_num,
                                   RedirectAttributes ra){
        int result = topicService.delete(topic_num);
        String msg = result == 1 ? "삭제가 완료되었습니다." : "삭제에 실패하였습니다.";
        ra.addFlashAttribute("msg", msg);
        return "redirect:/topic/topicListAll";
    }
}
