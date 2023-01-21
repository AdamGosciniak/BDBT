package bdbt_bada_project.SpringApplication;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
public class PracownicyDAO {
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Pracownicy> list(){
        String sql = "SELECT * FROM PRACOWNICY";

        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));

        return listPracownicy;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownicy pracownicy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("nr_pracownika", "imie", "nazwisko", "data_urodzenia",
                "pesel", "plec", "data_zatrudnienia", "numer_telefonu", "email", "numer_konta");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Pracownicy get(int nr_pracownika) {
        Object[] args = {nr_pracownika};
        String sql = "SELECT * FROM PRACOWNICY WHERE nr_pracownika = " + args[0];
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));

        return pracownicy;
    }

    /* Update – aktualizacja danych */
    public void update(Pracownicy pracownicy) {
        String sql = "UPDATE PRACOWNICY SET imie=:imie, nazwisko=:nazwisko, data_urodzenia=:data_urodzenia," +
                " pesel=:pesel, plec=:plec, data_zatrudnienia=:data_zatrudnienia, numer_telefonu=:numer_telefonu, email=:email," +
                " numer_konta=:numer_konta," +
                " nr_adresu=:nr_adresu WHERE nr_pracownika=:nr_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int nr_pracownika) {
        String sql = "DELETE FROM PRACOWNICY WHERE nr_pracownika = ?";
        jdbcTemplate.update(sql, nr_pracownika);
    }

}