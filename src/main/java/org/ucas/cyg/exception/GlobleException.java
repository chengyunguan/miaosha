package org.ucas.cyg.exception;

import org.ucas.cyg.result.CodeMsg;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/2 21:59
 * @Description:
 */
public class GlobleException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private CodeMsg codeMsg;

    public GlobleException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
