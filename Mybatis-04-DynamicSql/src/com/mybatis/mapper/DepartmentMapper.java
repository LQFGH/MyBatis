/**
 * 
 */
package com.mybatis.mapper;

import com.mybatis.bean.Department;

/**
 * @author Lee
 *
 */
public interface DepartmentMapper {

	/**
	 * ��ѯ���ź����ж�ӦԱ��
	 * @return
	 */
	Department getDeptByIdPlus(Integer id);
	
	/**
	 * ����id��ȡ����
	 * @param id
	 * @return
	 */
	Department getDeptById(Integer id);
	
}
