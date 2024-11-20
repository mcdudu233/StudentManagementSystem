package top.mcso.sms.utils;


/**
 * 格式化工具
 * 将各种数据格式化成字符串
 *
 * @author dudu233
 * @create: 2024-11-20 20:40
 * @version: 1.0
 */

public class FormatUtils {
    /**
     * 将数字星期转换成字符串
     *
     * @param week: int 星期
     * @return String: 星期的字符串
     */
    String getWeek(int week) {
        return switch (week) {
            case 1 -> "星期一";
            case 2 -> "星期二";
            case 3 -> "星期三";
            case 4 -> "星期四";
            case 5 -> "星期五";
            case 6 -> "星期六";
            case 7 -> "星期天";
            default -> "未知";
        };
    }

    /**
     * 将数字的第几节课转换成字符串
     *
     * @param day: int 每天中的第几节课
     * @return String: 字符串后的第几节课
     */
    String getDay(int day) {
        return switch (day) {
            case 1 -> "上午第一节";
            case 2 -> "上午第二节";
            case 3 -> "上午第三节";
            case 4 -> "上午第四节";
            case 5 -> "下午第一节";
            case 6 -> "下午第二节";
            case 7 -> "下午第三节";
            case 8 -> "下午第四节";
            case 9 -> "晚上第一节";
            case 10 -> "晚上第二节";
            case 11 -> "晚上第三节";
            default -> "未知";
        };
    }

    /**
     * 将数字的上课时间转换成字符串
     *
     * @param week: int 星期
     * @param day:  int 每天中的第几节课
     * @return String: 上课时间
     */
    String getClassTime(int week, int day) {
        return getWeek(week) + getDay(day);
    }
}
