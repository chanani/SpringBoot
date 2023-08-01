package com.coding404.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicVO {

    private int topic_num;
    private String topic_id;
    private String topic_title;
    private String topic_content;
    private String topic_regdate;

}
