package view1;
import model.CTHDDAO;
import model.HoaDonDAO;
import model.CTHD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CTHDGUI extends JFrame {

    private JTable cthdTable;
    private DefaultTableModel cthdTableModel;
    private int soHD;

    public CTHDGUI(int soHD) {
        this.soHD = soHD;
        setTitle("Chi Tiết Hóa Đơn - Số Hóa Đơn: " + soHD);
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        loadCTHDs();
    }

    private void initComponents() {
        cthdTableModel = new DefaultTableModel();
        cthdTableModel.addColumn("Mã Món Ăn");
        cthdTableModel.addColumn("Số Hóa Đơn");
        cthdTableModel.addColumn("Số Lượng");
        cthdTableModel.addColumn("Thành Tiền");

        cthdTable = new JTable(cthdTableModel);
        JScrollPane scrollPane = new JScrollPane(cthdTable);

        JButton updateButton = new JButton("Update");
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete"); // Thêm button Xóa

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCTHD();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCTHD();
            }
        });
        deleteButton.addActionListener(new ActionListener() { // Xử lý sự kiện khi button Xóa được nhấn
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCTHD();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Cập nhật tổng tiền của hóa đơn khi cửa sổ đóng
                HoaDonDAO.updateTotalAmount(soHD);
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(updateButton);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadCTHDs() {
        cthdTableModel.setRowCount(0);
        List<CTHD> cthds = CTHDDAO.getCTHDsBySoHD(soHD);
        for (CTHD cthd : cthds) {
            cthdTableModel.addRow(new Object[]{
                cthd.getMaMonAn(),
                cthd.getSoHD(),
                cthd.getSoLuong(),
                cthd.getThanhTien()
            });
        }
    }

    private void updateCTHD() {
        int selectedRow = cthdTable.getSelectedRow();
        if (selectedRow != -1) {
            int maMonAn = (int) cthdTable.getValueAt(selectedRow, 0);
            int newSoLuong = Integer.parseInt(JOptionPane.showInputDialog("Nhập số lượng mới:"));

            // Lấy giá của món ăn từ cơ sở dữ liệu
            int giaMonAn = CTHDDAO.getGiaMonAn(maMonAn);

            // Tính toán thành tiền mới
            int newThanhTien = giaMonAn * newSoLuong;

            // Cập nhật chi tiết hóa đơn
            CTHD cthd = new CTHD();
            cthd.setMaMonAn(maMonAn);
            cthd.setSoHD(soHD);
            cthd.setSoLuong(newSoLuong);
            cthd.setThanhTien(newThanhTien);

            CTHDDAO.update(cthd);

            // Cập nhật tổng tiền của hóa đơn
            HoaDonDAO.updateTotalAmount(soHD);

            // Làm mới danh sách chi tiết hóa đơn sau khi cập nhật
            loadCTHDs();

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(null, "Cập nhật chi tiết hóa đơn thành công.");
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một chi tiết hóa đơn để cập nhật.");
        }
    }

    private void addCTHD() {
        // Tạo combobox để chọn mã món ăn từ cơ sở dữ liệu
        JComboBox<String> maMonAnComboBox = new JComboBox<>();
        List<String> maMonAnList = CTHDDAO.getAllMaMonAn(); // Lấy danh sách mã món ăn từ cơ sở dữ liệu
        for (String maMonAn : maMonAnList) {
            maMonAnComboBox.addItem(maMonAn);
        }

        JTextField soLuongField = new JTextField(10);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Mã Món Ăn:"));
        inputPanel.add(maMonAnComboBox);
        inputPanel.add(new JLabel("Số Lượng:"));
        inputPanel.add(soLuongField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Thêm Chi Tiết Hóa Đơn", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                // Lấy mã món ăn từ combobox
                String selectedMaMonAn = (String) maMonAnComboBox.getSelectedItem();
                int maMonAn = Integer.parseInt(selectedMaMonAn);
                int soLuong = Integer.parseInt(soLuongField.getText());

                // Lấy giá của món ăn từ cơ sở dữ liệu
                int giaMonAn = CTHDDAO.getGiaMonAn(maMonAn);

                // Kiểm tra xem chi tiết hóa đơn với mã món ăn đã tồn tại hay chưa
                boolean exists = false;
                for (int i = 0; i < cthdTableModel.getRowCount(); i++) {
                    if ((int) cthdTableModel.getValueAt(i, 0) == maMonAn) {
                        // Cập nhật số lượng và thành tiền
                        int currentSoLuong = (int) cthdTableModel.getValueAt(i, 2);
                        int newSoLuong = currentSoLuong + soLuong;
                        int newThanhTien = giaMonAn * newSoLuong;

                        // Cập nhật trong bảng
                        cthdTableModel.setValueAt(newSoLuong, i, 2);
                        cthdTableModel.setValueAt(newThanhTien, i, 3);

                        // Cập nhật trong cơ sở dữ liệu
                        CTHD updatedCTHD = new CTHD();
                        updatedCTHD.setMaMonAn(maMonAn);
                        updatedCTHD.setSoHD(soHD);
                        updatedCTHD.setSoLuong(newSoLuong);
                        updatedCTHD.setThanhTien(newThanhTien);

                        CTHDDAO.update(updatedCTHD);
                        exists = true;
                        break;
                    }
                }

                if (!exists) {
                    // Tính toán thành tiền
                    int thanhTien = giaMonAn * soLuong;

                    // Tạo chi tiết hóa đơn mới và lưu vào cơ sở dữ liệu
                    CTHD newCTHD = new CTHD();
                    newCTHD.setMaMonAn(maMonAn);
                    newCTHD.setSoHD(soHD);
                    newCTHD.setSoLuong(soLuong);
                    newCTHD.setThanhTien(thanhTien);

                    CTHDDAO.createNewCTHD(maMonAn, soHD, soLuong, thanhTien);

                    // Thêm chi tiết hóa đơn mới vào bảng
                    cthdTableModel.addRow(new Object[]{
                        newCTHD.getMaMonAn(),
                        newCTHD.getSoHD(),
                        newCTHD.getSoLuong(),
                        newCTHD.getThanhTien()
                    });
                }

                // Cập nhật tổng tiền của hóa đơn
                HoaDonDAO.updateTotalAmount(soHD);

                // Hiển thị thông báo thành công
                JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn thành công.");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số.");
            }
        }
    }

    private void deleteCTHD() { // Phương thức xử lý khi button Xóa được nhấn
        int selectedRow = cthdTable.getSelectedRow();
        if (selectedRow != -1) {
            int maMonAn = (int) cthdTable.getValueAt(selectedRow, 0);
            int soHD = (int) cthdTable.getValueAt(selectedRow, 1);

            CTHDDAO.delete(maMonAn, soHD);
            loadCTHDs(); // Load lại danh sách CTHD sau khi xóa
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một chi tiết hóa đơn để xóa.");
        }
    }

}
