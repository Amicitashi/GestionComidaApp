import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author USER
 */

public class AlimentosTestService {
    private static final String URL = "jdbc:postgresql://localhost:5432/gestion_alimentos";
    private static final String USER = "postgres"; //aqui va tu usuario
    private static final String PASSWORD = "Katharsis"; //aqui tu contraseña

    public static void main(String[] args) {
        insertarAlimentos();
    }

    private static void insertarAlimentos() {
        Alimento[] alimentos = {
            new Alimento("Manzana", "Es una fruta sabrosa y saludable, rica en fibra y vitaminas. Es de color roja y tiene una forma redondeada."),
            new Alimento("Naranja", "Fruta cítrica rica en vitamina C. Es de color naranja, y tiene una forma circular."),
            new Alimento("Plátano", "Fruta de color amarillo, de forma alargada y curva, rica en potasio y fibra."),
            new Alimento("Fresa", "Fruta de color rojo, con semillas diminutas en la superficie, dulce y jugosa."),
            new Alimento("Sandía", "Fruta de color verde por fuera y rojo por dentro, con un alto contenido de agua, refrescante y dulce."),
            new Alimento("Pepino", "Vegetal de color verde, con forma alargada y cilíndrica, de sabor refrescante y crujiente."),
            new Alimento("Tomate", "Fruta de color rojo, de forma redondeada, con gran contenido de licopeno, vitamina C y antioxidantes."),
            new Alimento("Lechuga", "Vegetal de hojas verdes, crujiente y con un sabor suave, ideal para ensaladas."),
            new Alimento("Zanahoria", "Vegetal de color naranja, de forma alargada y cónica, rico en vitamina A y betacarotenos."),
            new Alimento("Pera", "Fruta de color verde o amarillo, con forma ovalada y suave textura, dulce y jugosa."),
            new Alimento("Uva", "Fruta de color morado o verde, en racimos, dulce y refrescante."),
            new Alimento("Piña", "Fruta de color amarillo, con una corona de hojas en la parte superior, de sabor tropical y ácido."),
            new Alimento("Brócoli", "Vegetal de color verde oscuro, con flores pequeñas y apretadas, rico en fibra y vitaminas."),
            new Alimento("Espinaca", "Vegetal de hojas verdes, de sabor ligeramente amargo, con gran contenido de nutrientes."),
            new Alimento("Aguacate", "Fruta de color verde oscuro, con forma ovalada y textura cremosa, rica en grasas saludables."),
            new Alimento("Limón", "Fruta cítrica de color amarillo, de forma ovalada y sabor ácido, rica en vitamina C."),
            new Alimento("Mango", "Fruta de color amarillo o naranja, de forma ovalada y sabor dulce, con una textura cremosa."),
            new Alimento("Kiwi", "Fruta de color verde por dentro, con pequeñas semillas negras, de sabor ácido y ligeramente dulce."),
            new Alimento("Papaya", "Fruta de color naranja, de forma ovalada y sabor dulce, con un alto contenido de vitamina C."),
            new Alimento("Melón", "Fruta de color verde por fuera y amarillo por dentro, de forma redondeada y sabor dulce y refrescante.")
        };

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO alimentos (nombre, caracteristicas) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            for (Alimento alimento : alimentos) {
                statement.setString(1, alimento.getNombre());
                statement.setString(2, alimento.getCaracteristicas());
                statement.executeUpdate();
            }

            System.out.println("Alimentos insertados en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}