import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Gen2
 * @Description:
 * @Author huangjian
 * @Date 2023/7/8
 **/
public class CodeGenerator {

    @Test
    void gen(){
        String projectPath = "E:\\IdeaProjects\\springboot-seata-at-order\\order-service";
        String projectApiPath = "E:\\IdeaProjects\\springboot-seata-at-order\\order-api";
        Map<OutputFile, String> pathInfo = MapUtil.builder(new HashMap<OutputFile, String>())
                .put(OutputFile.serviceImpl,
                        projectPath +"\\src\\main\\java\\com\\joe\\order\\service\\impl")
                .put(OutputFile.controller,
                        projectPath + "\\src\\main\\java\\com\\joe\\order\\controller")
                .put(OutputFile.mapperXml, projectPath + "\\src\\main\\resources\\mapper")
                .put(OutputFile.mapper, projectPath + "\\src\\main\\java\\com\\joe\\order\\mapper")
                .build();

        FastAutoGenerator
                .create(new DataSourceConfig.Builder(
                        "jdbc:mysql://127.0.0.1:3306/seata_at_order?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&autoReconnect=true&allowMultiQueries=true",
                        "root", "root").dbQuery(new MySqlQuery()).schema("mybatis-plus").typeConvert(new MySqlTypeConvert()))
                .globalConfig(builder -> {
                    //service,entity路径
                    builder.fileOverride().outputDir(projectApiPath + "\\src\\main\\java")
                            .author("huang").enableSwagger()// .enableKotlin()
                            .dateType(DateType.TIME_PACK).commentDate("yyyy-MM-dd");
                }).packageConfig(builder -> {
                    builder.parent("com.joe").moduleName("order").entity("entity").service("service").serviceImpl("service.impl")
                            .mapper("mapper").controller("controller").other("other").pathInfo(pathInfo); // 设置mapperXml生成路径
                }).templateConfig(builder -> {
                    builder.disable(TemplateType.ENTITY).entity("/templates/entity.java").service("/templates/service.java")
                            .serviceImpl("/templates/serviceImpl.java").mapper("/templates/mapper.java")
                            .mapperXml("/templates/mapper.xml").controller("/templates/controller.java");
                }).strategyConfig(builder -> {
                    builder.enableCapitalMode().enableSkipView().disableSqlFilter().addInclude("t_order") // 设置需要生成的表名
                            .addTablePrefix("t_").entityBuilder().enableLombok().enableTableFieldAnnotation().mapperBuilder()
                            .superClass(BaseMapper.class).enableMapperAnnotation().enableBaseResultMap().enableBaseColumnList(); // 设置过滤表前缀
                }).templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
