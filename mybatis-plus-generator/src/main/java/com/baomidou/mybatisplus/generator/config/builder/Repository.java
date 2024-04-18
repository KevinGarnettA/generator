/*
 * Copyright (c) 2011-2021, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.generator.config.builder;

import com.baomidou.mybatisplus.generator.ITemplate;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.function.ConverterFileName;
import com.baomidou.mybatisplus.generator.util.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Repository属性配置
 *
 * @author nieqiurong 2020/10/11.
 * @since 3.5.0
 */
public class Repository implements ITemplate {

    private final static Logger LOGGER = LoggerFactory.getLogger(Repository.class);

    private Repository() {
    }

    /**
     * 自定义继承的Repository类全称，带包名
     */
    private String superRepositoryClass = ConstVal.SUPER_REPOSITORY_CLASS;

    /**
     * 自定义继承的RepositoryImpl类全称，带包名
     */
    private String superRepositoryImplClass = ConstVal.SUPER_REPOSITORY_IMPL_CLASS;

    @NotNull
    public String getSuperRepositoryClass() {
        return superRepositoryClass;
    }

    @NotNull
    public String getSuperRepositoryImplClass() {
        return superRepositoryImplClass;
    }

    /**
     * 转换输出Repository文件名称
     *
     * @since 3.5.0
     */
    private ConverterFileName converterRepositoryFileName = (entityName -> "I" + entityName + ConstVal.REPOSITORY);

    /**
     * 转换输出RepositoryImpl文件名称
     *
     * @since 3.5.0
     */
    private ConverterFileName converterRepositoryImplFileName = (entityName -> entityName + ConstVal.REPOSITORY_IMPL);

    /**
     * 是否覆盖已有文件（默认 false）
     *
     * @since 3.5.2
     */
    private boolean fileOverride;

    @NotNull
    public ConverterFileName getConverterRepositoryFileName() {
        return converterRepositoryFileName;
    }

    @NotNull
    public ConverterFileName getConverterRepositoryImplFileName() {
        return converterRepositoryImplFileName;
    }

    public boolean isFileOverride() {
        return fileOverride;
    }

    @Override
    @NotNull
    public Map<String, Object> renderData(@NotNull TableInfo tableInfo) {
        Map<String, Object> data = new HashMap<>();
        data.put("superRepositoryClassPackage", this.superRepositoryClass);
        data.put("superRepositoryClass", ClassUtils.getSimpleName(this.superRepositoryClass));
        data.put("superRepositoryImplClassPackage", this.superRepositoryImplClass);
        data.put("superRepositoryImplClass", ClassUtils.getSimpleName(this.superRepositoryImplClass));
        return data;
    }

    public static class Builder extends BaseBuilder {

        private final Repository repository = new Repository();

        public Builder(@NotNull StrategyConfig strategyConfig) {
            super(strategyConfig);
        }

        /**
         * Repository接口父类
         *
         * @param clazz 类
         * @return this
         */
        public Builder superRepositoryClass(@NotNull Class<?> clazz) {
            return superRepositoryClass(clazz.getName());
        }

        /**
         * Repository接口父类
         *
         * @param superRepositoryClass 类名
         * @return this
         */
        public Builder superRepositoryClass(@NotNull String superRepositoryClass) {
            this.repository.superRepositoryClass = superRepositoryClass;
            return this;
        }

        /**
         * Repository实现类父类
         *
         * @param clazz 类
         * @return this
         */
        public Builder superRepositoryImplClass(@NotNull Class<?> clazz) {
            return superRepositoryImplClass(clazz.getName());
        }

        /**
         * Repository实现类父类
         *
         * @param superRepositoryImplClass 类名
         * @return this
         */
        public Builder superRepositoryImplClass(@NotNull String superRepositoryImplClass) {
            this.repository.superRepositoryImplClass = superRepositoryImplClass;
            return this;
        }

        /**
         * 转换输出repository接口文件名称
         *
         * @param converter 　转换处理
         * @return this
         * @since 3.5.0
         */
        public Builder convertRepositoryFileName(@NotNull ConverterFileName converter) {
            this.repository.converterRepositoryFileName = converter;
            return this;
        }

        /**
         * 转换输出repository实现类文件名称
         *
         * @param converter 　转换处理
         * @return this
         * @since 3.5.0
         */
        public Builder convertRepositoryImplFileName(@NotNull ConverterFileName converter) {
            this.repository.converterRepositoryImplFileName = converter;
            return this;
        }

        /**
         * 格式化repository接口文件名称
         *
         * @param format 　格式
         * @return this
         * @since 3.5.0
         */
        public Builder formatRepositoryFileName(@NotNull String format) {
            return convertRepositoryFileName((entityName) -> String.format(format, entityName));
        }

        /**
         * 格式化repository实现类文件名称
         *
         * @param format 　格式
         * @return this
         * @since 3.5.0
         */
        public Builder formatRepositoryImplFileName(@NotNull String format) {
            return convertRepositoryImplFileName((entityName) -> String.format(format, entityName));
        }

        /**
         * 覆盖已有文件（该方法后续会删除，替代方法为enableFileOverride方法）
         *
         * @see #enableFileOverride()
         */
        @Deprecated
        public Builder fileOverride() {
            LOGGER.warn("fileOverride方法后续会删除，替代方法为enableFileOverride方法");
            this.repository.fileOverride = true;
            return this;
        }

        /**
         * 覆盖已有文件
         */
        public Builder enableFileOverride() {
            this.repository.fileOverride = true;
            return this;
        }

        @NotNull
        public Repository get() {
            return this.repository;
        }
    }
}
