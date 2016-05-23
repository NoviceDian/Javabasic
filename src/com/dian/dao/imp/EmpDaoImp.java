package com.dian.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dian.dao.EmpDao;
import com.dian.entity.Employee;
import com.dian.util.DBConnection;

public class EmpDaoImp implements EmpDao {

	@Override
	public int addEmp(Employee emp) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getCon();
		String sql = "INSERT INTO emp (name, sex, birth, phone, address, joinTime, pwd, isLeader) VALUES "
				+ "	(?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, emp.getName());
			ps.setLong(2, emp.getSex());
			ps.setDate(3, emp.getBirth());
			ps.setString(4, emp.getPhone());
			ps.setString(5, emp.getAddress());
			ps.setDate(6, new Date(System.currentTimeMillis()));
			ps.setString(7, emp.getPwd());
			ps.setBoolean(8, emp.getIsLeader());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			int d = 0;
			if (rs != null && rs.next()) {
				d = rs.getInt(1);
			}
			return d;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.ckosedResult(rs);
			DBConnection.closedPst(ps);
			DBConnection.closedCon(con);
		}
		return 0;
	}

	@Override
	public void updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getCon();

		String sql = "UPDATE emp SET name=?, sex=? ,birth=?,phone=?,address=?,joinTime=?,pwd=?,isLeader=? WHERE id=?";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getSex());
			ps.setDate(3, emp.getBirth());
			ps.setString(4, emp.getPhone());
			ps.setString(5, emp.getAddress());
			ps.setDate(6, emp.getJoinTime());
			ps.setString(7, emp.getPwd());
			ps.setBoolean(8, emp.getIsLeader());
			ps.setInt(9, emp.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closedCon(con);
		}
	}

	@Override
	public void delEmp(int eid) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getCon();
		String sql = "DELETE FROM emp WHERE id=?;";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, eid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closedCon(con);
		}

	}

	@Override
	public List<Employee> findAllEmp() {
		// TODO Auto-generated method stub
		List<Employee> emps = new ArrayList<Employee>();
		Connection con = DBConnection.getCon();
		String sql = "SELECT * FROM emp";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setName(rs.getString("name"));
				emp.setAddress(rs.getString("address"));
				emp.setBirth(rs.getDate("birth"));
				emp.setId(rs.getInt("id"));
				emp.setIsLeader(rs.getBoolean("isLeader"));
				emp.setJoinTime(rs.getDate("joinTime"));
				emp.setPhone(rs.getString("phone"));
				emp.setPwd(rs.getString("pwd"));
				emp.setSex((char) rs.getShort("sex"));
				emps.add(emp);
			}
			return emps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closedCon(con);
		}
		return null;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getCon();
		String sql = "SELECT * FROM emp where id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			Employee emp = new Employee();
			while (rs.next()) {
				emp.setName(rs.getString("name"));
				emp.setAddress(rs.getString("address"));
				emp.setBirth(rs.getDate("birth"));
				emp.setId(rs.getInt("id"));
				emp.setIsLeader(rs.getBoolean("isLeader"));
				emp.setJoinTime(rs.getDate("joinTime"));
				emp.setPhone(rs.getString("phone"));
				emp.setPwd(rs.getString("pwd"));
				emp.setSex((char) rs.getShort("sex"));
			}
			return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closedCon(con);
		}
		return null;
	}

}
