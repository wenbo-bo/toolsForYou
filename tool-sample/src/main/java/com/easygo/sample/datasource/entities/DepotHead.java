package com.easygo.sample.datasource.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.easygo.core.annotation.DictEntity;
import com.easygo.core.annotation.DictField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 单据主表
 *
 * @author wenbo
 * @date 2022-07-06
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value ="jsh_depot_head",description="单据主表")
@DictEntity({
        @DictField(dictCode = "outDepotStatus",from = "outDepotStatus",to = "outDepotStatusName")
})
public class DepotHead implements Serializable {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("类型(出库/入库)")
    private String type;

    @ApiModelProperty("出入库分类")
    private String subType;

    @ApiModelProperty("初始票据号")
    private String defaultNumber;

    @ApiModelProperty("票据号")
    private String number;

    @ApiModelProperty("供应商id")
    private Long organId;

    @ApiModelProperty("出入库时间")
    private Date operTime;

    @ApiModelProperty("账户id")
    private Long accountId;

    @ApiModelProperty("变动金额(收款/付款)")
    private BigDecimal changeAmount;

    @ApiModelProperty("合计金额")
    private BigDecimal totalPrice;

    @ApiModelProperty("付款类型(现金、记账等)")
    private String payType;

    @ApiModelProperty("单据类型")
    private String billType;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("附件名称")
    private String fileName;

    @ApiModelProperty("业务员（可以多个）")
    private String salesMan;

    @ApiModelProperty("多账户ID列表")
    private String accountIdList;

    @ApiModelProperty("多账户金额列表")
    private String accountMoneyList;

    @ApiModelProperty("优惠率")
    private BigDecimal discount;

    @ApiModelProperty("优惠金额")
    private BigDecimal discountMoney;

    @ApiModelProperty("优惠后金额")
    private BigDecimal discountLastMoney;

    @ApiModelProperty("销售或采购费用合计")
    private BigDecimal otherMoney;

    @ApiModelProperty("状态，0未审核、1已审核、2完成采购|销售、3部分采购|销售")
    private String status;

    @ApiModelProperty("关联订单号")
    private String linkNumber;

    @ApiModelProperty("出库状态 0待采购 1待出库 2待复核  3已出库 4部分出库")
    private String outDepotStatus;

    @ApiModelProperty("配送费")
    private BigDecimal logisticsFee;

    @ApiModelProperty("配送方式 1自提 2配送")
    private String logisticsWay;

    @ApiModelProperty("配送时间 1当日发货 2正常发货")
    private String deliveryTime;

    @ApiModelProperty("物流公司")
    private String logisticsCompany;

    @ApiModelProperty("快递单号")
    private String logisticsNumber;

    @ApiModelProperty("地址id")
    private Long custAddressId;

    @ApiModelProperty("技术员")
    private String technician;

    @ApiModelProperty("仓库id")
    private Long depotId;

    @ApiModelProperty("调拨时对方仓库")
    private Long anotherDepotId;

    @ApiModelProperty("支付状态 1 待支付 2已支付 3部分支付")
    private String payStatus;

    @ApiModelProperty("审核人")
    private Long auditor;

    @ApiModelProperty("审核时间")
    private Date auditTime;

    @ApiModelProperty("租户id")
    private Long tenantId;

    @ApiModelProperty("删除标记，0未删除，1删除")
    private String deleteFlag;

    @ApiModelProperty("操作员")
    private Long creator;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改人")
    private Long modifier;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @TableField(exist = false)
    private String outDepotStatusName;

    private static final long serialVersionUID = 1L;
}