package com.moon.plus.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;

/**
 * 第6章：多租户实现、特定sql过滤
 *
 * @author moon  2020/09/06  10:48
 */
//@Configuration
public class MybatisPlusConfiguration {
/*

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }


    */
/**
     * 5-1 性能分析实现及参数设置
     *
     * @return
     *//*

    @Bean
    @Profile({"dev", "test"})
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setFormat(true);
//        performanceInterceptor.setMaxTime(5L);
        return performanceInterceptor;
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        ArrayList<ISqlParser> sqlParserList = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new TenantHandler() {
            @Override
            public Expression getTenantId() {
                return new LongValue(1088248166370832385L);
            }

            @Override
            public String getTenantIdColumn() {
                return "manager_id";
            }

            */
/**
             * 是否过滤表，返回true，不过滤；返回false，过滤.
             *
             * @param tableName
             * @return
             *//*

            @Override
            public boolean doTableFilter(String tableName) {
                if ("role".equals(tableName)) {
//                if ("user".equals(tableName)) {
                    System.out.println("返回值为：" + "true");
                    return true;
                }
                System.out.println("返回值为：" + "false");
                return false;
            }
        });

        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);
        paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {
            @Override
            public boolean doFilter(MetaObject metaObject) {

                MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
                if ("com.moon.plus.dao.UserMapper.selectById".equals(ms.getId())) {
                    return true;
                }

                return false;
            }
        });

        return paginationInterceptor;
    }

*/

}
