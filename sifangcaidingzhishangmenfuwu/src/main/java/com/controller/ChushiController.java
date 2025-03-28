
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
 * 厨师
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chushi")
public class ChushiController {
    private static final Logger logger = LoggerFactory.getLogger(ChushiController.class);

    private static final String TABLE_NAME = "chushi";

    @Autowired
    private ChushiService chushiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private ChushiOrderService chushiOrderService;
    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;


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
            params.put("id",request.getSession().getAttribute("userId"));
        params.put("chushiDeleteStart",1);params.put("chushiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = chushiService.queryPage(params);

        //字典表数据转换
        List<ChushiView> list =(List<ChushiView>)page.getList();
        for(ChushiView c:list){
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
        ChushiEntity chushi = chushiService.selectById(id);
        if(chushi !=null){
            //entity转view
            ChushiView view = new ChushiView();
            BeanUtils.copyProperties( chushi , view );//把实体数据重构到view中
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
    public R save(@RequestBody ChushiEntity chushi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chushi:{}",this.getClass().getName(),chushi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChushiEntity> queryWrapper = new EntityWrapper<ChushiEntity>()
            .eq("username", chushi.getUsername())
            .or()
            .eq("chushi_phone", chushi.getChushiPhone())
            .or()
            .eq("chushi_id_number", chushi.getChushiIdNumber())
            .andNew()
            .eq("chushi_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChushiEntity chushiEntity = chushiService.selectOne(queryWrapper);
        if(chushiEntity==null){
            chushi.setChushiDelete(1);
            chushi.setInsertTime(new Date());
            chushi.setCreateTime(new Date());
            chushi.setPassword("123456");
            chushiService.insert(chushi);
            return R.ok();
        }else {
            return R.error(511,"账户或者厨师手机号或者厨师身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChushiEntity chushi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chushi:{}",this.getClass().getName(),chushi.toString());
        ChushiEntity oldChushiEntity = chushiService.selectById(chushi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(chushi.getChushiPhoto()) || "null".equals(chushi.getChushiPhoto())){
                chushi.setChushiPhoto(null);
        }
        if("".equals(chushi.getChushiFile()) || "null".equals(chushi.getChushiFile())){
                chushi.setChushiFile(null);
        }
        if("".equals(chushi.getChushiVideo()) || "null".equals(chushi.getChushiVideo())){
                chushi.setChushiVideo(null);
        }

            chushiService.updateById(chushi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChushiEntity> oldChushiList =chushiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ChushiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChushiEntity chushiEntity = new ChushiEntity();
            chushiEntity.setId(id);
            chushiEntity.setChushiDelete(2);
            list.add(chushiEntity);
        }
        if(list != null && list.size() >0){
            chushiService.updateBatchById(list);
        }

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
            List<ChushiEntity> chushiList = new ArrayList<>();//上传的东西
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
                            ChushiEntity chushiEntity = new ChushiEntity();
//                            chushiEntity.setChushiUuidNumber(data.get(0));                    //厨师信息编号 要改的
//                            chushiEntity.setUsername(data.get(0));                    //账户 要改的
//                            //chushiEntity.setPassword("123456");//密码
//                            chushiEntity.setChushiName(data.get(0));                    //厨师姓名 要改的
//                            chushiEntity.setChushiPhone(data.get(0));                    //厨师手机号 要改的
//                            chushiEntity.setChushiIdNumber(data.get(0));                    //厨师身份证号 要改的
//                            chushiEntity.setChushiPhoto("");//详情和图片
//                            chushiEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            chushiEntity.setChushiEmail(data.get(0));                    //电子邮箱 要改的
//                            chushiEntity.setChushiFile(data.get(0));                    //健康认证 要改的
//                            chushiEntity.setChushiVideo(data.get(0));                    //厨艺视频 要改的
//                            chushiEntity.setChushiContent("");//详情和图片
//                            chushiEntity.setChushiDelete(1);//逻辑删除字段
//                            chushiEntity.setInsertTime(date);//时间
//                            chushiEntity.setCreateTime(date);//时间
                            chushiList.add(chushiEntity);


                            //把要查询是否重复的字段放入map中
                                //厨师信息编号
                                if(seachFields.containsKey("chushiUuidNumber")){
                                    List<String> chushiUuidNumber = seachFields.get("chushiUuidNumber");
                                    chushiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chushiUuidNumber = new ArrayList<>();
                                    chushiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chushiUuidNumber",chushiUuidNumber);
                                }
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //厨师手机号
                                if(seachFields.containsKey("chushiPhone")){
                                    List<String> chushiPhone = seachFields.get("chushiPhone");
                                    chushiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> chushiPhone = new ArrayList<>();
                                    chushiPhone.add(data.get(0));//要改的
                                    seachFields.put("chushiPhone",chushiPhone);
                                }
                                //厨师身份证号
                                if(seachFields.containsKey("chushiIdNumber")){
                                    List<String> chushiIdNumber = seachFields.get("chushiIdNumber");
                                    chushiIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chushiIdNumber = new ArrayList<>();
                                    chushiIdNumber.add(data.get(0));//要改的
                                    seachFields.put("chushiIdNumber",chushiIdNumber);
                                }
                        }

                        //查询是否重复
                         //厨师信息编号
                        List<ChushiEntity> chushiEntities_chushiUuidNumber = chushiService.selectList(new EntityWrapper<ChushiEntity>().in("chushi_uuid_number", seachFields.get("chushiUuidNumber")).eq("chushi_delete", 1));
                        if(chushiEntities_chushiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChushiEntity s:chushiEntities_chushiUuidNumber){
                                repeatFields.add(s.getChushiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [厨师信息编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //账户
                        List<ChushiEntity> chushiEntities_username = chushiService.selectList(new EntityWrapper<ChushiEntity>().in("username", seachFields.get("username")).eq("chushi_delete", 1));
                        if(chushiEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChushiEntity s:chushiEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //厨师手机号
                        List<ChushiEntity> chushiEntities_chushiPhone = chushiService.selectList(new EntityWrapper<ChushiEntity>().in("chushi_phone", seachFields.get("chushiPhone")).eq("chushi_delete", 1));
                        if(chushiEntities_chushiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChushiEntity s:chushiEntities_chushiPhone){
                                repeatFields.add(s.getChushiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [厨师手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //厨师身份证号
                        List<ChushiEntity> chushiEntities_chushiIdNumber = chushiService.selectList(new EntityWrapper<ChushiEntity>().in("chushi_id_number", seachFields.get("chushiIdNumber")).eq("chushi_delete", 1));
                        if(chushiEntities_chushiIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChushiEntity s:chushiEntities_chushiIdNumber){
                                repeatFields.add(s.getChushiIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [厨师身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chushiService.insertBatch(chushiList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ChushiEntity chushi = chushiService.selectOne(new EntityWrapper<ChushiEntity>().eq("username", username));
        if(chushi==null || !chushi.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(chushi.getChushiDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(chushi.getId(),username, "chushi", "厨师");
        R r = R.ok();
        r.put("token", token);
        r.put("role","厨师");
        r.put("username",chushi.getChushiName());
        r.put("tableName","chushi");
        r.put("userId",chushi.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ChushiEntity chushi, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ChushiEntity> queryWrapper = new EntityWrapper<ChushiEntity>()
            .eq("username", chushi.getUsername())
            .or()
            .eq("chushi_phone", chushi.getChushiPhone())
            .or()
            .eq("chushi_id_number", chushi.getChushiIdNumber())
            .andNew()
            .eq("chushi_delete", 1)
            ;
        ChushiEntity chushiEntity = chushiService.selectOne(queryWrapper);
        if(chushiEntity != null)
            return R.error("账户或者厨师手机号或者厨师身份证号已经被使用");
        chushi.setChushiUuidNumber(String.valueOf(new Date().getTime()));
        chushi.setChushiDelete(1);
        chushi.setInsertTime(new Date());
        chushi.setCreateTime(new Date());
        chushiService.insert(chushi);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        ChushiEntity chushi = chushiService.selectById(id);
        chushi.setPassword("123456");
        chushiService.updateById(chushi);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ChushiEntity chushi = chushiService.selectOne(new EntityWrapper<ChushiEntity>().eq("username", username));
        if(chushi!=null){
            chushi.setPassword("123456");
            chushiService.updateById(chushi);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrChushi(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ChushiEntity chushi = chushiService.selectById(id);
        if(chushi !=null){
            //entity转view
            ChushiView view = new ChushiView();
            BeanUtils.copyProperties( chushi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }


    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ChushiView> returnChushiViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = chushiOrderService.queryPage(params1);
        List<ChushiOrderView> orderViewsList =(List<ChushiOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ChushiOrderView orderView:orderViewsList){

        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("chushiTypes",type);
            PageUtils pageUtils1 = chushiService.queryPage(params2);
            List<ChushiView> chushiViewList =(List<ChushiView>)pageUtils1.getList();
            returnChushiViewList.addAll(chushiViewList);
            if(returnChushiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = chushiService.queryPage(params);
        if(returnChushiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnChushiViewList.size();//要添加的数量
            List<ChushiView> chushiViewList =(List<ChushiView>)page.getList();
            for(ChushiView chushiView:chushiViewList){
                Boolean addFlag = true;
                for(ChushiView returnChushiView:returnChushiViewList){
                    if(returnChushiView.getId().intValue() ==chushiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnChushiViewList.add(chushiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnChushiViewList = returnChushiViewList.subList(0, limit);
        }

        for(ChushiView c:returnChushiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnChushiViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = chushiService.queryPage(params);

        //字典表数据转换
        List<ChushiView> list =(List<ChushiView>)page.getList();
        for(ChushiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChushiEntity chushi = chushiService.selectById(id);
            if(chushi !=null){


                //entity转view
                ChushiView view = new ChushiView();
                BeanUtils.copyProperties( chushi , view );//把实体数据重构到view中

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
    public R add(@RequestBody ChushiEntity chushi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chushi:{}",this.getClass().getName(),chushi.toString());
        Wrapper<ChushiEntity> queryWrapper = new EntityWrapper<ChushiEntity>()
            .eq("username", chushi.getUsername())
            .or()
            .eq("chushi_phone", chushi.getChushiPhone())
            .or()
            .eq("chushi_id_number", chushi.getChushiIdNumber())
            .andNew()
            .eq("chushi_delete", 1)
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChushiEntity chushiEntity = chushiService.selectOne(queryWrapper);
        if(chushiEntity==null){
            chushi.setChushiDelete(1);
            chushi.setInsertTime(new Date());
            chushi.setCreateTime(new Date());
        chushi.setPassword("123456");
        chushiService.insert(chushi);

            return R.ok();
        }else {
            return R.error(511,"账户或者厨师手机号或者厨师身份证号已经被使用");
        }
    }

}
