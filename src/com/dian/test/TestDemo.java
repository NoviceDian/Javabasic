package com.dian.test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import org.junit.Test;

import com.dian.dao.EmpDao;
import com.dian.dao.imp.EmpDaoImp;
import com.dian.entity.Employee;
import com.dian.util.DBConnection;

public class TestDemo {

	
	@Test
	public void getCon(){
		Connection con = DBConnection.getCon();
		System.out.println(con);
		DBConnection.closedCon(con);
	}
	
	@Test
	public void add(){
		Employee emp = new Employee();
		emp.setName("吴小娟");
		emp.setPhone("123321");
		emp.setAddress("华三技术有限公司");
		Date birth = new Date(System.currentTimeMillis());
		emp.setBirth(birth);
		emp.setIsLeader(true);
		Date joinTime = new Date(System.currentTimeMillis());
		emp.setJoinTime(joinTime);
		emp.setPwd("3344520");
		EmpDao dao = new EmpDaoImp();
		int id = dao.addEmp(emp);
		System.out.println(id);
	}
	
	@Test
	public void modify(){
		Employee emp = new Employee();
		emp.setName("吴小娟");
		emp.setPhone("123321");
		emp.setAddress("华三技术有限公司");
		Date birth = new Date(System.currentTimeMillis());
		emp.setBirth(birth);
		emp.setIsLeader(true);
		Date joinTime = new Date(System.currentTimeMillis());
		emp.setJoinTime(joinTime);
		emp.setPwd("3344520");
		emp.setId(1);
		EmpDao dao = new EmpDaoImp();
		dao.updateEmp(emp);
	}
	
	@Test
	public void del(){
		EmpDao dao = new EmpDaoImp();
		dao.delEmp(4);
	}
	
	@Test
	public void find(){
		EmpDao dao = new EmpDaoImp();
		List<Employee> list = dao.findAllEmp();
		for (Employee employee : list) {
			System.out.println(employee.getName());
		}
		
		Employee emp = dao.findById(1);
		System.out.println(emp.getName()+":"+emp.getId());
		
	}
	
	
	
	
}
