import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class controller {
    private view view;
    private model model;
    private Scanner scanner = new Scanner(new File("loggexample.txt"));
    public controller() throws IOException {
        view = new view();
        model = new model();

        Action execute = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                model.saveInput(view.getInput().getText());
                view.getInput().setText("");
                view.getLoggTextPane().setText(model.getMessageListAsString());
            }
        };

        JFrame frame = new JFrame("Logg");
        frame.setContentPane(view.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);
        view.getLoggTextPane().setEditable(false);
        view.getInput().requestFocus();
        view.getInput().getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "doSomething");
        view.getInput().getActionMap().put("doSomething", execute);

        view.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Saving");
                try {
                    FileWriter myWriter = new FileWriter("filename.txt");
                    myWriter.write("Files in Java might be tricky, but it is fun enough!");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException ex) {
                    System.out.println("An error occurred.");
                    ex.printStackTrace();
                }
            }
        });

        view.getLoadButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.clearLogg();
                System.out.println("Loading");
            }
        });
    }

    public static void main(String[] args) throws IOException {
        controller c = new controller();
    }
}
