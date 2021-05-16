package database;

import model.Wijn;

import javax.swing.text.DateFormatter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class WijnDAO extends AbstractDAO {

    public WijnDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public ArrayList<Wijn> getWijnGoedkoperDanPrijs(double prijs) {
        String sql = "SELECT wijnnaam, brouwDatum, prijs, bewaarbaar FROM wijn WHERE prijs < ?";
        ArrayList<Wijn> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getStatement(sql);
            preparedStatement.setDouble(1, prijs);
            ResultSet resultSet = executeSelectPreparedStatement(preparedStatement);
            while (resultSet.next()) {
                String wijnnaam = resultSet.getString("wijnnaam");
                LocalDate datum = Date.valueOf(resultSet.getString("brouwDatum")).toLocalDate() ;
                double wijnprijs = resultSet.getDouble("prijs");
                boolean bewaarbaar = resultSet.getBoolean("bewaarbaar");
                result.add(new Wijn(wijnnaam, datum, wijnprijs, bewaarbaar));
            }
        } catch (SQLException sqlException) {
            System.out.println("SQL error " + sqlException.getMessage());
        }
        return result;
    }

}
