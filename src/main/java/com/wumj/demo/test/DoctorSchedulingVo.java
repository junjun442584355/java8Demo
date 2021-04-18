package com.wumj.demo.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wumj
 * @date 2021-04-12 0:06
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSchedulingVo {

    private String outpDate;

    private String timeInterval;

    private String preCount;
}
