package com.wumj.demo.dateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wumj
 * @date 2020-06-20 13:30
 */
public class DateFormatThreadLocal {
    public static final ThreadLocal<DateFormat> df=new ThreadLocal<DateFormat>(){
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyyMMdd");
        }

    };

    public static Date convert(String source) throws ParseException {
        return df.get().parse(source);
    }
}
