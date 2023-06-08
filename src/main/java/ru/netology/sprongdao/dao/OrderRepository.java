package ru.netology.sprongdao.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static ru.netology.sprongdao.dao.util.ScriptReader.read;

@Repository
public class OrderRepository {

    private final String SCRIPT_NAME = "select_products.sql";
    private final NamedParameterJdbcTemplate template;

    public OrderRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<String> getProductByCustomerName(String name) {
        String sqlQuery = read(SCRIPT_NAME);
        var parameterSource = new MapSqlParameterSource("name", name);

        return template.query(sqlQuery, parameterSource,
                (rs, column) -> rs.getString("product_name"));
    }
}