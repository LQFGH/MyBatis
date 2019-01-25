package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.bean.Department;
import com.mybatis.bean.Employee;
import com.mybatis.mapper.DepartmentMapper;
import com.mybatis.mapper.EmployeeMapper;
import com.mybatis.mapper.EmployeeMapperPlus;

/**
 * 
 * @author Lee
 *
 */
public class MybatisTest {

	private String resource = "mybatis-config.xml";
	private InputStream inputStream;

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;

	{
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testGetDeptByIdPlus() {
		DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
		Department department = departmentMapper.getDeptByIdPlus(1);
		System.out.println(department.getDepartmentName());
	}
	
	@Test
	public void testGetDeptById() {
		DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
		Department department = departmentMapper.getDeptById(1);
		System.out.println(department);
	}
	
	@Test
	public void testGetAllEmpAndDept() {
		EmployeeMapperPlus employeeMapperPlus = sqlSession.getMapper(EmployeeMapperPlus.class);
		Employee allEmpAndDept = employeeMapperPlus.getAllEmpAndDept(1);
		System.out.println(allEmpAndDept);
	}
	
	@Test
	public void testGetEmployeeById() {
		EmployeeMapperPlus employeeMapperPlus = sqlSession.getMapper(EmployeeMapperPlus.class);
		Employee employee = employeeMapperPlus.getEmployeeById(1);
		System.out.println(employee);
	}
	
	
	
	@Test
	public void testGetMapByLastName() {
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		Map<Integer, Employee> mapByLastName = employeeMapper.getMapByLastName("%anni%");
		System.out.println(mapByLastName);
	}
	
	@Test
	public void testGetListMapById() {
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		List<Map<String,Employee>> listMapLikeLastName = employeeMapper.getListMapLikeLastName("%anni%");
		System.out.println(listMapLikeLastName);
	}
	
	@Test
	public void testGetMapById() {
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		Map<String, Object> map = employeeMapper.getMapById(1);
		System.out.println(map);
	}
	
	@Test
	public void testGetAllEmp() {
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> allEmp = employeeMapper.getAllEmp();
		System.out.println(allEmp);
	}
	
	@Test
	public void testSelectByMap() {
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		Map<String , Object> map = new HashMap<>();
		map.put("id", 1);
		map.put("lastName", "tom");
		Employee employee = employeeMapper.selectByMap(map);
		System.out.println(employee);
	}
	
	@Test
	public void testSelectByIdAndName() {
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		Employee employee = employeeMapper.selectByIdAndName(1, "tom");
		System.out.println(employee);
	}
	
	@Test
	public void testUpdate() {
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		Employee employee = new Employee(9, "anni", "1", "163.com.cn");
		int updateEmp = employeeMapper.updateEmp(employee);
		System.out.println(updateEmp);
	}
	
	@Test
	public void testDelexte() {
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		boolean b = employeeMapper.deleteEmp(8);
		System.out.println(b);
	}
	
	@Test
	public void testAdd() {
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		Employee employee = new Employee(null,"anni1","0","1234@aa.com");
		employeeMapper.addEmp(employee);
		System.out.println(employee.getId());
		
	}
	
	@Test
	public void test() throws IOException {
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		Employee employee = employeeMapper.selectEmployeeById(1);
		System.out.println(employeeMapper);
		System.out.println(employee);
	}
	
	@Test
	public void testList() {
		List<Object> list = Arrays.asList("AA","BB","CC");
		List<Map<String,Object>> dataFormat = dataFormat(list);
		System.out.println(dataFormat);
	}

	/**
	 * �ѵ�����listת����list���map����ʽ
	 * map��key��key
	 * @param list
	 * @return
	 */
	public List<Map<String,Object>> dataFormat(List<Object> list){
		// ���������ݵļ�
		final String KEY = "key";
		List<Map<String, Object>> dataList = new ArrayList<>();
		Map<String, Object> map ;
		for (Object obj : list) {
			map = new HashMap<>();
			map.put(KEY, obj);
			dataList.add(map);
		}
		return dataList;
	}
	
	@Before
	public void init() throws IOException {
		sqlSession = sqlSessionFactory.openSession();
	}

	@After
	public void destroy() {
		sqlSession.commit();
		sqlSession.close();
	}

}
