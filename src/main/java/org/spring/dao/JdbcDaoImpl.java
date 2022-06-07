package org.spring.dao;


import org.spring.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;


@Component
public class JdbcDaoImpl {

    @Autowired
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Circle getCircle(int circleId){

        Connection connection = null;

        try {

            connection = dataSource.getConnection();


            PreparedStatement ps = connection.prepareStatement("Select * from circle where id = ?");

            ps.setInt(1, circleId);

            Circle circle = null;

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                circle = new Circle(circleId, rs.getString("name"));
            }
            rs.close();
            ps.close();

            return circle;
        }catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return null;

    }
}


