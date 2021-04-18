package com.wumj.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wumj
 * @date 2021-04-07 10:16
 * @description
 */
@Data
//@ApiModel(value = "管理后台-病历邮寄-复印用途Vo")
public class MedicalRecordMailPurposeInfoListVo implements Serializable {
    private static final long serialVersionUID = -5252355281795994014L;

//    @ApiModelProperty(value = "数量")
    private Integer count;

//    @ApiModelProperty(value = "项目")
    private String projectName;

//    @ApiModelProperty(value = "详情")
    private String detail;

}
