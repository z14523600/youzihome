package com.kzki.youzihome.dao;

public interface Dao {

    public Object save(String str, Object obj);

    public Object update(String str, Object obj);

    public Object delete(String str, Object obj);

    public Object selectOne(String str, Object obj);

    public Object selectList(String str, Object obj);
}
