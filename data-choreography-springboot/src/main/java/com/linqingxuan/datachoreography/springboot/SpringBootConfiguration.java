package com.linqingxuan.datachoreography.springboot;

import com.linqingxuan.datachoreography.core.dsl.DataAppContext;
import com.linqingxuan.datachoreography.core.dsl.config.DataConfig;
import com.linqingxuan.datachoreography.core.dsl.jdbc.dbutils.DataSourceUtil;
import com.linqingxuan.datachoreography.springboot.utils.PropertyUtil;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Map;

/**
 * springboot自动装配
 * @author     : longchuan
 * @date       : 2021/10/8 11:14 下午
 * @description:
 * @version    :
 */
@Configuration
@ConditionalOnProperty(prefix = "data-choreography", name = "enabled", havingValue = "true", matchIfMissing = true)
public class SpringBootConfiguration implements EnvironmentAware {

    /**
     * Set the {@code Environment} that this component runs in.
     *
     * @param environment
     */
    @SneakyThrows
    @Override
    public void setEnvironment(Environment environment) {
        //初始化数据源
        initDataConfig(environment);
    }

    /**
     * 获取数据源
     * @param
     * @return
     * @description:
     */
    private Boolean initDataConfig(final Environment environment) throws ReflectiveOperationException, NamingException {
        String dataSourcePrefix = "data-choreography.datasource.";
        String configPrefix = "data-choreography.config.";


        Map<String, Object> dataSourceProps = PropertyUtil.handle(environment, dataSourcePrefix , Map.class);
        Assert.notEmpty(dataSourceProps,"未找到数据源配置");

        Map<String, Object> configProps = PropertyUtil.handle(environment, configPrefix , Map.class);
        Assert.notEmpty(dataSourceProps,"未找到数据源配置");

        DataConfig dataConfig = new DataConfig();
        dataConfig.setDataProps(configProps);
        dataConfig.setDataSourceProps(dataSourceProps);
        DataAppContext.initConfig(dataConfig);
        DataAppContext.start();
        return Boolean.TRUE;
    }

}
