package View;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.util.List;
import Model.DanhBa;
import Database.*;
import Controller.FileTypeFilter;
import Controller.danhBA;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.border.MatteBorder;
import javax.swing.plaf.multi.MultiInternalFrameUI;

public class Home extends JFrame {

    private JPanel contentPane;
    private JPanel Menu;
    private JPanel home;
    private JPanel profile;
    private JButton btnHome;
    private JButton btnPhr;
    private JButton btnProfile;
    private JPanel phr;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JTable phrTable;
    private JLabel menu;
    private JLabel avatar;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_6;
    private JTable profileTable;
    private JTextField phone;
    private JTextField address;
    private JTextField year;
    private JTextField name;
    private JButton btnSave;
    String anh="";
    String driver ="org.postgresql.Driver";
    String url = "jdbc:postgresql://localhost:5432/Java" ;
    String username= "postgres" ;
    String password = "123" ;
    Connection con ;
    ResultSet rs;
    Statement st;
    public Home() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        Menu = new JPanel();
        Menu.setBounds(-3, 0, 310, 871);
        Menu.setBackground(new Color(59, 178, 213));
        contentPane.add(Menu);
        Menu.setLayout(null);

        btnHome = new JButton("HOME");
        btnHome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnHome.setBackground(new Color(255, 255, 255));
        btnHome.setIcon(new ImageIcon(Home.class.getResource("/Ảnh/snapedit_1710650161378.png")));
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home.setVisible(true);
                profile.setVisible(false);
                phr.setVisible(false); // Đảm bảo panel phr bị ẩn đi
            }
        });
        btnHome.setBounds(62, 312, 188, 59);
        Menu.add(btnHome);

        btnPhr = new JButton("PHR");
        btnPhr.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnPhr.setBackground(new Color(255, 255, 255));
        btnPhr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home.setVisible(false);
                profile.setVisible(false);
                phr.setVisible(true); 
            }
        });
        btnPhr.setBounds(62, 502, 188, 59);
        Menu.add(btnPhr);

        btnProfile = new JButton("PROFILE");
        btnProfile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnProfile.setBackground(new Color(255, 255, 255));
        btnProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home.setVisible(false);
                profile.setVisible(true);
                phr.setVisible(false);
            }
        });
        btnProfile.setBounds(62, 407, 188, 59);
        Menu.add(btnProfile);

        JButton btnPhr_1 = new JButton("");
        btnPhr_1.setBackground(new Color(89, 191, 240));
        btnPhr_1.setIcon(new ImageIcon(Home.class.getResource("/Ảnh/snapedit_1710344305319.png")));
        btnPhr_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LogIn lg = new LogIn();
        		lg.setVisible(true);
        		dispose();
        		
        	}
        });
        btnPhr_1.setBounds(62, 717, 67, 71);
        Menu.add(btnPhr_1);
        int width=313;
        int height=1000;
        JLabel close = new JLabel("");
        close.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		closeBar();
        	}

       //tạo luồng chạy song song với luông chính
        	private void closeBar() {
				// TODO Auto-generated method stub
        		new Thread(new Runnable() {
        			
        			@Override
        			public void run() {
        				
        				for (int i=width; i>0;i--) {
        					Menu.setSize(i,height); //
        					try {
        						//mở từ từ
        						Thread.sleep(2);
        					} catch (InterruptedException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
        				}
        				
        			}
        		}).start();
				
			}


	
        });
 
        close.setIcon(new ImageIcon(Home.class.getResource("/Ảnh/snapedit_1711641684894.png")));
        close.setBounds(265, 0, 45, 42);
        Menu.add(close);
        
        lblNewLabel_4 = new JLabel("HEALTHTRACK");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
        lblNewLabel_4.setBounds(0, 220, 315, 82);
        Menu.add(lblNewLabel_4);
        
        lblNewLabel = new JLabel("EXIT");
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel.setBounds(151, 745, 61, 27);
        Menu.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/Ảnh/snapedit_1710164001351.png")));
        lblNewLabel_1.setBounds(47, 20, 208, 171);
        Menu.add(lblNewLabel_1);
        
        JButton btnContact = new JButton("CONTACT");
        btnContact.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                      ChatClient chatClient= new ChatClient();
                      chatClient.setVisible(true);
                    }
        		});
        	}
        });
        btnContact.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnContact.setBackground(Color.WHITE);
        btnContact.setBounds(62, 607, 188, 59);
        Menu.add(btnContact);

        JPanel HOME = new JPanel();
        HOME.setBounds(308, 0, 1284, 924);
        HOME.setBackground(new Color(255, 255, 255));
        contentPane.add(HOME);
        HOME.setLayout(new CardLayout(0, 0));

        home = new JPanel();
        home.setBackground(new Color(255, 255, 255));
        HOME.add(home, "name_2083268778166700");
        home.setLayout(null);
        
        lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBounds(360, 386, 543, 429);
        lblNewLabel_5.setIcon(new ImageIcon(Home.class.getResource("/Ảnh/ee999d84402e693dd702d8c402810343.png")));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setForeground(Color.BLACK);
        lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 35));
        home.add(lblNewLabel_5);
        
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/Ảnh/snapedit_1712819932235.png")));
        lblNewLabel_2.setBounds(501, 0, 265, 301);
        home.add(lblNewLabel_2);

        profile = new JPanel();
        profile.setBackground(Color.WHITE);
        HOME.add(profile, "name_2083268793865000");
        
      
        profile.setLayout(null);
        
        phone = new JTextField();
        phone.setBounds(194, 222, 205, 41);
        phone.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        phone.setColumns(10);
        profile.add(phone);
        
        JLabel lblSt = new JLabel("PhoneNumber");
        lblSt.setBounds(60, 222, 102, 26);
        lblSt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        profile.add(lblSt);
        
        JLabel lblDanhB = new JLabel("Address");
        lblDanhB.setBounds(60, 159, 61, 16);
        lblDanhB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        profile.add(lblDanhB);
        
        address = new JTextField();
        address.setBounds(194, 154, 289, 41);
        address.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        address.setColumns(10);
        profile.add(address);
        
        year = new JTextField();
        year.setBounds(194, 93, 205, 41);
        year.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        year.setColumns(10);
        profile.add(year);
        
        name = new JTextField();
        name.setBounds(194, 36, 289, 41);
        name.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        name.setColumns(10);
        profile.add(name);
        
        JLabel lblNewLabel_3 = new JLabel("FullName");
        lblNewLabel_3.setBounds(60, 41, 61, 16);
        lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        profile.add(lblNewLabel_3);
        
        JLabel lblNmSinh = new JLabel("Year of birth ");
        lblNmSinh.setBounds(60, 93, 87, 26);
        lblNmSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        profile.add(lblNmSinh);
        
        avatar = new JLabel("");
        avatar.setBounds(886, 23, 212, 219);
        avatar.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
        profile.add(avatar);
        
        JLabel lblnh = new JLabel("Avatar");
        lblnh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblnh.setBounds(809, 40, 111, 16);
        profile.add(lblnh);
        
        JButton btnUpload = new JButton("Upload");
        btnUpload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setDialogTitle("ADD IMAGE");
                jFileChooser.setMultiSelectionEnabled(false);
                jFileChooser.setFileFilter(new FileTypeFilter(".jpg",".JPG"));
                jFileChooser.setFileFilter(new FileTypeFilter(".gif",".GIF"));
                jFileChooser.setFileFilter(new FileTypeFilter(".png",".PNG"));
                int result = jFileChooser.showOpenDialog(null);

                if(result ==JFileChooser.APPROVE_OPTION) {
                    File file = jFileChooser.getSelectedFile();
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    // Kích thước tối đa của hình ảnh trên khung hình
                    // rộng= 130; cao=140
                    int maxWidth = 211;
                    int maxHeight = 219;
                    // Thích ứng kích thước của hình ảnh
                    Image img = icon.getImage();
                    Image newImg = img.getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(newImg);
                    avatar.setIcon(icon);
                    anh = file.getAbsolutePath().replace("/","//");
                }
            }
        });
        btnUpload.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnUpload.setBounds(760, 101, 117, 29);
        profile.add(btnUpload);
        
        JButton btnShow = new JButton("Show");
        btnShow.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ShowData s =new ShowData();
        		s.setVisible(true);
        	}
        });
        btnShow.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnShow.setBounds(760, 155, 117, 29);
        profile.add(btnShow);

        phr = new JPanel();
        phr.setBackground(new Color(255, 255, 255));
        HOME.add(phr, "name_2083268808146200");
        phr.setLayout(null);
        
        menu = new JLabel("MENU");
        menu.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menu.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		openBar();
        	}

			private void openBar() {
				// TODO Auto-generated method stub
				new Thread(new Runnable() {
        			
        			@Override
        			public void run() {
        				
        				for (int i=0; i<width;i++) {
        					Menu.setSize(i,height);
        					try {
        						Thread.sleep(5);
        					} catch (InterruptedException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
        				}
        				
        			}
        		}).start();
				
			}
        });
        menu.setIcon(new ImageIcon(Home.class.getResource("/Ảnh/snapedit_1711638425607.png")));
        menu.setBounds(96, 10, 106, 50);
        contentPane.add(menu);
        
        lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon(Home.class.getResource("/Ảnh/443ded81f00faef70fd99070f9017ac4.jpg")));
        lblNewLabel_6.setBounds(8, 395, 299, 284);
        contentPane.add(lblNewLabel_6);

        // Gọi phương thức showData
        showData(danhBA.getInstance().selectAll());
    }

    public void showData(List<DanhBa> danhBaList) {
        DefaultTableModel profileModel = new DefaultTableModel(
                new Object[][] {
      
                },
                new String[] { "Information", "Avatar" }
        );
        profileTable = new JTable(profileModel);

   	     profileTable.getColumnModel().getColumn(0).setPreferredWidth(600);
   	     profileTable.getColumnModel().getColumn(1).setPreferredWidth(50);
   
   	     profileTable.setRowHeight(10);
   	
   	     // Đặt font cho bảng
   	     profileTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
   
           
           JScrollPane profileScrollPane = new JScrollPane(profileTable);
           profileScrollPane.setBounds(0, 340, 1404, 647);
           profile.setLayout(null);

           profile.add(profileScrollPane);
        DefaultTableModel phrModel = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Information", "Avatar"}
        );
        phrTable = new JTable(phrModel);
    
        JScrollPane phrScrollPane = new JScrollPane(phrTable);
        phrScrollPane.setBounds(0, 0, 1483, 845);
        phr.setLayout(null);
        phr.add(phrScrollPane);
      
        

        for (DanhBa danhBa : danhBaList) {
            // Định dạng thông tin với các dòng mới
            String info = " Name: " + danhBa.getTen() + "\n"
                    + " Year of Birth: " + danhBa.getnS() + "\n"
                    + " Address: " + danhBa.getdC() + "\n"
                    + " Phone Number: " + danhBa.getsDT();

            // Thêm dữ liệu vào cả hai bảng profile và phr
            profileModel.addRow(new Object[] { info, danhBa.getAnh() });
            phrModel.addRow(new Object[] { info, danhBa.getAnh() });
        }
        phrTable.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
        phrTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        phrTable.setRowHeight(200);
        phrTable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int selectedRow = phrTable.getSelectedRow();
                if (selectedRow != -1) {
                	  String info = (String) phrTable.getValueAt(selectedRow, 0);
                    Khambenh frameKhambenh= new Khambenh(info);
                    frameKhambenh.setVisible(true);
                }
        	}
        });
        profileTable.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
        profileTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        profileTable.setRowHeight(200);
        
        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName(driver);
                    con = DriverManager.getConnection(url, username, password);
                    String sql = "INSERT INTO public.\"danhBa\"(\"Name\", \"Nam_Sinh\", \"Dia_Chi\", \"sDT\", \"Anh\") VALUES (?, ?, ?, ?, ?);";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, name.getText());
                    ps.setInt(2, Integer.parseInt(year.getText())); 
                    ps.setString(3, address.getText());
                    ps.setString(4, phone.getText());
                    
                    // Đọc dữ liệu từ tệp ảnh và chuyển đổi thành mảng byte
                    File file = new File(anh);
                    FileInputStream fis = new FileInputStream(file);
                    byte[] imageData = new byte[(int) file.length()];
                    fis.read(imageData);
                    fis.close();
                    
                    // Thiết lập giá trị bytea cho cột "Anh"
                    ps.setBytes(5, imageData);
                    
                    int rowsAffected = ps.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Save successfully!");
                        
                        // Select dữ liệu mới sau khi lưu thành công
                        String selectQuery = "SELECT * FROM public.\"danhBa\"";
                        Statement selectStatement = con.createStatement();
                        ResultSet resultSet = selectStatement.executeQuery(selectQuery);
                        
                        // Xóa dữ liệu cũ trong bảng
                        DefaultTableModel profileModel = (DefaultTableModel) profileTable.getModel();
                        DefaultTableModel phrModel = (DefaultTableModel) phrTable.getModel();
                        profileModel.setRowCount(0);
                        phrModel.setRowCount(0);
                        
                        
                        // Hiển thị dữ liệu mới trong bảng
                        while (resultSet.next()) {
                            // Lấy thông tin từ ResultSet
                            String info = " Name: " + resultSet.getString("Name") + "\n"
                                    + " Year of Birth: " + resultSet.getInt("Nam_Sinh") + "\n"
                                    + " Address: " + resultSet.getString("Dia_Chi") + "\n"
                                    + " Phone Number: " + resultSet.getString("sDT");
                            byte[] avatarData = resultSet.getBytes("Anh");
                            
                            // Thêm dòng mới vào bảng
                            profileModel.addRow(new Object[] { info, avatarData });
                            phrModel.addRow(new Object[] { info, avatarData });
                        }
                        name.setText("");
                        phone.setText("");
                        address.setText("");
                        year.setText("");
                        avatar.setIcon(null);
                       // Đóng ResultSet và Statement
                      
                        resultSet.close();
                        selectStatement.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Save failed!");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            }
        });
        btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnSave.setBounds(520, 301, 117, 29);
        profile.add(btnSave);
    }

    // Trình kết xuất tùy chỉnh cho việc hiển thị hình ảnh
    class ImageRenderer extends DefaultTableCellRenderer {
        JLabel lbl = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value != null) {
                // Đọc dữ liệu hình ảnh
                ImageIcon icon = new ImageIcon((byte[]) value);
                Image image = icon.getImage();

                // Kiểm tra hướng xoay của hình ảnh
                int width = image.getWidth(null);
                int height = image.getHeight(null);
                if (width > height) {
                    // Nếu chiều rộng lớn hơn chiều cao, quay ảnh
                    image = image.getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
                } else {
                    // Ngược lại, không cần quay ảnh
                    image = image.getScaledInstance(150, -1, Image.SCALE_SMOOTH);
                }

                // Tạo mới ImageIcon từ hình ảnh đã được chỉnh sửa
                ImageIcon scaledIcon = new ImageIcon(image);
                lbl.setIcon(scaledIcon);
            } else {
                lbl.setIcon(null);
            }
            return lbl;
        }
    }
}