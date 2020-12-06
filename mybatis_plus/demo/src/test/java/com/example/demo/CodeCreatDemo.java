package com.example.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

//代码生成器
public class CodeCreatDemo {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        //设置实体
        GlobalConfig config = new GlobalConfig();
        String projiectpath = System.getProperty("user.dir");
        config.setOutputDir(projiectpath+"/src/main/java");
        config.setAuthor("李司繁");
        config.setOpen(false);
        config.setFileOverride(true);//是否覆盖
        config.setServiceName("%sService");//去Service的I前缀
        config.setIdType(IdType.ID_WORKER);//id生成策略
        config.setDateType(DateType.ONLY_DATE);//日期类型
        config.setSwagger2(true);
        autoGenerator.setGlobalConfig(config);
        //设置数据源
        DataSourceConfig sourceConfig = new DataSourceConfig();
        sourceConfig.setUsername("root");
        sourceConfig.setPassword("root");
        sourceConfig.setDbType(DbType.MYSQL);
        sourceConfig.setUrl("jdbc:mysql://localhost:3306/mybaits_plus?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true");
        sourceConfig.setDriverName("com.mysql.jdbc.Driver");
        autoGenerator.setDataSource(sourceConfig);
        //包的配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("bob");
        packageConfig.setParent("com.dream");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setController("controller");
        autoGenerator.setPackageInfo(packageConfig);
        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("user");//设置要映射的表名

        //自动删除策略
        TableFill autoGenerator_create = new TableFill("autoGenerator_create", FieldFill.INSERT);
        TableFill modify = new TableFill("autoGenerator_update", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(autoGenerator_create);
        tableFills.add(modify);
        //.setSuperEntityClass("你自己的父类实体")
        strategyConfig.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)

                .setEntityLombokModel(true)
                .setLogicDeleteFieldName("deleted")
                .setTableFillList(tableFills)
                .setVersionFieldName("version")
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.execute();
    }


}
