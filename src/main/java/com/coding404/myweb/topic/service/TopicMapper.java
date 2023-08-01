package com.coding404.myweb.topic.service;

import com.coding404.myweb.command.TopicVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface TopicMapper {
    public int topicRegist(TopicVO vo);
    public ArrayList<TopicVO> getList ();
    public  TopicVO Topic_getDetail(int topic_num);
    public ArrayList<TopicVO> getListMe(String topic_id, String topic_title);
    public int modify(TopicVO vo);
    public int delete(int topic_num);

}
