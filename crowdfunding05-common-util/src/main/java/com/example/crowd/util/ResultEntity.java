package com.example.crowd.util;

/**
 * 同一整个项目中Ajax请求返回的结果
 * @param <T>
 */
public class ResultEntity<T> {
    private final static String SUCCESS = "SUCCESS";
    private final static String FAILED = "FAILED";
    private String result;//请求结果是失败还是成功
    private T data;//返回的结果
    private String message;//错误信息
    public static <Type> ResultEntity<Type> successWithoutData(){
        return new ResultEntity<Type>(SUCCESS,null,null);
    }
    public static <Type> ResultEntity<Type> successWithData(Type data){
        return new ResultEntity<Type>(SUCCESS,data,null);
    }
    public static <Type> ResultEntity<Type> failedWithMessage(String message){
        return new ResultEntity<Type>(FAILED,null,message);
    }

    public ResultEntity() {
    }

    public ResultEntity(String result, T data, String message) {
        this.result = result;
        this.data = data;
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
