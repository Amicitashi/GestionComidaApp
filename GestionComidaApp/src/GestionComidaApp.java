import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */

public class GestionComidaApp extends JFrame {
    private JComboBox<String> alimentosComboBox;
    private JButton confirmarButton;
    private List<Alimento> alimentos;

    public GestionComidaApp() {
        super("Gestión de Comida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Aqui se obtienen todos los alimentos de la base de datos
        alimentos = AlimentoDAO.obtenerTodosLosAlimentos();

        // crear y configurar JComboBox con alimentos
        alimentosComboBox = new JComboBox<>();
        actualizarComboBox();

        // botón de confirmación
        confirmarButton = new JButton("Confirmar Selección");
        confirmarButton.addActionListener(e -> confirmarSeleccion());

        // Configurar el diseño de la GUI
        //Vista 
        JPanel panel = new JPanel();
        panel.add(new JLabel("Selecciona un alimento: "));
        panel.add(alimentosComboBox);
        panel.add(confirmarButton);

        add(panel);

        // Listener para mostrar características de los alimentos
        alimentosComboBox.addActionListener(e -> mostrarCaracteristicas());
        setSize(300, 150);
        setLocationRelativeTo(null);
    }

    private void actualizarComboBox() {
        alimentosComboBox.removeAllItems();
        for (Alimento alimento : alimentos) {
            alimentosComboBox.addItem(alimento.getNombre());
        }
    }

    private void confirmarSeleccion() {
        Alimento seleccionado = obtenerAlimentoSeleccionado();
        int opcion = JOptionPane.showConfirmDialog(this, "¿Confirmar selección de " + seleccionado.getNombre() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Selección de " + seleccionado.getNombre() + " confirmada.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void mostrarCaracteristicas() {
        Alimento seleccionado = obtenerAlimentoSeleccionado();
        JOptionPane.showMessageDialog(this, seleccionado.getCaracteristicas(), "Características de " + seleccionado.getNombre(), JOptionPane.INFORMATION_MESSAGE);
    }

    private Alimento obtenerAlimentoSeleccionado() {
        String seleccionado = (String) alimentosComboBox.getSelectedItem();
        for (Alimento alimento : alimentos) {
            if (alimento.getNombre().equals(seleccionado)) {
                return alimento;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestionComidaApp app = new GestionComidaApp();
            app.setVisible(true);
        });
    }
}