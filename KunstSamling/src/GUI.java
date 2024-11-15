import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GUI extends JFrame
{
    private KunstvaerkSamling kvs;
    private JTextArea displayArea;
    private JPanel buttonPanel;

    public GUI(KunstvaerkSamling kvs)
    {
        this.kvs = kvs;
        setTitle("Art Collection Manager");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        // Create main components
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monaco", Font.PLAIN, 12));
        displayArea.setBackground(Color.WHITE);
        displayArea.setBorder(BorderFactory.createLoweredBevelBorder());

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(new CompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createLineBorder(Color.GRAY)
        ));

        // Button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Create buttons with Mac-style spacing
        addStyledButton("Show All Artworks", () -> executeCommand(kvs::udskrivKunstvaerker));
        addStyledButton("Multiple Composer Songs", () -> executeCommand(kvs::findSangeMedFlereKomponister));
        addStyledButton("Single Composer Songs", () -> executeCommand(kvs::findSangeMedEnKomponist));
        addStyledButton("SMK Paintings", () -> executeCommand(() -> kvs.findMalerierPaaMuseum("Statens Museum for Kunst")));
        addStyledButton("FSM Paintings", () -> executeCommand(() -> kvs.findMalerierPaaMuseum("Fyns Stifts Museum")));
        addStyledButton("Total Pages", () -> executeCommand(kvs::beregnAntalLaesteSider));
        addStyledButton("Book Names", () -> executeCommand(kvs::skrivBogNavn));

        // Layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.EAST);

        setContentPane(mainPanel);
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void executeCommand(Runnable command)
    {
        displayArea.setText("");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        command.run();

        System.out.flush();
        System.setOut(old);
        displayArea.setText(baos.toString());
    }

    private void addStyledButton(String text, Runnable action)
    {
        JButton button = new JButton(text);
        button.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        button.setMargin(new Insets(8, 12, 8, 12));
        button.addActionListener(e -> action.run());
        buttonPanel.add(button);
    }
}