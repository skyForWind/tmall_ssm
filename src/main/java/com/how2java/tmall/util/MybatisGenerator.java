package com.how2java.tmall.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisGenerator {

    public static void main(String[] args) throws Exception {
        //固定日期，防止多次运行
        String today = "2018-07-05";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = sdf.parse(today);
        Date d = new Date();

        if (d.getTime() > now.getTime() + 1000 * 60 * 60 * 24) {
            System.err.println("――――――未成成功运行――――――");
            System.err.println("――――――未成成功运行――――――");
            System.err.println("本程序具有破坏作用，应该只运行一次，如果必须要再运行，需要修改today变量为今天，如:" + sdf.format(new Date()));
            return;
        }

        if (false)
            return;

        // 自动生成pojo类和mapper类以及xml文件
        // 生成相关文件由配置文件决定-generatorConfig.xml
        // 生成位置由配置文件决定
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;

        InputStream is = MybatisGenerator.class.getClassLoader().getResource("generatorConfig.xml").openStream();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        System.out.println("生成代码成功，只能执行一次，以后执行会覆盖掉mapper,pojo,xml 等文件上做的修改");

    }
}