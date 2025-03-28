package com.entity.model;

import com.entity.ChushiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 厨师预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChushiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String chushiOrderUuidNumber;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuyeuTime;


    /**
     * 厨师信息
     */
    private Integer chushiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约类型
     */
    private Integer chushiOrderTypes;


    /**
     * 预约创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
