package com.dao;

import com.entity.ChushiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChushiView;

/**
 * 厨师 Dao 接口
 *
 * @author 
 */
public interface ChushiDao extends BaseMapper<ChushiEntity> {

   List<ChushiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
