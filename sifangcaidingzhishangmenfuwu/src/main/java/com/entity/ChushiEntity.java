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
 * 厨师
 *
 * @author 
 * @email
 */
@TableName("chushi")
public class ChushiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChushiEntity() {

	}

	public ChushiEntity(T t) {
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
     * 厨师信息编号
     */
    @ColumnInfo(comment="厨师信息编号",type="varchar(200)")
    @TableField(value = "chushi_uuid_number")

    private String chushiUuidNumber;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 厨师姓名
     */
    @ColumnInfo(comment="厨师姓名",type="varchar(200)")
    @TableField(value = "chushi_name")

    private String chushiName;


    /**
     * 厨师手机号
     */
    @ColumnInfo(comment="厨师手机号",type="varchar(200)")
    @TableField(value = "chushi_phone")

    private String chushiPhone;


    /**
     * 厨师身份证号
     */
    @ColumnInfo(comment="厨师身份证号",type="varchar(200)")
    @TableField(value = "chushi_id_number")

    private String chushiIdNumber;


    /**
     * 厨师头像
     */
    @ColumnInfo(comment="厨师头像",type="varchar(200)")
    @TableField(value = "chushi_photo")

    private String chushiPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    @ColumnInfo(comment="电子邮箱",type="varchar(200)")
    @TableField(value = "chushi_email")

    private String chushiEmail;


    /**
     * 健康认证
     */
    @ColumnInfo(comment="健康认证",type="varchar(200)")
    @TableField(value = "chushi_file")

    private String chushiFile;


    /**
     * 厨艺视频
     */
    @ColumnInfo(comment="厨艺视频",type="varchar(200)")
    @TableField(value = "chushi_video")

    private String chushiVideo;


    /**
     * 厨师信息介绍
     */
    @ColumnInfo(comment="厨师信息介绍",type="text")
    @TableField(value = "chushi_content")

    private String chushiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "chushi_delete")

    private Integer chushiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：厨师信息编号
	 */
    public String getChushiUuidNumber() {
        return chushiUuidNumber;
    }
    /**
	 * 设置：厨师信息编号
	 */

    public void setChushiUuidNumber(String chushiUuidNumber) {
        this.chushiUuidNumber = chushiUuidNumber;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：厨师姓名
	 */
    public String getChushiName() {
        return chushiName;
    }
    /**
	 * 设置：厨师姓名
	 */

    public void setChushiName(String chushiName) {
        this.chushiName = chushiName;
    }
    /**
	 * 获取：厨师手机号
	 */
    public String getChushiPhone() {
        return chushiPhone;
    }
    /**
	 * 设置：厨师手机号
	 */

    public void setChushiPhone(String chushiPhone) {
        this.chushiPhone = chushiPhone;
    }
    /**
	 * 获取：厨师身份证号
	 */
    public String getChushiIdNumber() {
        return chushiIdNumber;
    }
    /**
	 * 设置：厨师身份证号
	 */

    public void setChushiIdNumber(String chushiIdNumber) {
        this.chushiIdNumber = chushiIdNumber;
    }
    /**
	 * 获取：厨师头像
	 */
    public String getChushiPhoto() {
        return chushiPhoto;
    }
    /**
	 * 设置：厨师头像
	 */

    public void setChushiPhoto(String chushiPhoto) {
        this.chushiPhoto = chushiPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getChushiEmail() {
        return chushiEmail;
    }
    /**
	 * 设置：电子邮箱
	 */

    public void setChushiEmail(String chushiEmail) {
        this.chushiEmail = chushiEmail;
    }
    /**
	 * 获取：健康认证
	 */
    public String getChushiFile() {
        return chushiFile;
    }
    /**
	 * 设置：健康认证
	 */

    public void setChushiFile(String chushiFile) {
        this.chushiFile = chushiFile;
    }
    /**
	 * 获取：厨艺视频
	 */
    public String getChushiVideo() {
        return chushiVideo;
    }
    /**
	 * 设置：厨艺视频
	 */

    public void setChushiVideo(String chushiVideo) {
        this.chushiVideo = chushiVideo;
    }
    /**
	 * 获取：厨师信息介绍
	 */
    public String getChushiContent() {
        return chushiContent;
    }
    /**
	 * 设置：厨师信息介绍
	 */

    public void setChushiContent(String chushiContent) {
        this.chushiContent = chushiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChushiDelete() {
        return chushiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setChushiDelete(Integer chushiDelete) {
        this.chushiDelete = chushiDelete;
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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Chushi{" +
            ", id=" + id +
            ", chushiUuidNumber=" + chushiUuidNumber +
            ", username=" + username +
            ", password=" + password +
            ", chushiName=" + chushiName +
            ", chushiPhone=" + chushiPhone +
            ", chushiIdNumber=" + chushiIdNumber +
            ", chushiPhoto=" + chushiPhoto +
            ", sexTypes=" + sexTypes +
            ", chushiEmail=" + chushiEmail +
            ", chushiFile=" + chushiFile +
            ", chushiVideo=" + chushiVideo +
            ", chushiContent=" + chushiContent +
            ", chushiDelete=" + chushiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
