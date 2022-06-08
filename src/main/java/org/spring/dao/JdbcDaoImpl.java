package org.spring.dao;


import org.spring.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;


@Component
public class JdbcDaoImpl {


    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }


    public int getCircleCount(){
        String sql = "Select count(*) from circle";
        return jdbcTemplate.queryForObject(sql,Integer.class).intValue();
    }

    public String getCircleName(int circleId){
        String sql = "Select name from circle where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[] {circleId},String.class);
    }

//    public Circle getCircle(int circleId){
//
//        Connection connection = null;
//
//        try {
//
//            connection = dataSource.getConnection();
//
//
//            PreparedStatement ps = connection.prepareStatement("Select * from circle where id = ?");
//
//            ps.setInt(1, circleId);
//
//            Circle circle = null;
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                circle = new Circle(circleId, rs.getString("name"));
//            }
//            rs.close();
//            ps.close();
//
//            return circle;
//        }catch (Exception ex){
//            System.out.println(ex);
//        }
//        finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        return null;
//
//    }
}


