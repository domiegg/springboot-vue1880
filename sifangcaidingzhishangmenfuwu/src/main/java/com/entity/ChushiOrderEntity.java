package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 厨师预约
 *
 * @author 
 * @email
 */
@TableName("chushi_order")
public class ChushiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChushiOrderEntity() {

	}

	public ChushiOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @ColumnInfo(comment="订单号",type="varchar(200)")
    @TableField(value = "chushi_order_uuid_number")

    private String chushiOrderUuidNumber;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="date")
    @TableField(value = "yuyeu_time")

    private Date yuyeuTime;


    /**
     * 厨师信息
     */
    @ColumnInfo(comment="厨师信息",type="int(11)")
    @TableField(value = "chushi_id")

    private Integer chushiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约类型
     */
    @ColumnInfo(comment="预约类型",type="int(11)")
    @TableField(value = "chushi_order_types")

    private Integer chushiOrderTypes;


    /**
     * 预约创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getChushiOrderUuidNumber() {
        return chushiOrderUuidNumber;
    }
    /**
	 * 设置：订单号
	 */

    public void setChushiOrderUuidNumber(String chushiOrderUuidNumber) {
        this.chushiOrderUuidNumber = chushiOrderUuidNumber;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getYuyeuTime() {
        return yuyeuTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setYuyeuTime(Date yuyeuTime) {
        this.yuyeuTime = yuyeuTime;
    }
    /**
	 * 获取：厨师信息
	 */
    public Integer getChushiId() {
        return chushiId;
    }
    /**
	 * 设置：厨师信息
	 */

    public void setChushiId(Integer chushiId) {
        this.chushiId = chushiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约类型
	 */
    public Integer getChushiOrderTypes() {
        return chushiOrderTypes;
    }
    /**
	 * 设置：预约类型
	 */

    public void setChushiOrderTypes(Integer chushiOrderTypes) {
        this.chushiOrderTypes = chushiOrderTypes;
    }
    /**
	 * 获取：预约创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：预约创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ChushiOrder{" +
            ", id=" + id +
            ", chushiOrderUuidNumber=" + chushiOrderUuidNumber +
            ", yuyeuTime=" + DateUtil.convertString(yuyeuTime,"yyyy-MM-dd") +
            ", chushiId=" + chushiId +
            ", yonghuId=" + yonghuId +
            ", chushiOrderTypes=" + chushiOrderTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
