package com.entity.model;

import com.entity.ChushiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 厨师
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChushiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 厨师信息编号
     */
    private String chushiUuidNumber;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 厨师姓名
     */
    private String chushiName;


    /**
     * 厨师手机号
     */
    private String chushiPhone;


    /**
     * 厨师身份证号
     */
    private String chushiIdNumber;


    /**
     * 厨师头像
     */
    private String chushiPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String chushiEmail;


    /**
     * 健康认证
     */
    private String chushiFile;


    /**
     * 厨艺视频
     */
    private String chushiVideo;


    /**
     * 厨师信息介绍
     */
    private String chushiContent;


    /**
     * 逻辑删除
     */
    private Integer chushiDelete;


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
