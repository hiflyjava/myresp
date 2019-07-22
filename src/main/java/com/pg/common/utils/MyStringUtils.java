package com.pg.common.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/6/11 20:18
 * @Description:
 */
public class MyStringUtils {



    public static String fmtMicrometer(String text)
    {
        DecimalFormat df = null;
        if(text.indexOf(".") > 0)
        {
            if(text.length() - text.indexOf(".")-1 == 0)
            {
                df = new DecimalFormat("###,##0.");
            }else if(text.length() - text.indexOf(".")-1 == 1)
            {
                df = new DecimalFormat("###,##0.0");
            }else
            {
                df = new DecimalFormat("###,##0.00");
            }
        }else
        {
            df = new DecimalFormat("###,##0");
        }
        double number = 0.0;
        try {
            number = Double.parseDouble(text);
        } catch (Exception e) {
            number = 0.0;
        }
        return df.format(number);
    }



    public static Integer[]  stringToArra(String string){

       // List<Integer> integerList =new ArrayList<>();
        //String str = "12,34,65,85,45,11"; //定义一个由整型构成的字符串
        String[] strArr = string.split(","); //然后使用split方法将字符串拆解到字符串数组中
        Integer[] intArr = new Integer[strArr.length]; //定义一个长度与上述的字符串数组长度相通的整型数组

        for(int a=0;a<strArr.length;a++){
            intArr[a] = Integer.valueOf(strArr[a]); //然后遍历字符串数组，使用包装类Integer的valueOf方法将字符串转为整型
        }
        /*for(int b=0;b<intArr.length;b++){
            integerList.add(intArr[b]);
        }*/
       return  intArr;
    }


}
