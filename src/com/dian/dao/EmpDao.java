package com.dian.dao;

import java.util.List;

import com.dian.entity.Employee;

public interface EmpDao {
	//����Ա��
	public int addEmp(Employee emp);
	//�޸�Ա��
	public void updateEmp(Employee emp);
	//ɾ��Ա��
	public void delEmp(int eid);
	//��ѯ������Ա��
	public List<Employee> findAllEmp();
	//��id��ѯԱ��
	Employee findById(int id);
}
