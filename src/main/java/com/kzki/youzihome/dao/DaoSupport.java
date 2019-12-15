package com.kzki.youzihome.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("daoSupport")
public class DaoSupport implements Dao{

    @Autowired(required=false)
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 保存数据
     * @param str
     * @param obj
     * @return
     */
    @Override
    public Object save(String str,Object obj){
        return sqlSessionTemplate.insert(str,obj);
    }

    /**
     * 更新数据
     * @param str
     * @param obj
     * @return
     */
    @Override
    public Object update(String str,Object obj){
        return sqlSessionTemplate.update(str,obj);
    }

    /**
     * 删除数据
     * @param str
     * @param obj
     * @return
     */
    @Override
    public Object delete(String str,Object obj){
        return sqlSessionTemplate.delete(str,obj);
    }

    /**
     * 查询数据
     * @param str
     * @param obj
     * @return
     */
    @Override
    public Object selectOne(String str,Object obj){
        return sqlSessionTemplate.selectOne(str,obj);
    }

    /**
     * 查询数据集合
     * @param str
     * @param obj
     * @return
     */
    @Override
    public Object selectList(String str,Object obj) {
        return sqlSessionTemplate.selectList(str,obj);
    }


}
