package com.googlecode.easyec.sika.ss;

import com.googlecode.easyec.sika.WorkPage;

/**
 * DOCUMENT IT
 *
 * @author JunJie
 */
public interface ExcelCtrl {

    /**
     * 返回工作本页面信息
     *
     * @return {@link com.googlecode.easyec.sika.WorkPage}
     */
    WorkPage getWorkPage();

    /**
     * 用来改变当前处理器类的工作页面的方法
     *
     * @param workPage 工作页面实例对象
     */
    void setWorkPage(WorkPage workPage);
}
