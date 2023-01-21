package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KlatkiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public KlatkiDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klatki> list(){
        String sql = "SELECT * FROM klatki";

        List<Klatki> listKlatki = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klatki.class));
        return listKlatki;
    }
    public void save(Klatki klatki) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("Klatki").usingColumns("nr_klatki", "powierzchnia", "pojemnosc", "rodzaj_zwierzat");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klatki);
        insert.execute(param);
    }

    public Klatki get(int nr_klatki){
        Object[] args = {nr_klatki};
        String sql = "SELECT * FROM klatki WHERE nr_klatki" + args[0];
        Klatki klatki = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klatki.class));

        return klatki;
    }

    public void update(Klatki klatki){
        String sql = "UPDATE klatki SET powierzchnia=:powierzchnia, pojemnosc=:pojemnosc," +
                " rodzaj_zwierzat=:rodzaj_zwierzat WHERE nr_klatki=:nr_klatki";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klatki);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_klatki){
        String sql = "DELETE FROM klatki WHERE nr_klatki = ?";
        jdbcTemplate.update(sql, nr_klatki);
    }
}

