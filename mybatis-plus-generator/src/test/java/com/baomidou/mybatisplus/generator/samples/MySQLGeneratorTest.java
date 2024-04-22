package com.baomidou.mybatisplus.generator.samples;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import org.junit.jupiter.api.Test;

/**
 * MySQL 代码生成
 *
 * @author lanjerry
 * @since 3.5.3
 */
public class MySQLGeneratorTest extends BaseGeneratorTest {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
        .Builder("jdbc:mysql://mysql-57:3308/db_management?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai", "harris", "haiking")

        .schema("")
        .build();

    @Test
    public void testSimple() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig().addInclude("test_task_xmind_copy1").
            entityBuilder().enableLombok().addIgnoreColumns().enableChainModel()
            .mapperBuilder().enableBaseColumnList().enableBaseColumnList().build());
        generator.global(globalConfig()
            .enableSwagger().author("kevin")
            .build());
        generator.packageInfo(packageConfig().parent("cn.testin.tm").build());
        generator.execute();
    }
}
