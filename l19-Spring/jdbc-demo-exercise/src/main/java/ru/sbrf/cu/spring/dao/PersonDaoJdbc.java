package ru.sbrf.cu.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.sbrf.cu.spring.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class PersonDaoJdbc implements PersonDao {
    private final NamedParameterJdbcOperations jdbc;

    public PersonDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public int count() {
        return jdbc.getJdbcOperations().queryForObject("select count(*) from PERSONS", Integer.class);
    }

    @Override
    public void insert(Person person) {
        jdbc.getJdbcOperations().update("insert into persons values (?,?)", person.getId(), person.getName());
    }

    @Override
    public long insert2(Person person) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", person.getName());
        KeyHolder kh = new GeneratedKeyHolder();
        jdbc.update("insert into persons (`name`) values (:name)", params, kh);
        return kh.getKey().longValue();
    }

    @Override
    public Person getById(long id){
        return jdbc.getJdbcOperations().queryForObject("select * from persons where id = ?", new Object[]{id}, new PersonMapper());
    }

    @Override
    public Person getByName(String name){
        return jdbc.getJdbcOperations().queryForObject("select * from persons where name = ?", new Object[]{name}, new PersonMapper());
    }

    @Override
    public void deleteById(long id){
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbc.update("delete from persons where id = :id", params);
    }

    class PersonMapper implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person(
                    resultSet.getLong("id"),
                    resultSet.getString("name")
            );
            return person;
        }
    }
}
