package com.baomidou.mybatisplus.generator.config;

import com.baomidou.mybatisplus.generator.config.builder.GeneratorBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author nieqiurong 2020/10/10.
 */
public class TemplateConfigTest {

    @Test
    void disableTest() {
        TemplateConfig templateConfig;
        templateConfig = GeneratorBuilder.templateConfig().disable();
        Assertions.assertNull(templateConfig.getController());
        Assertions.assertNull(templateConfig.getRepository());
        Assertions.assertNull(templateConfig.getRepositoryImpl());
        Assertions.assertNull(templateConfig.getMapper());
        Assertions.assertNull(templateConfig.getXml());
        Assertions.assertNull(templateConfig.getEntity(true));
        Assertions.assertNull(templateConfig.getEntity(false));


        templateConfig = GeneratorBuilder.templateConfig().disable(TemplateType.REPOSITORY);
        Assertions.assertNull(templateConfig.getRepository());
        Assertions.assertNotNull(templateConfig.getEntity(true));
        Assertions.assertNotNull(templateConfig.getEntity(false));

        templateConfig = GeneratorBuilder.templateConfig().disable(TemplateType.REPOSITORY_IMPL);
        Assertions.assertNull(templateConfig.getRepositoryImpl());
        Assertions.assertNotNull(templateConfig.getEntity(true));
        Assertions.assertNotNull(templateConfig.getEntity(false));

        templateConfig = GeneratorBuilder.templateConfig().disable(TemplateType.ENTITY);
        Assertions.assertNotNull(templateConfig.getRepositoryImpl());
        Assertions.assertNotNull(templateConfig.getRepository());
        Assertions.assertNull(templateConfig.getEntity(true));
        Assertions.assertNull(templateConfig.getEntity(false));

        templateConfig = GeneratorBuilder.templateConfig().disable(TemplateType.ENTITY);
        Assertions.assertNotNull(templateConfig.getRepositoryImpl());
        Assertions.assertNotNull(templateConfig.getRepository());
        Assertions.assertNull(templateConfig.getEntity(true));
        Assertions.assertNull(templateConfig.getEntity(false));
    }

    @Test
    void entityTest() {
        Assertions.assertEquals("/templates/entity.kt", GeneratorBuilder.templateConfig().getEntity(true));
        Assertions.assertEquals("/templates/entity.java", GeneratorBuilder.templateConfig().getEntity(false));
        Assertions.assertEquals("/tm/entity.kt", GeneratorBuilder.templateConfigBuilder().entityKt("/tm/entity.kt").build().getEntity(true));
        Assertions.assertEquals("/tm/entity.java", GeneratorBuilder.templateConfigBuilder().entity("/tm/entity.java").build().getEntity(false));
        Assertions.assertEquals("/tm/entity.kt", new TemplateConfig.Builder().entityKt("/tm/entity.kt").build().getEntity(true));
        Assertions.assertEquals("/tm/entity.java", new TemplateConfig.Builder().entity("/tm/entity.java").build().getEntity(false));
        Assertions.assertEquals("myEntity.java.vm", new TemplateConfig.Builder().entity("myEntity.java.vm").build().getEntity(false));
        Assertions.assertEquals("myEntity.kt.vm", new TemplateConfig.Builder().entityKt("myEntity.kt.vm").build().getEntity(true));
    }

    @Test
    void builderTest() {
        TemplateConfig templateConfig;
        templateConfig = GeneratorBuilder.templateConfig();
        Assertions.assertNotNull(templateConfig.getEntity(true));
        Assertions.assertNotNull(templateConfig.getEntity(false));
        Assertions.assertNotNull(templateConfig.getRepository());
        Assertions.assertNotNull(templateConfig.getRepositoryImpl());

        templateConfig = new TemplateConfig.Builder().entity("/tmp/entity.java").entityKt("/tmp/entity.kt").Repository("/tmp/Repository.java").RepositoryImpl("/tmp/RepositoryImpl.java").build();
        Assertions.assertNotNull(templateConfig.getEntity(true));
        Assertions.assertNotNull(templateConfig.getEntity(false));
        Assertions.assertNotNull(templateConfig.getRepository());
        Assertions.assertNotNull(templateConfig.getRepositoryImpl());
        Assertions.assertEquals("/tmp/entity.kt", templateConfig.getEntity(true));
        Assertions.assertEquals("/tmp/entity.java", templateConfig.getEntity(false));
        Assertions.assertEquals("/tmp/Repository.java", templateConfig.getRepository());
        Assertions.assertEquals("/tmp/RepositoryImpl.java", templateConfig.getRepositoryImpl());
    }
}
