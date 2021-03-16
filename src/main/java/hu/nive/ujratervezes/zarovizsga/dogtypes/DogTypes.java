package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DogTypes {

    private MariaDbDataSource dataSource;

    DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry (String country) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("SELECT `name`,`country` FROM dog_types WHERE country  = ?");
        ) {
            stmt.setString(1, country.toUpperCase(Locale.ROOT));
            return getDogsByPreparedStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    private List<String> getDogsByPreparedStatement(PreparedStatement stmt) {
        List<String> result = new ArrayList<>();
        Collator coll = Collator.getInstance(Locale.ENGLISH);
        coll.setStrength(Collator.PRIMARY);
        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                String name = rs.getString("NAME");
                result.add(name.toLowerCase());
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
        result.sort(coll);
        return result;
    }

}
