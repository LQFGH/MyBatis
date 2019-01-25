package com.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.mybatis.bean.Employee;

/**
 * 
 * @author Lee
 *
 */
public interface EmployeeMapper {
	
	/**
	 * �����û�����ȡmap
	 * @return
	 */
	@MapKey("id")
	Map<Integer, Employee> getMapByLastName(String lastName);
	
	/**
	 * 
	 * @param lastName
	 * @return
	 */
	List<Map<String, Employee>> getListMapLikeLastName(String lastName);
	
	/**
	 * ����id��ȡmap
	 * @param id
	 * @return
	 */
	Map<String, Object> getMapById(Integer id);
	
	/**
	 * �������е�employee
	 * @return
	 */
	List<Employee> getAllEmp();
	
	Employee selectEmp(@Param("id") Integer id, String lastName);
	
	/**
	 * ����id��username��ȡemployee
	 * @param map
	 * @return
	 */
	Employee selectByMap(Map<String, Object> map);

	/**
	 * ����id��username��ȡemployee
	 * @param id
	 * @param userName
	 * @return
	 */
	Employee selectByIdAndName(@Param("id") Integer id, @Param("lastName") String lastName);
	
	/**
	 * ��ȡԱ����Ϣ
	 * @param id
	 * @return
	 */
	Employee selectEmployeeById(Integer id);
	
	/**
	 * ���Ա��
	 * @param employee
	 */
	void addEmp(Employee employee);
	
	/**
	 * ɾ��Ա��
	 * @param id
	 * @return
	 */
	boolean deleteEmp(Integer id);
	
	/**
	 * �޸�Ա��
	 * @param employee
	 * @return
	 */
	int updateEmp(Employee employee);
	
}
