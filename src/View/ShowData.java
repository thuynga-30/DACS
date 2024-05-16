package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.DanhBa;
import Controller.danhBA;

import java.awt.*;
import java.util.List;

public class ShowData extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowData frame = new ShowData();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ShowData() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ DANH BẠ");
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);

        // Call showData method
        showData(danhBA.getInstance().selectAll());
    }

    public void showData(List<DanhBa> danhBaList) {
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Thông tin", "Ảnh đại diện" }
        );
        table.setModel(model);

        for (DanhBa danhBa : danhBaList) {
            // Format information with line breaks using HTML
            String info = "<html><body style=\"background-color: aqua; font-size: 15px; text-align: center;\">"
                    + "<b>Tên:</b> " + danhBa.getTen() + "<br>"
                    + "<b>Năm sinh:</b> " + danhBa.getnS() + "<br>"
                    + "<b>Địa chỉ:</b> " + danhBa.getdC() + "<br>"
                    + "<b>Số điện thoại:</b> " + danhBa.getsDT() + "<br>"
                    + "</body></html>";
            model.addRow(new Object[] { info, danhBa.getAnh() });
        }

        // Set custom renderer for image column
        table.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.setRowHeight(200);
    }

    // Custom TableCellRenderer for displaying images
    class ImageRenderer extends DefaultTableCellRenderer {
        JLabel lbl = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value != null) {
                // Đọc dữ liệu ảnh
                ImageIcon icon = new ImageIcon((byte[]) value);
                Image image = icon.getImage();
                
                // Kiểm tra hướng xoay của ảnh
                int width = image.getWidth(null);
                int height = image.getHeight(null);
                if (width > height) {
                    // Nếu chiều rộng lớn hơn chiều cao, quay ảnh
                    image = image.getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
                } else {
                    // Ngược lại, không cần quay ảnh
                    image = image.getScaledInstance(150, -1, Image.SCALE_SMOOTH);
                }
                
                // Tạo mới ImageIcon từ ảnh đã được chỉnh sửa
                ImageIcon scaledIcon = new ImageIcon(image);
                lbl.setIcon(scaledIcon);
            } else {
                lbl.setIcon(null);
            }
            return lbl;
        }
    }
}