package com.wumj.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fuxin
 * @since 2021-03-26
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class TbMedicalRecordMailReceiveInfo{
    private static final long serialVersionUID = 1L;
    private Long id;

    private Integer pickUpType;

    private Integer deliveryType;

    private String recipientName;

}