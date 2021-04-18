package com.wumj.demo.model;


/**
 * @author wumj
 * @date 2021-03-26 14:32
 * @description
 */
public enum RelationshipEnum {

    ONE(1,"全套住院病案"),
    TWO(2,"新农合报销");
    public Integer code;
    public String name;

    RelationshipEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(Integer code){
        if(code==null) {
            return null;
        }
        for(RelationshipEnum p: RelationshipEnum.values()){
            if(p.code.intValue()==code.intValue()) {
                return p.name;
            }
        }
        return null;
    }

    public RelationshipEnum getEnum(Integer code){
        if(code==null) {
            return null;
        }
        for(RelationshipEnum p: RelationshipEnum.values()){
            if(p.code.intValue()==code.intValue()) {
                return p;
            }
        }
        return null;
    }

}