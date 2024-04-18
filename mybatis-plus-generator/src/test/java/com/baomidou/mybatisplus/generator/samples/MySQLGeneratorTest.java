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
        .Builder("jdbc:mysql://192.168.33.24:3307/mos_dispatch?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "123456")
//        .Builder("jdbc:mysql://192.168.33.116:3306/mos_dispatch?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "123qwe")
        .schema("")
        .build();

    @Test
    public void testSimple() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig().addInclude("dispatch_task").
            entityBuilder().enableLombok().addIgnoreColumns("id","create_user_id","create_user_name","update_user_name","update_user_id","create_time","update_time","delete_flag").enableChainModel().build());
        generator.global(globalConfig()
            .enableSwagger().author("wangys")
            .build());
        generator.packageInfo(packageConfig().parent("com.sany.mos").build());
        generator.execute();
    }
}
