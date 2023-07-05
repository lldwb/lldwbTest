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
     */
    void add(String name, String sex, String createDate, String deposit);

    /**
     * 查询所有借书卡
     *
     * @return 借书卡集合
     */
    List<BookcardInfo> get();
}
