package com.tiens.springdata01.com.tiens.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl implements BaseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public String getStr(String username) {
        String sql="SELECT center_json_log_yb.json FROM center_json_log_yb where center_json_log_yb.username='"+username+"'";
        return jdbcTemplate.queryForObject(sql,String.class);
    }
}
