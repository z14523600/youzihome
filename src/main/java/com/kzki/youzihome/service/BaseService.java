package com.kzki.youzihome.service;

import com.kzki.youzihome.entity.MapperData;
import com.kzki.youzihome.util.DataMap;

import java.util.ArrayList;
import java.util.HashMap;

public interface BaseService {
    public ArrayList<HashMap> getDataList(String mapperStr, DataMap dm);

    public boolean executeBaseData(String mapperStr,DataMap dm,String optType);

    public boolean executeBaseDataTran(ArrayList<MapperData> mdList);

}
