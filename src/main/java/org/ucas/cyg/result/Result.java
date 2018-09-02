package org.ucas.cyg.result;

/**
 * @Author: yunguan cheng
 * @Date: 2018/5/28 15:03
 * @Description:
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    /**
     * 构造函数为private，因为不希望用户通过构造函数而是通过success方法
     * @param data
     */
    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private Result(CodeMsg codeMsg) {
        if (codeMsg == null) {
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }

    /**
     * 成功时候的调用
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    /**
     * 失败时调用
     * @param codeMsg
     * @param <T>
     * @return
     */
    public static<T> Result<T> error(CodeMsg codeMsg) {
        return  new Result<T>(codeMsg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
