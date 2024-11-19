package top.mcso.sms.entity;

import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Announcement {
    private String id ;
    private String announcement;


    @Override
    public String toString() {
        return "公告 [序号=" + id + ", 公告=" + announcement + "]";
    }
}