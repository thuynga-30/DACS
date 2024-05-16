package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class ChatClient extends JFrame {
    private JTextArea textArea;
    private JTextField textField;
    private JButton sendButton;
    private JLabel nameLabel;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String userName;

    public ChatClient() {
        // Thiết lập JFrame
        setTitle("Chat Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
       
        nameLabel = new JLabel();
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(nameLabel, BorderLayout.NORTH);
        
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        textField = new JTextField(30);
        sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textField.getText();
                if (!message.isEmpty()) {
                    out.println(userName +":"+ message);
                    textArea.append(userName+": " + message + "\n");
                    textField.setText("");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(sendButton);

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);

        userName = JOptionPane.showInputDialog(this, "Enter your name:");
        nameLabel.setText( userName);
        String hostname = "localhost"; // IP: 192.168.1.18
        int port = 12345;
        try {
            socket = new Socket(hostname, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Gửi tên người dùng đến máy chủ
            //out.println(userName);
            new ReadThread().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ReadThread extends Thread {
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    textArea.append(message + "\n");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

  /*  public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatClient();
            }
        });
    }*/
}
