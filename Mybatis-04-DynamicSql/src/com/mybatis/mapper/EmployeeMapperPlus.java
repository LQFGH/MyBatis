/**
 * 
 */
package com.mybatis.mapper;

import java.util.List;

import com.mybatis.bean.Employee;

/**
 * @author Lee
 *
 */
public interface EmployeeMapperPlus {

	/**
	 * ���ݲ���id��ѯԱ��
	 * @return
	 */
	List<Employee> getEmpByDeptId();
	
	Employee getAllEmpAndDept(Integer i);
	
	/**
	 * ����id��ȡ����
	 * @param id
	 * @return
	 */
	Employee getEmployeeById(Integer id);
	
}
