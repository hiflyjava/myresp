package com.pg.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/4/26 10:52
 * @Description:
 */
public class MyDateUtils {

      private  static   Logger logger = LoggerFactory.getLogger(MyDateUtils.class);

    //得到今天的零时时间
    public static Date  getTodayZeroTime (){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();

        return  zero;
    }
    //得到今天23点时间
    public static  Date getTodayEndTime(){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());
        calendar1.set(Calendar.HOUR_OF_DAY, 23);
        calendar1.set(Calendar.MINUTE, 59);
        calendar1.set(Calendar.SECOND, 59);
        Date zero1 = calendar1.getTime();
        return zero1;
    }

    //根据开始时间得到7天后每一天日期
    public static List<String> getSevenDaysAfter(String startTime){
        SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> dateList =new ArrayList<>();
        for(int n=0;n<=7;n++){

            Date date= null;
            try {
                date = s.parse(startTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar  =   Calendar.getInstance();
            calendar.setTime(date); //需要将date数据转移到Calender对象中操作
            calendar.add(calendar.DATE, n);//把日期往后增加n天.正数往后推,负数往前移动
            date=calendar.getTime();   //这个时间就是日期往后推一天的结果
            String ss = s.format(date);
            System.out.println(ss);
            dateList.add(ss);
        }
        return  dateList;
    }



    //根据开始时间得到7天后每一天日期
    public static List<String> getFourteenDaysAfter(String startTime){
        SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> dateList =new ArrayList<>();
        for(int n=0;n<=14;n++){

            Date date= null;
            try {
                date = s.parse(startTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar  =   Calendar.getInstance();
            calendar.setTime(date); //需要将date数据转移到Calender对象中操作
            calendar.add(calendar.DATE, n);//把日期往后增加n天.正数往后推,负数往前移动
            date=calendar.getTime();   //这个时间就是日期往后推一天的结果
            String ss = s.format(date);
            System.out.println(ss);
            dateList.add(ss);
        }
        return  dateList;
    }

    //得到时间戳
    public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    //得到时间戳
    public static long dateToStamplong(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        //res = String.valueOf(ts);
        return ts;
    }


    //得到时间戳
    public static long dateToStamplongHms(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        //res = String.valueOf(ts);
        return ts;
    }

    //得到两个日期的相差天数
    public static long getDaySub(String beginDateStr,String endDateStr)
    {
        long day=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate;
        java.util.Date endDate;
        try
        {
            beginDate = format.parse(beginDateStr);
            endDate= format.parse(endDateStr);
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("相隔的天数="+day);
        } catch (ParseException e)
        {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
        return day;
    }

    //得到两个日期差的中间时间
    public static List<String> getDaysBetwAnd(String startTime,String endTime){
        long z=0;
        long daySub = MyDateUtils.getDaySub(startTime, endTime);
        if(daySub==0){
            z=1;
        }else{
            z=daySub+1;
        }

        SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> dateList =new ArrayList<>();
        for(int n=0;n<=z;n++){

            Date date= null;
            try {
                date = s.parse(startTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar  =   Calendar.getInstance();
            calendar.setTime(date); //需要将date数据转移到Calender对象中操作
            calendar.add(calendar.DATE, n);//把日期往后增加n天.正数往后推,负数往前移动
            date=calendar.getTime();   //这个时间就是日期往后推一天的结果
            String ss = s.format(date);
            //System.out.println(ss);
            logger.info("check time ===>> [{}]",ss);
            dateList.add(ss);
        }
        return  dateList;
    }

}
