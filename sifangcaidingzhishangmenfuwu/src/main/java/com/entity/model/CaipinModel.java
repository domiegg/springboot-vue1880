package com.entity.model;

import com.entity.CaipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 菜品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CaipinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 厨师信息
     */
    private Integer chushiId;


    /**
     * 菜品名称
     */
    private String caipinName;


    /**
     * 菜品编号
     */
    private String caipinUuidNumber;


    /**
     * 菜品照片
     */
    private String caipinPhoto;


    /**
     * 菜品类型
     */
    private Integer caipinTypes;


    /**
     * 菜品口味
     */
    private Integer caipinKouweTypes;


    /**
     * 菜品介绍
     */
    private String caipinContent;


    /**
     * 逻辑删除
     */
    private Integer caipinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：菜品名称
	 */
    public String getCaipinName() {
        return caipinName;
    }


    /**
	 * 设置：菜品名称
	 */
    public void setCaipinName(String caipinName) {
        this.caipinName = caipinName;
    }
    /**
	 * 获取：菜品编号
	 */
    public String getCaipinUuidNumber() {
        return caipinUuidNumber;
    }


    /**
	 * 设置：菜品编号
	 */
    public void setCaipinUuidNumber(String caipinUuidNumber) {
        this.caipinUuidNumber = caipinUuidNumber;
    }
    /**
	 * 获取：菜品照片
	 */
    public String getCaipinPhoto() {
        return caipinPhoto;
    }


    /**
	 * 设置：菜品照片
	 */
    public void setCaipinPhoto(String caipinPhoto) {
        this.caipinPhoto = caipinPhoto;
    }
    /**
	 * 获取：菜品类型
	 */
    public Integer getCaipinTypes() {
        return caipinTypes;
    }


    /**
	 * 设置：菜品类型
	 */
    public void setCaipinTypes(Integer caipinTypes) {
        this.caipinTypes = caipinTypes;
    }
    /**
	 * 获取：菜品口味
	 */
    public Integer getCaipinKouweTypes() {
        return caipinKouweTypes;
    }


    /**
	 * 设置：菜品口味
	 */
    public void setCaipinKouweTypes(Integer caipinKouweTypes) {
        this.caipinKouweTypes = caipinKouweTypes;
    }
    /**
	 * 获取：菜品介绍
	 */
    public String getCaipinContent() {
        return caipinContent;
    }


    /**
	 * 设置：菜品介绍
	 */
    public void setCaipinContent(String caipinContent) {
        this.caipinContent = caipinContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getCaipinDelete() {
        return caipinDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setCaipinDelete(Integer caipinDelete) {
        this.caipinDelete = caipinDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
