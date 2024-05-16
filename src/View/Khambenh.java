package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class Khambenh extends JFrame {

    private JPanel contentPane;
    private JTextField txtWeight;
    private JTextField txtHeight;
    private JTextField txtBP;
    private JTextField txtBsi;
    private JTextField date;
    private JTextField redate;
    private JTextPane tsb;
    private JTextPane don;
    private JComboBox Blood;
    private JPanel panel;
    private String infor;


    public Khambenh(String infor) {
        setTitle("Thông tin chi tiết");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setBounds(100, 100, 1235, 830);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 10, 1536, 789);
        contentPane.add(panel);
        panel.setLayout(null);

        this.infor = infor;
        initComponents();

        JLabel lblNewLabel_6 = new JLabel("Blood type");
        lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_6.setBounds(254, 179, 92, 20);
        panel.add(lblNewLabel_6);

        Blood = new JComboBox();
        Blood.setModel(new DefaultComboBoxModel(
        new String[]{"O+", "A+", "B+", "AB+", "O-", "A-", "B-", "AB-"}));
        Blood.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        Blood.setBackground(Color.WHITE);
        Blood.setBounds(377, 173, 85, 32);
        panel.add(Blood);

        JLabel lblNewLabel_6_1 = new JLabel("Weight ");
        lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_6_1.setBounds(254, 227, 92, 20);
        panel.add(lblNewLabel_6_1);

        txtWeight = new JTextField();
        txtWeight.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtWeight.setColumns(10);
        txtWeight.setBounds(377, 221, 123, 32);
        panel.add(txtWeight);

        JLabel lblNewLabel_6_1_1 = new JLabel("kg");
        lblNewLabel_6_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_6_1_1.setBounds(522, 233, 53, 20);
        panel.add(lblNewLabel_6_1_1);

        JLabel lblNewLabel_6_1_2 = new JLabel("Height");
        lblNewLabel_6_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_6_1_2.setBounds(830, 227, 102, 20);
        panel.add(lblNewLabel_6_1_2);

        txtHeight = new JTextField();
        txtHeight.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtHeight.setColumns(10);
        txtHeight.setBounds(952, 221, 136, 32);
        panel.add(txtHeight);

        JLabel lblNewLabel_6_1_1_1 = new JLabel("cm");
        lblNewLabel_6_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_6_1_1_1.setBounds(1099, 227, 53, 20);
        panel.add(lblNewLabel_6_1_1_1);

        JLabel lblNewLabel_6_1_3 = new JLabel(" Blood Pressure");
        lblNewLabel_6_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_6_1_3.setBounds(821, 171, 111, 20);
        panel.add(lblNewLabel_6_1_3);

        txtBP = new JTextField();
        txtBP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtBP.setColumns(10);
        txtBP.setBounds(952, 167, 136, 32);
        panel.add(txtBP);

        JLabel lblNewLabel_6_1_3_1 = new JLabel("Diagnosis");
        lblNewLabel_6_1_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_6_1_3_1.setBounds(254, 285, 92, 20);
        panel.add(lblNewLabel_6_1_3_1);

        JButton btnSave = new JButton("Exit");
        btnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Home home= new Home();
        		home.setVisible(true);
        		dispose();
        	}
        });

        btnSave.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSave.setBounds(445, 702, 85, 43);
        panel.add(btnSave);

        JLabel lblNewLabel_6_1_3_1_1 = new JLabel("Prescription");
        lblNewLabel_6_1_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_6_1_3_1_1.setBounds(254, 421, 92, 20);
        panel.add(lblNewLabel_6_1_3_1_1);

        JLabel lblNewLabel_6_1_3_1_2 = new JLabel("Doctor");
        lblNewLabel_6_1_3_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_6_1_3_1_2.setBounds(254, 564, 92, 20);
        panel.add(lblNewLabel_6_1_3_1_2);

        txtBsi = new JTextField();
        txtBsi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtBsi.setColumns(10);
        txtBsi.setBounds(377, 558, 366, 32);
        panel.add(txtBsi);

        date = new JTextField();
        date.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        date.setColumns(10);
        date.setBounds(377, 623, 269, 32);
        panel.add(date);

        JLabel lblNewLabel_6_1_3_1_2_1 = new JLabel("Date");
        lblNewLabel_6_1_3_1_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_6_1_3_1_2_1.setBounds(254, 623, 92, 20);
        panel.add(lblNewLabel_6_1_3_1_2_1);

        redate = new JTextField();
        redate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        redate.setColumns(10);
        redate.setBounds(946, 623, 235, 32);
        panel.add(redate);

        JLabel lblNewLabel_6_1_3_1_2_2 = new JLabel("Re-examination");
        lblNewLabel_6_1_3_1_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_6_1_3_1_2_2.setBounds(821, 623, 111, 20);
        panel.add(lblNewLabel_6_1_3_1_2_2);

        JButton btnExport = new JButton("Export ");
        btnExport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exportDataToFile();
            }
        });
        btnExport.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnExport.setBounds(779, 702, 85, 43);
        panel.add(btnExport);

        don = new JTextPane();
        don.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        don.setBackground(UIManager.getColor("Button.background"));
        don.setBounds(377, 416, 660, 110);
        panel.add(don);

        tsb = new JTextPane();
        tsb.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tsb.setBackground(UIManager.getColor("Button.background"));
        tsb.setBounds(377, 285, 660, 110);
        panel.add(tsb);
        
        JLabel lblNewLabel_6_1_1_1_1 = new JLabel("mmHg");
        lblNewLabel_6_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_6_1_1_1_1.setBounds(1099, 177, 53, 20);
        panel.add(lblNewLabel_6_1_1_1_1);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Khambenh.class.getResource("/Ảnh/Screenshot 2024-04-13 091840.png")));
        lblNewLabel.setBounds(1218, 0, 102, 134);
        panel.add(lblNewLabel);
    }

    private void initComponents() {
        JTextArea textArea = new JTextArea(infor);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textArea.setEditable(false);
        textArea.setBounds(268, 24, 664, 120);
        panel.add(textArea);
    }

    private void exportDataToFile() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Lưu file");
            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                PrintWriter writer = new PrintWriter(filePath);

                // Lưu thông tin infor vào file
                writer.println("Thông tin bệnh nhân:");
                writer.println(infor);
                writer.println();

                // Lưu các thông tin nhập từ giao diện người dùng vào file
                writer.println("Blood Type: " + Blood.getSelectedItem());
                writer.println("Weight: " + txtWeight.getText()+"kg");
                writer.println("Height: " + txtHeight.getText()+"cm");
                writer.println("Blood Pressure: " + txtBP.getText()+" mmHg");
                writer.println("Doctor's Note:: " + tsb.getText());
                writer.println();

                writer.println();

                writer.close();

                JOptionPane.showMessageDialog(this, "Thông tin đã được lưu vào file thành công.");
                Home hm = new Home();
                hm.setVisible(true);
                hm.setExtendedState(JFrame.MAXIMIZED_BOTH);
                dispose();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi lưu file.");
        }
    }
}
