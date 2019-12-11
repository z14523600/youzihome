package com.kzki.youzihome.entity;

import com.kzki.youzihome.util.DataMap;
import lombok.Data;

@Data
public class MapperData {
    public String mapperHref;

    public String opertion;

    public DataMap dm;

    public MapperData(){};

    public MapperData(String opertion,String mapperHref,DataMap dm)
    {
        this.opertion=opertion;
        this.mapperHref=mapperHref;
        this.dm=dm;
    };

}
