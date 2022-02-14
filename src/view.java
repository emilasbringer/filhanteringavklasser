import javax.swing.*;

public class view {
    private JTextField input;
    private JTextPane loggTextPane;
    private JPanel panel;
    private JButton saveButton;
    private JButton loadButton;


    public JPanel getPanel() {
        return panel;
    }

    public JTextField getInput() {
        return input;
    }

    public JTextPane getLoggTextPane() {
        return loggTextPane;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }
}
