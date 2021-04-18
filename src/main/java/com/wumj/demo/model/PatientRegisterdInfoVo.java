package com.wumj.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author wumj
 * @date 2021-04-13
 * @description
 */

@Data
public class PatientRegisterdInfoVo implements Serializable {
    private static final long serialVersionUID = -621606137732210553L;

    private Long hospitalId;

    private String hisOrderNo;

    private String patientName;

    private String deptName;

    private String doctorName;

    private String clinicType;

    private String appointmentTime;

    private String phone;

    private String registeredSourceType;

    private BigDecimal medicalExpenses;

    //调用退号接口需要的数据
    private String clincNo;

    private String tiketNo;

    //调用退号接口需要的数据
    private String cardNo;


}
