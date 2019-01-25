/**
 * 
 */
package com.mybatis.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lee
 *
 */
public class Department {

	private Integer id;

	private String departmentName;

	private List<Employee> emps = new ArrayList<>();

	/**
	 * @return the emps
	 */
	public List<Employee> getEmps() {
		return emps;
	}

	/**
	 * @param emps
	 *            the emps to set
	 */
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName
	 *            the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", emps=" + emps + "]";
	}

}
