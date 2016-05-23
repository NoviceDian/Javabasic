package com.dian.dao;

import java.util.List;

import com.dian.entity.Employee;

public interface EmpDao {
	//增加员工
	public int addEmp(Employee emp);
	//修改员工
	public void updateEmp(Employee emp);
	//删除员工
	public void delEmp(int eid);
	//查询所所有员工
	public List<Employee> findAllEmp();
	//按id查询员工
	Employee findById(int id);
}
