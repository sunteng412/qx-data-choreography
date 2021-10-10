package com.linqingxuan.datachoreography.springboot;

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

    }

    /**
     * 获取数据源
     * @param
     * @return
     * @description:
     */
    private DataSource getDataSource(final Environment environment) throws ReflectiveOperationException, NamingException {
        String dataSourcePrefix = "data-choreography.datasource.";
        Map<String, Object> dataSourceProps = PropertyUtil.handle(environment, dataSourcePrefix , Map.class);
        Assert.notEmpty(dataSourceProps,"错误的数据源配置");

        return DataSourceUtil.getDataSource(dataSourceProps.get("type").toString(), dataSourceProps);
    }

}
