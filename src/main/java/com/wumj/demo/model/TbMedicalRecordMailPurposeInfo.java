package com.wumj.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * @author fuxin
 * @since 2021-04-06
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TbMedicalRecordMailPurposeInfo {
    private static final long serialVersionUID = 1L;


   // @ApiModelProperty(value = "全套住院病案item对应id")
    private Long allMedicalRecordItemId;

   // @ApiModelProperty(value = "全套住院病案")
    private Integer allMedicalRecord;

    //@ApiModelProperty(value = "新农合报销item对应id")
    private Long ncmsItemId;

    //@ApiModelProperty(value = "新农合报销")
    private Integer ncms;


}