package com.zhangkai.dao;

import com.zhangkai.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql="insert into usertable(username,password,email,gender,birthdate) values(?,?,?,?,?)";
        PreparedStatement statement=con.prepareStatement(sql);
        user=null;
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3,user.getEmail());
        statement.setString(4, user.getGender());
        statement.setDate(5, (java.sql.Date) user.getBirthdate());
        int n=statement.executeUpdate();
        if(n>0) {
            return true;
        }else {return  false;}
    }

    @Override
    public boolean deleteUser(Connection con, User user) throws SQLException {
        PreparedStatement statement=null;
        String sql = "delete from usertable where username=?";
        statement=con.prepareStatement(sql);
        statement.setString(1,user.getUsername());
        int n=statement.executeUpdate();
        System.out.println("delete success");
        if(n>0) {
            return true;
        }else {return  false;}
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update usertable set username=?,password=?,email=?,gender=?,birthdate=? where id=?";
        PreparedStatement statement=con.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getEmail());
        statement.setString(4,user.getGender());
        statement.setString(5, String.valueOf(user.getBirthdate()));
        statement.setInt(6,user.getId());
        int result=statement.executeUpdate();
        System.out.println("update success");
        return result;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql="select * from Usertable where id=?";
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setInt(1,id);
        ResultSet rs= stmt.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select * from Usertable where username=? and password=?";
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(1,username);
        stmt.setString(2,password);
        ResultSet rs= stmt.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select * from Usertable where username=? ";
        ArrayList<User> List = new ArrayList<User>();
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(1,username);
        ResultSet rs= stmt.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
           List.add(user);

        }
        return List;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select * from Usertable where password=? ";
        ArrayList<User> List = new ArrayList<User>();
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(1, password);
        ResultSet rs= stmt.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            List.add(user);

        }
        return List;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="select * from Usertable where email=? ";
        ArrayList<User> List = new ArrayList<User>();
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(1,email);
        ResultSet rs= stmt.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            List.add(user);

        }
        return List;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="select * from Usertable where gender=? ";
        ArrayList<User> List = new ArrayList<User>();
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(1,gender);
        ResultSet rs= stmt.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            List.add(user);

        }
        return List;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="select * from Usertable where birthdate=? ";
        ArrayList<User> List = new ArrayList<User>();
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setDate(1, (java.sql.Date) birthDate);
        ResultSet rs= stmt.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            List.add(user);

        }
        return List;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="select * from Usertable";
        ArrayList<User> List = new ArrayList<User>();
        PreparedStatement stmt=con.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            List.add(user);

        }
        return List;
    }
}
