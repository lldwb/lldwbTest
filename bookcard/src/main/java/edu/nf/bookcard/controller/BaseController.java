package edu.nf.bookcard.controller;

import edu.nf.bookcard.vo.ResultVO;

public class BaseController {
    /**
     * 成功响应(比如在查询、第三方api等，需要返回数据的时候使用)
     *
     * @param data 数据
     * @param <T>
     * @return
     */
    public <T> ResultVO<T> success(T data) {
        ResultVO<T> vo = new ResultVO<>();
        vo.setCode(200);
        vo.setData(data);
        return vo;
    }

    /**
     * 成功响应(比如在添加、修改、删除等，不需要返回数据的时候使用)
     *
     * @return 空
     */
    public ResultVO success() {
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        return vo;
    }

    /**
     * 错误响应
     *
     * @param code
     * @param message
     * @return
     */
    public ResultVO error(int code, String message) {
        ResultVO vo = new ResultVO();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }
}
