package com.coding404.myweb.topic.service;

import com.coding404.myweb.command.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("topicService")
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicMapper topicMapper;
    @Override
    public int topicRegist(TopicVO vo) {
        return topicMapper.topicRegist(vo);
    }

    @Override
    public ArrayList<TopicVO> getList() {
        return topicMapper.getList();
    }

    @Override
    public TopicVO getDetail(int topic_num) {
        return topicMapper.Topic_getDetail(topic_num);
    }

    @Override
    public ArrayList<TopicVO> getListMe(String topic_id, String topic_title) {
        return topicMapper.getListMe(topic_id , topic_title);
    }

    @Override
    public int modify(TopicVO vo) {
        return topicMapper.modify(vo);
    }

    @Override
    public int delete(int topic_num) {
        return topicMapper.delete(topic_num);
    }


}
