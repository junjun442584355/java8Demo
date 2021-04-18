package com.wumj.demo.test;


import org.apache.commons.lang3.StringUtils;

/**
 * @author wumj
 * @date 2021-04-15 15:47
 * @description
 */
public enum WeekEnum {
    MONDAY("MONDAY","星期一"),
    TUESDAY("TUESDAY","星期二"),
    WEDNESDAY("WEDNESDAY","星期三"),
    THURSDAY("THURSDAY","星期四"),
    FRIDAY("FRIDAY","星期五"),
    SATURDAY("SATURDAY","星期六"),
    SUNDAY("SUNDAY","星期天");

    private String name;
    private String detail;

    WeekEnum(String name, String detail){
        this.name = name;
        this.detail=detail;
    }

    public String getName() {
        return name;
    }


    public static String getDetail(String name){
        if(StringUtils.isEmpty(name)) {
            return null;
        }
        for(WeekEnum p: WeekEnum.values()){
            if(p.getName().equals(name)) {
                return p.detail;
            }
        }
        return null;
    }

    public WeekEnum getEnum(String name){
        if(StringUtils.isEmpty(name)) {
            return null;
        }
        for(WeekEnum p: WeekEnum.values()){
            if(p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }


}
