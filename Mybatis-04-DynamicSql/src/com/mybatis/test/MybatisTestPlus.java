package com.mybatis.test;

import com.mybatis.bean.Employee;
import com.mybatis.mapper.EmployeeMapperDynamicSql;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTestPlus {

    private String resource = "mybatis-config.xml";
    private InputStream inputStream;

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
        public void test1(){

        }
    {
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testContionIf(){
        EmployeeMapperDynamicSql employeeMapperDynamicSql = sqlSession.getMapper(EmployeeMapperDynamicSql.class);
        Employee employee = new Employee();
        employee.setId(9);
        employee.setLastName("an");
        employee.setGender("1");
        List<Employee> byConditionIf = employeeMapperDynamicSql.getByConditionIf(employee);
        System.out.println(byConditionIf);
    }

    @Before
    public void init(){
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void destory(){
        sqlSession.commit();
        sqlSession.close();
    }

}
