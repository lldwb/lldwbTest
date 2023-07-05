package edu.nf.bookcard.service;

import edu.nf.bookcard.entity.BookcardInfo;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public interface BookcardInfoService {
    /**
     * 添加借书卡
     * @param bookcardInfo 借书卡对象
     */
    void add(BookcardInfo bookcardInfo);

    /**
     * 查询所有借书卡
     *
     * @return 借书卡集合
     */
    List<BookcardInfo> get();
}
