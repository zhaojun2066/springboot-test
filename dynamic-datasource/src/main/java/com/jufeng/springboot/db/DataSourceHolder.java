package com.jufeng.springboot.db;

import java.util.HashSet;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/12/24
 * \* Time: 10:59
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class DataSourceHolder {
    //线程本地环境
    private static final ThreadLocal<String> contextHolders = new ThreadLocal<String>();
    //数据源列表
    public static Set<String> dataSourceIds = new HashSet<>();
    //设置数据源
    public static void setDataSource(String customerType) {
        contextHolders.set(customerType);
    }
    //获取数据源
    public static String getDataSource() {
        return   contextHolders.get();
    }
    //清除数据源
    public static void clearDataSource() {
        contextHolders.remove();
    }
    /**
     * 判断指定DataSrouce当前是否存在
     * @param dataSourceId
     * @return
     * @author SHANHY
     * @create  2016年1月24日
     */
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }
}