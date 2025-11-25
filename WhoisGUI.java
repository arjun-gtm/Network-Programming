import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class WhoisGUI extends JFrame {

    private JTextField inputField;
    private JTextArea resultArea;
    private JButton lookupButton;

    private static final String WHOIS_SERVER = "whois.internic.net";
    private static final int WHOIS_PORT = 43;

    public WhoisGUI() {
        setTitle("Whois Client");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        lookupButton = new JButton("Lookup");

        topPanel.add(inputField, BorderLayout.CENTER);
        topPanel.add(lookupButton, BorderLayout.EAST);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // FIX: ActionListener spelling corrected
        lookupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performWhoisLookup();
            }
        });
    }

    private void performWhoisLookup() {
        String query = inputField.getText().trim();

        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a domain or IP address.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        resultArea.setText("Looking up " + query + "...\n");

        new Thread(() -> {
            try (Socket socket = new Socket(WHOIS_SERVER, WHOIS_PORT);
                 OutputStream output = socket.getOutputStream();
                 InputStream input = socket.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

                // FIX: Wrong syntax → getBytes() must be called on the string
                output.write((query + "\r\n").getBytes());
                output.flush();

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }

                resultArea.setText(response.toString());

            } catch (IOException ex) {
                resultArea.setText("Error: Unable to retrieve Whois information.\n" + ex.getMessage());
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WhoisGUI gui = new WhoisGUI();
            gui.setVisible(true);
        });
    }
}
