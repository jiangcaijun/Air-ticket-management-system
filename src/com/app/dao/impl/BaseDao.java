/**
 * 包括基本的查询所有记录、查询单条记录以及增删改的基本方法
 */
package com.app.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import com.app.utils.JdbcUtil;

public class BaseDao {
	
	private ResultSet rs = null;//用于存放executeQuery查询的数据集
	private Connection conn = null;//用于获得的数据库链接
	private PreparedStatement ps = null;//用于存放预编译的sql语句
	/**
	 * 所有对数据的增删改，都可以调用此方法实现。
	 * sql为输入的sql语句，params为sql中所需参数。
	 * 返回int类型，表示操作记录的条数。其中0表示操作不成功。
	 * @param sql
	 * @param parames
	 * @return
	 */
	public int update(String sql,Object[] parames ){
		int row = 0;
		conn = JdbcUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			int len = parames.length;
			for (int i = 0; i < len; i++) {
				ps.setObject(i+1, parames[i]);
				System.out.println(i);
			}
			
			row = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return row;
	}
	
	/**
	 * 查询所有符合条件的记录。
	 * sql表示输入的sql语句,params表示sql所需的参数数组，cls表示所需传回的数据类型。
	 * 返回为Vector<T>，即返回cls类型的Vector。
	 * @param sql
	 * @param params
	 * @param cls
	 * @return
	 */
	public <T> Vector<T> search(String sql,Class<T> cls,Object[] parames){
		Vector<T> list = new Vector<T>();
		conn = JdbcUtil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			int len = parames.length;
			for (int i = 0; i < len; i++) {
				ps.setObject(i+1, parames[i]);
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData(); 
			int cc = rsm.getColumnCount();
			while(rs.next()){
				T obj = cls.newInstance();
				for (int i = 1; i <=cc; i++) {
					String cname = rsm.getColumnName(i);
					Object cvalue = rs.getObject(i);
					Field f =cls.getDeclaredField(change(cname));
					f.setAccessible(true);
					f.set(obj, cvalue);
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return list;
	}
	
	/**
	 * 查询单条符合条件的记录。
	 * sql表示输入的sql语句,params表示sql所需的参数数组，cls表示所需传回的数据类型。
	 * 返回为cls类型
	 * @param sql
	 * @param params
	 * @param cls
	 * @return
	 */
	public <T> T searchOne(String sql,Class<T> cls,Object[] params){
		T obj = null;
		conn = JdbcUtil.getConnection();
		if(params!=null&&params.length!=0){
			try {
				ps = conn.prepareStatement(sql);
				int len = params.length;
				for (int i = 0; i < len; i++) {
					ps.setObject(i+1, params[i]);
				}
				rs = ps.executeQuery();
				ResultSetMetaData rsm = rs.getMetaData(); 
				int cc = rsm.getColumnCount();
				if(rs.next()){
					obj = cls.newInstance();
					for (int i = 1; i <=cc; i++) {
						String cname = rsm.getColumnName(i);
						Object cvalue = rs.getObject(i);
						Field f = cls.getDeclaredField(change(cname));
						f.setAccessible(true);
						f.set(obj, cvalue);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		close();
		return obj;
	}
	
	public String change(String s){
		char[] orc = s.toLowerCase().toCharArray();
		int len = orc.length;
		char[] temp = new char[len];
		for (int i = 0,j=0; i < len; i++,j++) {
			if(orc[i]=='_'){
				i++;
				temp[j] = (char) (orc[i]-'a'+'A');
			}else {
				temp[j] = orc[i];
			}
		}
		String result = new String(temp).trim();
		return result;
	}
	
	/**
	 * 关闭所有连接
	 */
	public void close(){
		try {
			if(rs!=null){
				rs.close();
				rs = null;
			}
			if(ps!=null){
				ps.close();
				ps = null;
			}
			if(conn!=null){
				conn.close();
				conn = null;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
