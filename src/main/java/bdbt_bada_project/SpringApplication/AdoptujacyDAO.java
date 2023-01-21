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
public class AdoptujacyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public AdoptujacyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adoptujacy> listUser(){
        String sql = "SELECT * FROM adoptujacy WHERE nr_adoptujacego = 1";

        List<Adoptujacy> listAdoptujacy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adoptujacy.class));
        return listAdoptujacy;
    }
    public List<Adoptujacy> listAdmin(){
        String sql = "SELECT * FROM adoptujacy";

        List<Adoptujacy> listAdoptujacy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adoptujacy.class));
        return listAdoptujacy;
    }

    public void save(Adoptujacy Adoptujacy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Zwierzeta").usingColumns("Nr_zwierzecia", "Gatunek", "Rasa", "Rodzaj_karmy", "Imie", "Data_przyjecia", "Wiek", "Waga", "Data_kastracji", "Nr_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Adoptujacy);
        insertActor.execute(param);
    }

    public Adoptujacy get(int nr_adoptujacego){
        Object[] args = {nr_adoptujacego};
        String sql = "SELECT * FROM adoptujacy WHERE nr_adoptujacego" + args[0];
        Adoptujacy Adoptujacy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adoptujacy.class));

        return Adoptujacy;
    }

    public void update(Adoptujacy Adoptujacy){
        String sql = "UPDATE adoptujacy SET imie=:imie, nazwisko=:nazwisko, pesel=:pesel, nr_telefonu=:nr_telefonu," +
                " email=:email, nr_adresu=:nr_adresu WHERE nr_adoptujacego=:nr_adoptujacego";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Adoptujacy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_adoptujacego){
        String sql = "DELETE FROM adoptujacy WHERE nr_adoptujacego = ?";
        jdbcTemplate.update(sql, nr_adoptujacego);
    }
}