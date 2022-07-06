package com.easygo.sample.datasource.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
 *
 * @author wenbo
 * @date 2022-07-06
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value ="jsh_sys_dict",description="")
public class SysDict implements Serializable {
    @ApiModelProperty("数据字典主键")
    private Long id;

    @ApiModelProperty("字典名称(中文)")
    private String dictName;

    @ApiModelProperty("字典编码(英文)")
    private String dictCode;

    @ApiModelProperty("字典项名称(中文)")
    private String itemName;

    @ApiModelProperty("字典项编码")
    private String itemCode;

    @ApiModelProperty("条目描述(中文页面展示)")
    private String itemDesc;

    @ApiModelProperty("条目顺序")
    private Long itemOrder;

    @ApiModelProperty("条目级别")
    private Integer itemLevel;

    @ApiModelProperty("条目状态")
    private String itemState;

    @ApiModelProperty("父类条目编码")
    private String parentItemCode;

    @ApiModelProperty("创建人")
    private Long creater;

    @ApiModelProperty("创建时间")
    private Date createtime;

    private static final long serialVersionUID = 1L;
}