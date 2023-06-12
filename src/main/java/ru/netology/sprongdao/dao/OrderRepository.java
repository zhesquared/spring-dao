package ru.netology.sprongdao.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static ru.netology.sprongdao.dao.util.ScriptReader.getScript;

@Repository
public class OrderRepository {

    private final NamedParameterJdbcTemplate template;

    public OrderRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<String> getProductByCustomerName(String name) {
        String sqlQuery = getScript();
        var parameterSource = new MapSqlParameterSource("name", name);

        return template.queryForList(sqlQuery, parameterSource, String.class);
    }
}