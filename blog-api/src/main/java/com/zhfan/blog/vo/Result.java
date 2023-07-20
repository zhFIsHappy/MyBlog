package com.zhfan.blog.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Result {
    private boolean success;
    private int code;
    private String msg;
    private Object data;
    public static Result success(Object data){
        return new Result(true, 200, "success" , data);
    }

    public static Result success(int code, String msg){
        return new Result(false, code, msg , null);
    }
}
