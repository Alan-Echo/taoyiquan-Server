package com.microservices.common.response;

import java.io.Serializable;

/**
 * @description: 页面响应数据
 * 
 * @date: 2020-11-26 12:37
 **/
public class ResponseData<T> implements Serializable {

    /** 请求状态 */
    private int status=200;

    /** 结果数据集 */
    private T data;

    /** 响应信息 */
    private String msg="success";

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    

    /** 成功数据集 */
    public ResponseData<T> success(T  dataList){
        this.setData(dataList);
        return this;
    }

    /** 成功数据集,接受数据 */
    public ResponseData<T> success(T  dataList,int total,int index){
        this.setData(dataList);
        return this;
    }

    /** 成功数据集,默认成功消息 */
    public ResponseData success(){
        return this;
    }

    /** 成功数据集,接受成功消息 */
    public ResponseData success(String msg){
        this.setMsg(msg);
        return this;
    }

    /** 成功数据集,接受成功消息 */
    public ResponseData success(String msg,T dataList){
        this.setMsg(msg);
        this.setData(dataList);
        return this;
    }

    /** 失败数据集 */
    public ResponseData fail(int ststus){
        this.setStatus(ststus);
        this.setMsg(ResultCode.COMMON_FAIL.getMessage());
        return this;
    }

    /** 失败数据集 */
    public ResponseData fail(ResultCode resultCode){
        this.setStatus(resultCode.getCode());
        this.setMsg(resultCode.getMessage());
        return this;
    }


    /** 失败数据集 */
    public ResponseData fail(String msg){
        this.setStatus(ResultCode.COMMON_FAIL.getCode());
        this.setMsg(msg);
        return this;
    }


    /** 异常数据/请求捕获 */
    public ResponseData<T> fail(int code,String msg){
        this.setMsg(msg);
        this.setStatus(code);
        return this;
    }


}

