package com.fee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fee.bean.StudentBean;

public class StudentDao {

	public static int save(StudentBean bean) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			PreparedStatement ps = con
					.prepareStatement("insert into fee_student(rollno,name,email,sex,course,fee) values(?,?,?,?,?,?)");
			ps.setInt(1, bean.getRollno());
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getSex());
			ps.setString(5, bean.getCourse());
			ps.setInt(6, bean.getFee());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}


	public static int delete(int rollno) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("delete from fee_student where rollno=?");
			ps.setInt(1, rollno);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	public static List<StudentBean> getAllRecords() {
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("select * from fee_student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setRollno(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSex(rs.getString(4));
				bean.setCourse(rs.getString(5));
				bean.setFee(rs.getInt(6));
				list.add(bean);
			}
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return list;
	}

	public static StudentBean getRecordByRollno(int rollno) {
		StudentBean bean = new StudentBean();
		try {
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("select * from fee_student where rollno=?");
			ps.setInt(1, rollno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean.setRollno(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSex(rs.getString(4));
				bean.setCourse(rs.getString(5));
				bean.setFee(rs.getInt(6));
			}
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return bean;
	}

}