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
package com.baomidou.mybatisplus.generator.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 模板路径配置项
 *
 * @author tzg hubin
 * @since 2017-06-17
 */
public class TemplateConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateConfig.class);

    /**
     * 设置实体模板路径
     */
    private String entity;

    /**
     * 设置实体模板路径(kotlin模板)
     */
    private String entityKt;

    /**
     * 设置控制器模板路径
     */
    private String controller;

    /**
     * 设置Mapper模板路径
     */
    private String mapper;

    /**
     * 设置MapperXml模板路径
     */
    private String xml;

    /**
     * 设置Repository模板路径
     */
    private String repository;

    private String service;

    private String deleteReq;

    private String listReq;

    private String pageReq;

    private String saveReq;
    private String serviceImpl;

    /**
     * 设置RepositoryImpl模板路径
     */
    private String repositoryImpl;

    /**
     * 是否禁用实体模板（默认 false）
     */
    private boolean disableEntity;

    /**
     * 不对外爆露
     */
    private TemplateConfig() {
        this.entity = ConstVal.TEMPLATE_ENTITY_JAVA;
        this.entityKt = ConstVal.TEMPLATE_ENTITY_KT;
        this.controller = ConstVal.TEMPLATE_CONTROLLER;
        this.mapper = ConstVal.TEMPLATE_MAPPER;
        this.xml = ConstVal.TEMPLATE_XML;
        this.repository = ConstVal.TEMPLATE_REPOSITORY;
        this.repositoryImpl = ConstVal.TEMPLATE_REPOSITORY_IMPL;
        this.service = ConstVal.TEMPLATE_SERVICE;
        this.serviceImpl = ConstVal.TEMPLATE_SERVICE_IMPL;
        this.deleteReq = ConstVal.TEMPLATE_DELETE_REQ;
        this.listReq = ConstVal.TEMPLATE_LIST_REQ;
        this.pageReq = ConstVal.TEMPLATE_PAGE_REQ;
        this.saveReq = ConstVal.TEMPLATE_SAVE_REQ;

    }

    /**
     * 当模板赋值为空时进行日志提示打印
     *
     * @param value        模板值
     * @param templateType 模板类型
     */
    private void logger(String value, TemplateType templateType) {
        if (StringUtils.isBlank(value)) {
            LOGGER.warn("推荐使用disable(TemplateType.{})方法进行默认模板禁用.", templateType.name());
        }
    }

    /**
     * 获取实体模板路径
     *
     * @param kotlin 是否kotlin
     * @return 模板路径
     */
    public String getEntity(boolean kotlin) {
        if (!this.disableEntity) {
            if (kotlin) {
                return StringUtils.isBlank(this.entityKt) ? ConstVal.TEMPLATE_ENTITY_KT : this.entityKt;
            }
            return StringUtils.isBlank(this.entity) ? ConstVal.TEMPLATE_ENTITY_JAVA : this.entity;
        }
        return null;
    }

    /**
     * 禁用模板
     *
     * @param templateTypes 模板类型
     * @return this
     * @since 3.3.2
     */
    public TemplateConfig disable(@NotNull TemplateType... templateTypes) {
        if (templateTypes != null && templateTypes.length > 0) {
            for (TemplateType templateType : templateTypes) {
                switch (templateType) {
                    case ENTITY:
                        this.entity = null;
                        this.entityKt = null;
                        //暂时没其他多的需求,使用一个单独的boolean变量进行支持一下.
                        this.disableEntity = true;
                        break;
                    case CONTROLLER:
                        this.controller = null;
                        break;
                    case MAPPER:
                        this.mapper = null;
                        break;
                    case XML:
                        this.xml = null;
                        break;
                    case REPOSITORY:
                        this.repository = null;
                        break;
                    case REPOSITORY_IMPL:
                        this.repositoryImpl = null;
                        break;
                    case SERVICE:
                        this.service = null;
                        break;
                    case SERVICE_IMPL:
                        this.serviceImpl = null;
                        break;
                    case LIST_REQ:
                        this.listReq = null;
                        break;
                    case PAGE_REQ:
                        this.pageReq = null;
                        break;
                    case SAVE_REQ:
                        this.saveReq = null;
                        break;
                    case DELETE_REQ:
                        this.deleteReq = null;
                        break;
                    default:
                }
            }
        }
        return this;
    }

    /**
     * 禁用全部模板
     *
     * @return this
     * @since 3.5.0
     */
    public TemplateConfig disable() {
        return disable(TemplateType.values());
    }

    public String getRepository() {
        return repository;
    }

    public String getRepositoryImpl() {
        return repositoryImpl;
    }

    public String getMapper() {
        return mapper;
    }

    public String getXml() {
        return xml;
    }

    public String getController() {
        return controller;
    }

    /**
     * 模板路径配置构建者
     *
     * @author nieqiurong 3.5.0
     */
    public static class Builder implements IConfigBuilder<TemplateConfig> {

        private final TemplateConfig templateConfig;

        /**
         * 默认生成一个空的
         */
        public Builder() {
            this.templateConfig = new TemplateConfig();
        }

        /**
         * 禁用所有模板
         *
         * @return this
         */
        public Builder disable() {
            this.templateConfig.disable();
            return this;
        }

        /**
         * 禁用模板
         *
         * @return this
         */
        public Builder disable(@NotNull TemplateType... templateTypes) {
            this.templateConfig.disable(templateTypes);
            return this;
        }

        /**
         * 设置实体模板路径(JAVA)
         *
         * @param entityTemplate 实体模板
         * @return this
         */
        public Builder entity(@NotNull String entityTemplate) {
            this.templateConfig.disableEntity = false;
            this.templateConfig.entity = entityTemplate;
            return this;
        }

        /**
         * 设置实体模板路径(kotlin)
         *
         * @param entityKtTemplate 实体模板
         * @return this
         */
        public Builder entityKt(@NotNull String entityKtTemplate) {
            this.templateConfig.disableEntity = false;
            this.templateConfig.entityKt = entityKtTemplate;
            return this;
        }

        /**
         * 设置Repository模板路径
         *
         * @param repositoryTemplate     Repository接口模板路径
         * @return this
         */
        public Builder Repository(@NotNull String repositoryTemplate) {
            this.templateConfig.repository = repositoryTemplate;
            return this;
        }

        /**
         * 设置RepositoryImpl模板路径
         *
         * @param repositoryImplTemplate Repository实现类模板路径
         * @return this
         */
        public Builder RepositoryImpl(@NotNull String repositoryImplTemplate) {
            this.templateConfig.repositoryImpl = repositoryImplTemplate;
            return this;
        }



        /**
         * 设置Repository模板路径
         *
         * @param serviceTemplate     Repository接口模板路径
         * @return this
         */
        public Builder Service(@NotNull String serviceTemplate) {
            this.templateConfig.repository = serviceTemplate;
            return this;
        }

        /**
         * 设置RepositoryImpl模板路径
         *
         * @param serviceImplTemplate Repository实现类模板路径
         * @return this
         */
        public Builder ServiceImpl(@NotNull String serviceImplTemplate) {
            this.templateConfig.serviceImpl = serviceImplTemplate;
            return this;
        }

        /**
         * 设置mapper模板路径
         *
         * @param mapperTemplate mapper模板路径
         * @return this
         */
        public Builder mapper(@NotNull String mapperTemplate) {
            this.templateConfig.mapper = mapperTemplate;
            return this;
        }

        /**
         * 设置mapperXml模板路径
         *
         * @param xmlTemplate xml模板路径
         * @return this
         */
        public Builder xml(@NotNull String xmlTemplate) {
            this.templateConfig.xml = xmlTemplate;
            return this;
        }

        /**
         * 设置控制器模板路径
         *
         * @param controllerTemplate 控制器模板路径
         * @return this
         */
        public Builder controller(@NotNull String controllerTemplate) {
            this.templateConfig.controller = controllerTemplate;
            return this;
        }

        /**
         * 设置控制器模板路径
         *
         * @param listReqTemplate 控制器模板路径
         * @return this
         */
        public Builder listReq(@NotNull String listReqTemplate) {
            this.templateConfig.controller = listReqTemplate;
            return this;
        }
        /**
         * 设置控制器模板路径
         *
         * @param deleteReqTemplate 控制器模板路径
         * @return this
         */
        public Builder deleteReq(@NotNull String deleteReqTemplate) {
            this.templateConfig.deleteReq = deleteReqTemplate;
            return this;
        }
        /**
         * 设置控制器模板路径
         *
         * @param saveReqTemplate 控制器模板路径
         * @return this
         */
        public Builder saveReq(@NotNull String saveReqTemplate) {
            this.templateConfig.saveReq = saveReqTemplate;
            return this;
        }
        /**
         * 设置控制器模板路径
         *
         * @param pageTemplate 控制器模板路径
         * @return this
         */
        public Builder pageReq(@NotNull String pageTemplate) {
            this.templateConfig.controller = pageTemplate;
            return this;
        }

        /**
         * 构建模板配置对象
         *
         * @return 模板配置对象
         */
        @Override
        public TemplateConfig build() {
            return this.templateConfig;
        }
    }

    public String getService() {
        return service;
    }

    public String getServiceImpl() {
        return serviceImpl;
    }

    public String getDeleteReq() {
        return deleteReq;
    }

    public String getListReq() {
        return listReq;
    }

    public String getPageReq() {
        return pageReq;
    }

    public String getSaveReq() {
        return saveReq;
    }
}
