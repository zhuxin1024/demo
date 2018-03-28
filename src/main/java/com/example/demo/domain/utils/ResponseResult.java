package com.example.demo.domain.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;


public class ResponseResult<T> {
    public final static int success = 0;
    public final static int failure = 1;
    private int code;
    private String desc;
    private Map<String,Object> values;
    private T data;

    /**
    *
    *
    **/
    public ResponseResult(){}

    public ResponseResult(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    /**
    *
    * @param code
    * @param desc
    * @param 
    * @param values
    *
    **/
    public ResponseResult(int code, String desc, Map<String, Object> values){
        this.code = code;
        this.desc = desc;
        this.values = values;
    }


    /**
    *
    * getter of code
    *
    **/
    public int getCode() {
        return code;
    }

    /**
    *
    * setter of code
    * @param code
    *
    **/
    public void setCode(int code) {
        this.code = code;
    }

    /**
    *
    * getter of desc
    *
    **/
    public String getDesc() {
        return desc;
    }

    /**
    *
    * setter of desc
    * @param desc
    *
    **/
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
    *
    * getter of values
    *
    **/
    public Map<String, Object> getValues() {
        return values;
    }

    /**
    *
    * setter of values
    * @param 
    * @param values
    *
    **/
    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

    /**
     * to json
     * @return
     */
    public String toJSONString(){
        return JSONObject.toJSONString(this);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
