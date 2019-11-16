package com.xshop.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xshop.dao.PrefMapper;
import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Pref;
import com.xshop.service.goods.PrefService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class PrefServiceImpl implements PrefService {

    @Autowired
    private PrefMapper prefMapper;

    @Override
    public List<Pref> findAll() {
        return prefMapper.selectAll();
    }

    @Override
    public PageResult<Pref> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Pref> prefs = (Page<Pref>) prefMapper.selectAll();
        return new PageResult<Pref>(prefs.getTotal(),prefs.getResult());
    }

    @Override
    public List<Pref> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return prefMapper.selectByExample(example);
    }

    @Override
    public PageResult<Pref> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Pref> prefs = (Page<Pref>) prefMapper.selectByExample(example);
        return new PageResult<Pref>(prefs.getTotal(),prefs.getResult());
    }

    @Override
    public Pref findById(Integer id) {
        return prefMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Pref pref) {
        prefMapper.insert(pref);
    }

    @Override
    public void update(Pref pref) {
        prefMapper.updateByPrimaryKeySelective(pref);
    }

    @Override
    public void delete(Integer id) {
        prefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Pref.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 类型
            if(searchMap.get("type")!=null && !"".equals(searchMap.get("type"))){
                criteria.andLike("type","%"+searchMap.get("type")+"%");
            }
            // 状态
            if(searchMap.get("state")!=null && !"".equals(searchMap.get("state"))){
                criteria.andLike("state","%"+searchMap.get("state")+"%");
            }

            // ID
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 分类ID
            if(searchMap.get("cateId")!=null ){
                criteria.andEqualTo("cateId",searchMap.get("cateId"));
            }
            // 消费金额
            if(searchMap.get("buyMoney")!=null ){
                criteria.andEqualTo("buyMoney",searchMap.get("buyMoney"));
            }
            // 优惠金额
            if(searchMap.get("preMoney")!=null ){
                criteria.andEqualTo("preMoney",searchMap.get("preMoney"));
            }

        }
        return example;
    }

}
