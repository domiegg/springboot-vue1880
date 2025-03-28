package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.CaipinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 菜品
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("caipin")
public class CaipinView extends CaipinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 菜品类型的值
	*/
	@ColumnInfo(comment="菜品类型的字典表值",type="varchar(200)")
	private String caipinValue;
	/**
	* 菜品口味的值
	*/
	@ColumnInfo(comment="菜品口味的字典表值",type="varchar(200)")
	private String caipinKouweValue;

	//级联表 厨师
		/**
		* 厨师信息编号
		*/

		@ColumnInfo(comment="厨师信息编号",type="varchar(200)")
		private String chushiUuidNumber;
		/**
		* 厨师姓名
		*/

		@ColumnInfo(comment="厨师姓名",type="varchar(200)")
		private String chushiName;
		/**
		* 厨师手机号
		*/

		@ColumnInfo(comment="厨师手机号",type="varchar(200)")
		private String chushiPhone;
		/**
		* 厨师身份证号
		*/

		@ColumnInfo(comment="厨师身份证号",type="varchar(200)")
		private String chushiIdNumber;
		/**
		* 厨师头像
		*/

		@ColumnInfo(comment="厨师头像",type="varchar(200)")
		private String chushiPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String chushiEmail;
		/**
		* 健康认证
		*/

		@ColumnInfo(comment="健康认证",type="varchar(200)")
		private String chushiFile;
		/**
		* 厨艺视频
		*/

		@ColumnInfo(comment="厨艺视频",type="varchar(200)")
		private String chushiVideo;
		/**
		* 厨师信息介绍
		*/

		@ColumnInfo(comment="厨师信息介绍",type="text")
		private String chushiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer chushiDelete;



	public CaipinView() {

	}

	public CaipinView(CaipinEntity caipinEntity) {
		try {
			BeanUtils.copyProperties(this, caipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 菜品类型的值
	*/
	public String getCaipinValue() {
		return caipinValue;
	}
	/**
	* 设置： 菜品类型的值
	*/
	public void setCaipinValue(String caipinValue) {
		this.caipinValue = caipinValue;
	}
	//当前表的
	/**
	* 获取： 菜品口味的值
	*/
	public String getCaipinKouweValue() {
		return caipinKouweValue;
	}
	/**
	* 设置： 菜品口味的值
	*/
	public void setCaipinKouweValue(String caipinKouweValue) {
		this.caipinKouweValue = caipinKouweValue;
	}


	//级联表的get和set 厨师

		/**
		* 获取： 厨师信息编号
		*/
		public String getChushiUuidNumber() {
			return chushiUuidNumber;
		}
		/**
		* 设置： 厨师信息编号
		*/
		public void setChushiUuidNumber(String chushiUuidNumber) {
			this.chushiUuidNumber = chushiUuidNumber;
		}

		/**
		* 获取： 厨师姓名
		*/
		public String getChushiName() {
			return chushiName;
		}
		/**
		* 设置： 厨师姓名
		*/
		public void setChushiName(String chushiName) {
			this.chushiName = chushiName;
		}

		/**
		* 获取： 厨师手机号
		*/
		public String getChushiPhone() {
			return chushiPhone;
		}
		/**
		* 设置： 厨师手机号
		*/
		public void setChushiPhone(String chushiPhone) {
			this.chushiPhone = chushiPhone;
		}

		/**
		* 获取： 厨师身份证号
		*/
		public String getChushiIdNumber() {
			return chushiIdNumber;
		}
		/**
		* 设置： 厨师身份证号
		*/
		public void setChushiIdNumber(String chushiIdNumber) {
			this.chushiIdNumber = chushiIdNumber;
		}

		/**
		* 获取： 厨师头像
		*/
		public String getChushiPhoto() {
			return chushiPhoto;
		}
		/**
		* 设置： 厨师头像
		*/
		public void setChushiPhoto(String chushiPhoto) {
			this.chushiPhoto = chushiPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getChushiEmail() {
			return chushiEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setChushiEmail(String chushiEmail) {
			this.chushiEmail = chushiEmail;
		}

		/**
		* 获取： 健康认证
		*/
		public String getChushiFile() {
			return chushiFile;
		}
		/**
		* 设置： 健康认证
		*/
		public void setChushiFile(String chushiFile) {
			this.chushiFile = chushiFile;
		}

		/**
		* 获取： 厨艺视频
		*/
		public String getChushiVideo() {
			return chushiVideo;
		}
		/**
		* 设置： 厨艺视频
		*/
		public void setChushiVideo(String chushiVideo) {
			this.chushiVideo = chushiVideo;
		}

		/**
		* 获取： 厨师信息介绍
		*/
		public String getChushiContent() {
			return chushiContent;
		}
		/**
		* 设置： 厨师信息介绍
		*/
		public void setChushiContent(String chushiContent) {
			this.chushiContent = chushiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getChushiDelete() {
			return chushiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setChushiDelete(Integer chushiDelete) {
			this.chushiDelete = chushiDelete;
		}


	@Override
	public String toString() {
		return "CaipinView{" +
			", caipinValue=" + caipinValue +
			", caipinKouweValue=" + caipinKouweValue +
			", chushiUuidNumber=" + chushiUuidNumber +
			", chushiName=" + chushiName +
			", chushiPhone=" + chushiPhone +
			", chushiIdNumber=" + chushiIdNumber +
			", chushiPhoto=" + chushiPhoto +
			", chushiEmail=" + chushiEmail +
			", chushiFile=" + chushiFile +
			", chushiVideo=" + chushiVideo +
			", chushiContent=" + chushiContent +
			", chushiDelete=" + chushiDelete +
			"} " + super.toString();
	}
}
