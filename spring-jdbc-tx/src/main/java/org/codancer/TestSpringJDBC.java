package org.codancer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TestSpringJDBC {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加修改删除
    @Test
    public void testUpdate() {
        //实现对数据库的添加
//        String sql = "INSERT INTO temp VALUES(NULL, ?, ?, ?)";
//        int rows = jdbcTemplate.update(sql, "东方不败", 20, "未知");
//        System.out.println(rows);
        //数据库的修改
        String sql = "update temp set name=? where id=?";
        int rows = jdbcTemplate.update(sql, "林平之", 1);
        System.out.println(rows);
    }

    //查询: 返回对象
    @Test
    public void selectObj() {
        String sql = "select * from temp where id=?";
        Emp empResult = jdbcTemplate.queryForObject(sql, (rs, rowNumber)->{
            Emp emp = new Emp();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setAge(rs.getInt("age"));
            emp.setSex(rs.getString("sex"));
            return emp;
        }, 1);
        System.out.println(empResult);

        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println(emp);
    }

    //查询：返回list
    @Test
    public void selectList() {
        String sql = "select * from temp";

        List<Emp> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));

        for (Emp emp: result) {
            System.out.println(emp);
        }
    }

    //查询：返回
    @Test
    public void selectValue() {
        String sql = "select count(*) from temp";
        int res = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(res);
    }
}
