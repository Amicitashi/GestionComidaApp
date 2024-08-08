/**
 *
 * @author USER
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlimentoDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/gestion_alimentos";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Katharsis";

    public static List<Alimento> obtenerTodosLosAlimentos() {
        List<Alimento> alimentos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM alimentos")) {
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String caracteristicas = resultSet.getString("caracteristicas");
                Alimento alimento = new Alimento(nombre, caracteristicas);
                alimentos.add(alimento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alimentos;
    }

    public static void guardarAlimento(Alimento alimento) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO alimentos (nombre, caracteristicas) VALUES (?, ?)")) {
            statement.setString(1, alimento.getNombre());
            statement.setString(2, alimento.getCaracteristicas());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}