
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 厨师预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chushiOrder")
public class ChushiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ChushiOrderController.class);

    private static final String TABLE_NAME = "chushiOrder";

    @Autowired
    private ChushiOrderService chushiOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private ChushiCommentbackService chushiCommentbackService;
    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ChushiService chushiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("厨师".equals(role))
            params.put("chushiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = chushiOrderService.queryPage(params);

        //字典表数据转换
        List<ChushiOrderView> list =(List<ChushiOrderView>)page.getList();
        for(ChushiOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChushiOrderEntity chushiOrder = chushiOrderService.selectById(id);
        if(chushiOrder !=null){
            //entity转view
            ChushiOrderView view = new ChushiOrderView();
            BeanUtils.copyProperties( chushiOrder , view );//把实体数据重构到view中
            //级联表 厨师
            //级联表
            ChushiEntity chushi = chushiService.selectById(chushiOrder.getChushiId());
            if(chushi != null){
            BeanUtils.copyProperties( chushi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "chushiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChushiId(chushi.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(chushiOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "chushiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChushiOrderEntity chushiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chushiOrder:{}",this.getClass().getName(),chushiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("厨师".equals(role))
            chushiOrder.setChushiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("用户".equals(role))
            chushiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        chushiOrder.setCreateTime(new Date());
        chushiOrder.setInsertTime(new Date());
        chushiOrderService.insert(chushiOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChushiOrderEntity chushiOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chushiOrder:{}",this.getClass().getName(),chushiOrder.toString());
        ChushiOrderEntity oldChushiOrderEntity = chushiOrderService.selectById(chushiOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("厨师".equals(role))
//            chushiOrder.setChushiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("用户".equals(role))
//            chushiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            chushiOrderService.updateById(chushiOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChushiOrderEntity> oldChushiOrderList =chushiOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chushiOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ChushiOrderEntity> chushiOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChushiOrderEntity chushiOrderEntity = new ChushiOrderEntity();
//                            chushiOrderEntity.setChushiOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            chushiOrderEntity.setYuyeuTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            chushiOrderEntity.setChushiId(Integer.valueOf(data.get(0)));   //厨师信息 要改的
//                            chushiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chushiOrderEntity.setChushiOrderTypes(Integer.valueOf(data.get(0)));   //预约类型 要改的
//                            chushiOrderEntity.setInsertTime(date);//时间
//                            chushiOrderEntity.setCreateTime(date);//时间
                            chushiOrderList.add(chushiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("chushiOrderUuidNumber")){
                                    List<String> chushiOrderUuidNumber = seachFields.get("chushiOrderUuidNumber");
                                    chushiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chushiOrderUuidNumber = new ArrayList<>();
                                    chushiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chushiOrderUuidNumber",chushiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<ChushiOrderEntity> chushiOrderEntities_chushiOrderUuidNumber = chushiOrderService.selectList(new EntityWrapper<ChushiOrderEntity>().in("chushi_order_uuid_number", seachFields.get("chushiOrderUuidNumber")));
                        if(chushiOrderEntities_chushiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChushiOrderEntity s:chushiOrderEntities_chushiOrderUuidNumber){
                                repeatFields.add(s.getChushiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chushiOrderService.insertBatch(chushiOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = chushiOrderService.queryPage(params);

        //字典表数据转换
        List<ChushiOrderView> list =(List<ChushiOrderView>)page.getList();
        for(ChushiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChushiOrderEntity chushiOrder = chushiOrderService.selectById(id);
            if(chushiOrder !=null){


                //entity转view
                ChushiOrderView view = new ChushiOrderView();
                BeanUtils.copyProperties( chushiOrder , view );//把实体数据重构到view中

                //级联表
                    ChushiEntity chushi = chushiService.selectById(chushiOrder.getChushiId());
                if(chushi != null){
                    BeanUtils.copyProperties( chushi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChushiId(chushi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chushiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChushiOrderEntity chushiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chushiOrder:{}",this.getClass().getName(),chushiOrder.toString());
            ChushiEntity chushiEntity = chushiService.selectById(chushiOrder.getChushiId());
            if(chushiEntity == null){
                return R.error(511,"查不到该厨师");
            }
            // Double chushiNewMoney = chushiEntity.getChushiNewMoney();

            if(false){
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");

            chushiOrder.setChushiOrderTypes(101); //设置订单状态为已预约
            chushiOrder.setYonghuId(userId); //设置订单支付人id
            chushiOrder.setChushiOrderUuidNumber(String.valueOf(new Date().getTime()));
            chushiOrder.setInsertTime(new Date());
            chushiOrder.setCreateTime(new Date());
                chushiOrderService.insert(chushiOrder);//新增订单


            return R.ok();
    }


    /**
    * 取消预约
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            ChushiOrderEntity chushiOrder = chushiOrderService.selectById(id);
            Integer chushiId = chushiOrder.getChushiId();
            if(chushiId == null)
                return R.error(511,"查不到该厨师");
            ChushiEntity chushiEntity = chushiService.selectById(chushiId);

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            Double zhekou = 1.0;






            chushiOrder.setChushiOrderTypes(102);//设置订单状态为已取消预约
            chushiOrderService.updateById(chushiOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            chushiService.updateById(chushiEntity);//更新订单中厨师的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer chushiCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            ChushiOrderEntity chushiOrder = chushiOrderService.selectById(id);
        if(chushiOrder == null)
            return R.error(511,"查不到该订单");
        Integer chushiId = chushiOrder.getChushiId();
        if(chushiId == null)
            return R.error(511,"查不到该厨师");

        ChushiCommentbackEntity chushiCommentbackEntity = new ChushiCommentbackEntity();
            chushiCommentbackEntity.setId(id);
            chushiCommentbackEntity.setChushiId(chushiId);
            chushiCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            chushiCommentbackEntity.setChushiCommentbackText(commentbackText);
            chushiCommentbackEntity.setInsertTime(new Date());
            chushiCommentbackEntity.setReplyText(null);
            chushiCommentbackEntity.setUpdateTime(null);
            chushiCommentbackEntity.setCreateTime(new Date());
            chushiCommentbackService.insert(chushiCommentbackEntity);

            chushiOrder.setChushiOrderTypes(105);//设置订单状态为已评价
            chushiOrderService.updateById(chushiOrder);//根据id更新
            return R.ok();
    }

    /**
     * 同意预约
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ChushiOrderEntity  chushiOrderEntity = chushiOrderService.selectById(id);
        chushiOrderEntity.setChushiOrderTypes(103);//设置订单状态为已同意预约
        chushiOrderService.updateById( chushiOrderEntity);

        return R.ok();
    }


    /**
     * 预约完成
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ChushiOrderEntity  chushiOrderEntity = chushiOrderService.selectById(id);
        chushiOrderEntity.setChushiOrderTypes(104);//设置订单状态为预约完成
        chushiOrderService.updateById( chushiOrderEntity);
        return R.ok();
    }

}
