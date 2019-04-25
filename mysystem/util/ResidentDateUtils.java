package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 郑鸿博
 * @Date: 2019/4/25/025 15:35
 * @Description:
 */
public class ResidentDateUtils {

    /**
     * date转格式
     *
     * @param date
     * @return
     */
    public static String dateFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static void main(String[] args) {
        System.out.println("北京时间:" + dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"));

    }

}
