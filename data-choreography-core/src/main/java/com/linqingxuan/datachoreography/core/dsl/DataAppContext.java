package com.linqingxuan.datachoreography.core.dsl;

import com.linqingxuan.datachoreography.core.dsl.config.DataConfig;
import com.linqingxuan.datachoreography.core.dsl.constant.ExtConfig;
import com.linqingxuan.datachoreography.core.dsl.jdbc.datasource.DataSourceProvider;
import com.linqingxuan.datachoreography.core.spi.ExtensionLoader;
import lombok.Getter;
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
    @Getter
    private static DataConfig dataConfig;

    /**
     * dsl源配置
     * */
    @Setter
    private static DataDslAccessFactory dataDslAccessFactory;


    /**
     * 注入配置
     * @param
     * @return
     * @description:
     */
    public static void initConfig(DataConfig config){
        DataAppContext.setDataConfig(config);
    }

    /**
     * 启动
     * @param
     * @return
     * @description:
     */
    public static void start(){
        //预加载所有的数据
        DataDslAccessFactory tempDataDslAccessFactory = ExtensionLoader.getExtensionLoader(DataDslAccessFactory.class)
                .getJoin(ExtConfig.getParams(dataConfig.getDataProps(),ExtConfig.DATASOURCE_DSL_ACCESS));
        tempDataDslAccessFactory.init(dataConfig);

        dataDslAccessFactory = tempDataDslAccessFactory;
    }
}
