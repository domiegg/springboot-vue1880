package com.entity.vo;

import com.entity.ChushiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 厨师
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chushi")
public class ChushiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 厨师信息编号
     */

    @TableField(value = "chushi_uuid_number")
    private String chushiUuidNumber;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 厨师姓名
     */

    @TableField(value = "chushi_name")
    private String chushiName;


    /**
     * 厨师手机号
     */

    @TableField(value = "chushi_phone")
    private String chushiPhone;


    /**
     * 厨师身份证号
     */

    @TableField(value = "chushi_id_number")
    private String chushiIdNumber;


    /**
     * 厨师头像
     */

    @TableField(value = "chushi_photo")
    private String chushiPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "chushi_email")
    private String chushiEmail;


    /**
     * 健康认证
     */

    @TableField(value = "chushi_file")
    private String chushiFile;


    /**
     * 厨艺视频
     */

    @TableField(value = "chushi_video")
    private String chushiVideo;


    /**
     * 厨师信息介绍
     */

    @TableField(value = "chushi_content")
    private String chushiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "chushi_delete")
    private Integer chushiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：厨师信息编号
	 */
    public String getChushiUuidNumber() {
        return chushiUuidNumber;
    }


    /**
	 * 获取：厨师信息编号
	 */

    public void setChushiUuidNumber(String chushiUuidNumber) {
        this.chushiUuidNumber = chushiUuidNumber;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：厨师姓名
	 */
    public String getChushiName() {
        return chushiName;
    }


    /**
	 * 获取：厨师姓名
	 */

    public void setChushiName(String chushiName) {
        this.chushiName = chushiName;
    }
    /**
	 * 设置：厨师手机号
	 */
    public String getChushiPhone() {
        return chushiPhone;
    }


    /**
	 * 获取：厨师手机号
	 */

    public void setChushiPhone(String chushiPhone) {
        this.chushiPhone = chushiPhone;
    }
    /**
	 * 设置：厨师身份证号
	 */
    public String getChushiIdNumber() {
        return chushiIdNumber;
    }


    /**
	 * 获取：厨师身份证号
	 */

    public void setChushiIdNumber(String chushiIdNumber) {
        this.chushiIdNumber = chushiIdNumber;
    }
    /**
	 * 设置：厨师头像
	 */
    public String getChushiPhoto() {
        return chushiPhoto;
    }


    /**
	 * 获取：厨师头像
	 */

    public void setChushiPhoto(String chushiPhoto) {
        this.chushiPhoto = chushiPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getChushiEmail() {
        return chushiEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setChushiEmail(String chushiEmail) {
        this.chushiEmail = chushiEmail;
    }
    /**
	 * 设置：健康认证
	 */
    public String getChushiFile() {
        return chushiFile;
    }


    /**
	 * 获取：健康认证
	 */

    public void setChushiFile(String chushiFile) {
        this.chushiFile = chushiFile;
    }
    /**
	 * 设置：厨艺视频
	 */
    public String getChushiVideo() {
        return chushiVideo;
    }


    /**
	 * 获取：厨艺视频
	 */

    public void setChushiVideo(String chushiVideo) {
        this.chushiVideo = chushiVideo;
    }
    /**
	 * 设置：厨师信息介绍
	 */
    public String getChushiContent() {
        return chushiContent;
    }


    /**
	 * 获取：厨师信息介绍
	 */

    public void setChushiContent(String chushiContent) {
        this.chushiContent = chushiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChushiDelete() {
        return chushiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChushiDelete(Integer chushiDelete) {
        this.chushiDelete = chushiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
