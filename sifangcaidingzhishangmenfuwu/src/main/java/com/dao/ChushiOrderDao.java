package com.dao;

import com.entity.ChushiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChushiOrderView;

/**
 * 厨师预约 Dao 接口
 *
 * @author 
 */
public interface ChushiOrderDao extends BaseMapper<ChushiOrderEntity> {

   List<ChushiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
