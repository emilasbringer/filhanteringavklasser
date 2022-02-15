import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

public class controller {
    private view view;
    private model model;
    private File outputfile = new File("loggexample.txt");
    private Scanner scanner = new Scanner(new File(String.valueOf(outputfile)));
    private PrintWriter writer;
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


        //Save
        view.getSaveButton().addActionListener(e -> {
            System.out.println("Saving");
            view.getLoggTextPane().setText("Saved!");
            try {
                writer = new PrintWriter(String.valueOf(outputfile));
                writer.println(model.getMessageListAsString());
                writer.close();
                System.out.println("Successfully wrote to the savefile.");
            } catch (IOException ex) {
                System.out.println("An error occurred.");
                ex.printStackTrace();
            }
        });

        //Load
        view.getLoadButton().addActionListener(e -> {
            view.getLoggTextPane().setText("");
            model.clearLogg();
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                model.inputDataToArray(nextLine);
            }
            view.getLoggTextPane().setText(model.getMessageListAsString());
            System.out.println("Loading");
        });
    }

    public static void main(String[] args) throws IOException {
        controller c = new controller();
    }
}
