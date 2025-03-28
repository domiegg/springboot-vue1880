package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChushiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 厨师预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chushi_order")
public class ChushiOrderView extends ChushiOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 预约类型的值
	*/
	@ColumnInfo(comment="预约类型的字典表值",type="varchar(200)")
	private String chushiOrderValue;

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
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public ChushiOrderView() {

	}

	public ChushiOrderView(ChushiOrderEntity chushiOrderEntity) {
		try {
			BeanUtils.copyProperties(this, chushiOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 预约类型的值
	*/
	public String getChushiOrderValue() {
		return chushiOrderValue;
	}
	/**
	* 设置： 预约类型的值
	*/
	public void setChushiOrderValue(String chushiOrderValue) {
		this.chushiOrderValue = chushiOrderValue;
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
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "ChushiOrderView{" +
			", chushiOrderValue=" + chushiOrderValue +
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
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
