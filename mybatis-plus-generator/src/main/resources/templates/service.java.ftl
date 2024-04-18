package ${package.Repository};

import ${package.Entity}.${entity};
import ${superRepositoryClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.RepositoryName} : ${superRepositoryClass}<${entity}>
<#else>
public interface ${table.RepositoryName} extends ${superRepositoryClass}<${entity}> {

}
</#if>
