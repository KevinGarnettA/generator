package ${package.RepositoryImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Repository}.${table.RepositoryName};
import ${superRepositoryImplClassPackage};
import org.springframework.stereotype.Repository;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Repository
<#if kotlin>
open class ${table.RepositoryImplName} : ${superRepositoryImplClass}<${table.mapperName}, ${entity}>(), ${table.RepositoryName} {

}
<#else>
public class ${table.RepositoryImplName} extends ${superRepositoryImplClass}<${table.mapperName}, ${entity}> implements ${table.RepositoryName} {

}
</#if>
