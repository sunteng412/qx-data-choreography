package com.linqingxuan.datachoreography.core.dsl;

import com.linqingxuan.datachoreography.core.dsl.config.DataConfig;
import com.linqingxuan.datachoreography.core.dsl.jdbc.datasource.DataSourceProvider;
import com.linqingxuan.datachoreography.core.spi.ExtensionLoader;
import lombok.Setter;

/**
 * 上下文
 * @author     : longchuan
 * @date       : 2021/10/10 8:22 下午
 * @description:
 * @version    :
 */
public class DataAppContext {
    private static final DataAppContext DATA_APP_CONTEXT = new DataAppContext();

    /**
     * 配置
     * */
    @Setter
    private DataConfig dataConfig;

    /**
     * dsl源配置
     * */
    @Setter
    private DataDslAccessFactory dataDslAccessFactory;

    /**
     * 注入配置
     * @param
     * @return
     * @description:
     */
    public static void initConfig(DataConfig config){
        DATA_APP_CONTEXT.setDataConfig(config);
    }

    /**
     * 启动
     * @param
     * @return
     * @description:
     */
    public static void start(){
        //预加载所有的数据
        ExtensionLoader.getExtensionLoader(DataDslAccessFactory.class).getDefaultJoin();
    }
}
