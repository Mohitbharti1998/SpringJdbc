package org.spring.dao;


import org.spring.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.sql.*;
import java.util.List;


@Component
public class JdbcDaoImpl{


    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



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
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    public int getCircleCount(){
        String sql = "Select count(*) from circle";
        return jdbcTemplate.queryForObject(sql,Integer.class).intValue();
    }

    public String getCircleName(int circleId){
        String sql = "Select name from circle where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[] {circleId},String.class);
    }

    public Circle getCircleForId(int circleId){
        String sql = "select * from circle where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{circleId}, new CircleMapper());
    }

    public List<Circle> getAllCircle(){
        String sql = "Select * from circle";
        return jdbcTemplate.query(sql, new CircleMapper());
    }

    private static final class CircleMapper implements RowMapper<Circle>{
        @Override
        public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
            Circle circle = new Circle();
            circle.setId(rs.getInt("id"));
            circle.setName(rs.getString("name"));
            return circle;
        }
    }

//    public void insetCircle(Circle circle){
//        String sql = "insert into circle (Id,Name) values (?,?)";
//        jdbcTemplate.update(sql,new Object[] {circle.getId(),circle.getName()});
//    }

        public void insetCircle(Circle circle){
        String sql = "insert into circle (Id,Name) values (:id,:name)";
        SqlParameterSource nameParameters = new MapSqlParameterSource("id",circle.getId())
                .addValue("name",circle.getName());
        namedParameterJdbcTemplate.update(sql,nameParameters);
    }

}


