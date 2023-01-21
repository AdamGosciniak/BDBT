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
public class ZwierzetaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public ZwierzetaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zwierzeta> list(){
        String sql = "SELECT * FROM zwierzeta";

        List<Zwierzeta> listZwierzeta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zwierzeta.class));
        return listZwierzeta;
    }
    public void save(Zwierzeta zwierzeta) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("Zwierzeta").usingColumns("nr_zwierzecia", "gatunek", "rasa", "rodzaj_karmy", "imie", "data_przyjecia", "wiek", "waga", "data_kastracji");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zwierzeta);
        insert.execute(param);
    }

    public Zwierzeta get(int nr_sprzetu){
        Object[] args = {nr_sprzetu};
        String sql = "SELECT * FROM zwierzeta WHERE nr_zwierzecia" + args[0];
        Zwierzeta zwierzeta = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Zwierzeta.class));

        return zwierzeta;
    }

    public void update(Zwierzeta zwierzeta){
        String sql = "UPDATE zwierzeta SET gatunek=:gatunek, rasa=:rasa, rodzaj_karmy=:rodzaj_karmy, " +
                " imie=:imie, data_przyjecia=:data_przyjecia, wiek=:wiek, waga=:waga WHERE nr_zwierzecia=:nr_zwierzecia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zwierzeta);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_sprzetu){
        String sql = "DELETE FROM zwierzeta WHERE nr_zwierzecia = ?";
        jdbcTemplate.update(sql, nr_sprzetu);
    }
}
