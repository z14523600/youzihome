package com.kzki.youzihome.service.impl;

import com.kzki.youzihome.dao.DaoSupport;
import com.kzki.youzihome.entity.MapperData;
import com.kzki.youzihome.service.BaseService;
import com.kzki.youzihome.util.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;

@Service("BaseServiceImpl")
public class BaseServiceImpl implements BaseService {

    @Autowired
    private DaoSupport daoSupport;

    //查询数据集合
    @Override
    public ArrayList<HashMap> getDataList(String mapperStr,DataMap dm){
        ArrayList<HashMap> datalist=new ArrayList<HashMap>();
        try {
            datalist = (ArrayList<HashMap>) daoSupport.selectList(mapperStr, dm);
        }catch(Exception e)
        {

        }
        return datalist;
    }


   /* public Object getDataScalar(String mapperStr,DataMap dm){
        Object object=null;
        try {
            object =  daoSupport.selectOne(mapperStr, dm);
        }catch(Exception e)
        {

        }
        return object;
    }
        */

    @Override
    public boolean executeBaseData(String mapperStr,DataMap dm,String optType) {
        try{
            switch (optType){
                case "delete":
                    daoSupport.update(mapperStr, dm);
                    break;
                case "deletetrue":
                    daoSupport.delete(mapperStr, dm);
                    break;
                case "save":
                    daoSupport.save(mapperStr, dm);
                    break;
                case "update":
                    daoSupport.update(mapperStr, dm);
                    break;
            }
            return true;
        }catch(Exception ex){
            return false;
        }
    }



    //ajax通用事务执行
    @Override
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
    public boolean executeBaseDataTran(ArrayList<MapperData> mdList) {
        try{
            for(MapperData md : mdList){
                String optType=md.getOpertion();
                String mapperStr=md.getMapperHref();

                switch (optType){
                    case "delete":
                        daoSupport.delete(mapperStr, md.getDm());
                        break;
                    case "save":
                        daoSupport.save(mapperStr, md.getDm());
                        break;
                    case "update":
                        daoSupport.update(mapperStr, md.getDm());
                        break;
                }
            }
            return true;
        }catch(Exception ex){
            return false;
        }
    }



}
