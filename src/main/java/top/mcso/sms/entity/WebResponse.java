package top.mcso.sms.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网页响应数据
 *
 * @author dudu233
 * @create: 2024-11-20 22:43
 * @version: 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WebResponse {
    private int code;
    private String msg;
}
