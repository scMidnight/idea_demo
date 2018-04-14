package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    private JPanel mainWindow;
    private JTextArea TestView;
    private JTextArea ip;

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        mainWindow = new JPanel();
        mainWindow.setBorder(new EmptyBorder(5,5,5,5));
        mainWindow.setLayout(new BorderLayout(0,0));
        setContentPane(mainWindow);
        TestView = new JTextArea();
        TestView.setText("Ready...");
        mainWindow.add(TestView,BorderLayout.CENTER);
    }

    public void appendText(String in) {
        TestView.append("\n"+in);
    }
}
