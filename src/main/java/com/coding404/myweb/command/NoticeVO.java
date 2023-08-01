package com.coding404.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeVO {

    private String notice_id;
    private LocalTime notice_regdate;
    private String notice_check_yn;
    private String notice_nickname;
    private String notice_title;
    private String notice_content;
    private String notice_img;

}
