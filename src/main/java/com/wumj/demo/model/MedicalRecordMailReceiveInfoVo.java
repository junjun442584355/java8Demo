package com.wumj.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fuxin
 * @since 2021-03-26
 */

@Data
public class MedicalRecordMailReceiveInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String pickUpType;

    private String deliveryType;

    private String recipientName;


}