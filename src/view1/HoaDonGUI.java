package view1;




import model.CTHDDAO;
import model.HoaDonDAO;
import model.CTHD;
import model.HoaDon;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class HoaDonGUI extends JFrame {

    private JTable hoaDonTable;
    private DefaultTableModel hoaDonTableModel;
    private DefaultListModel<HoaDon> hoaDonListModel;
    private JList<HoaDon> hoaDonJList;
    private JButton refreshButton;
    private JButton viewDetailsButton;
    private JButton createButton;

    private JButton payButton;

    private JButton searchButton;
    private JButton deleteButton;
    private int MaNV;

    public HoaDonGUI(int MaNV) {
        setTitle("Quản lý hóa đơn");
        setSize(800, 600);
     //   setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.MaNV=MaNV;
        initComponents();
        loadHoaDons();
    }

    private void initComponents() {
        hoaDonListModel = new DefaultListModel<>();
        hoaDonJList = new JList<>(hoaDonListModel);
        JScrollPane scrollPane = new JScrollPane(hoaDonJList);

        refreshButton = new JButton("Refresh");
        viewDetailsButton = new JButton("View Details");
        createButton = new JButton("Create New");

        payButton = new JButton("Pay");

        searchButton = new JButton("Search");
        deleteButton = new JButton("Delete");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(refreshButton);
        buttonPanel.add(viewDetailsButton);
        buttonPanel.add(createButton);

        buttonPanel.add(payButton);

        buttonPanel.add(searchButton);
        buttonPanel.add(deleteButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
        // Khởi tạo model cho JTable
        hoaDonTableModel = new DefaultTableModel();
        hoaDonTableModel.addColumn("Số Hóa Đơn");
        hoaDonTableModel.addColumn("Mã Nhân Viên");
        hoaDonTableModel.addColumn("Mã Bàn");
        hoaDonTableModel.addColumn("Ngày Hóa Đơn");
        hoaDonTableModel.addColumn("Tổng Tiền");
        hoaDonTableModel.addColumn("Trạng Thái");

        // Khởi tạo JTable với model
        hoaDonTable = new JTable(hoaDonTableModel);

        // Tạo thanh cuộn cho JTable nếu cần
        JScrollPane tableScrollPane = new JScrollPane(hoaDonTable);

        // Thêm JTable vào giao diện
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadHoaDons();
            }
        });

        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = hoaDonTable.getSelectedRow();
                if (selectedRow != -1) {
                    int soHD = (int) hoaDonTable.getValueAt(selectedRow, 0);
                    // Mở cửa sổ chi tiết hóa đơn
                    CTHDGUI cthdGUI = new CTHDGUI(soHD);
                    cthdGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            // Làm mới danh sách hóa đơn sau khi chi tiết hóa đơn đóng
                            loadHoaDons();
                        }
                    });
                    cthdGUI.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một hóa đơn để xem chi tiết.");
                }
            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                // lấy danh sách mã bàn từ cơ sở dũ liệu
                JComboBox<String> maBanComboBox = new JComboBox<>();
                List<String> maBanList = HoaDonDAO.getMaBanList();
                for (String maBan : maBanList) {
                    maBanComboBox.addItem(maBan);
                }

                Date currentDate = new Date(System.currentTimeMillis());

                JPanel inputPanel = new JPanel(new GridLayout(6, 2));
                
                
                inputPanel.add(new JLabel("Mã Bàn:"));
                inputPanel.add(maBanComboBox);

                int result = JOptionPane.showConfirmDialog(null, inputPanel,
                        "Thêm Hóa Đơn Mới", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        

                        int maBan = Integer.parseInt((String) maBanComboBox.getSelectedItem());

                        // Tạo hóa đơn mới với thông tin từ giao diện
                        HoaDonDAO.createNewHoaDon(MaNV, maBan, currentDate, 0, "chua thanh toan");

                        // Load lại danh sách hóa đơn
                        loadHoaDons();

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số.");
                    }
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo panel để người dùng nhập tiêu chí tìm kiếm
                JPanel searchPanel = new JPanel(new GridLayout(5, 2));
                searchPanel.add(new JLabel("Tìm theo:"));
                JComboBox<String> searchCriteriaComboBox = new JComboBox<>(new String[]{"Mã Hóa Đơn", "Mã Nhân Viên", "Mã Bàn", "Trạng Thái"});
                searchPanel.add(searchCriteriaComboBox);

                searchPanel.add(new JLabel("Giá trị tìm kiếm:"));
                JTextField searchValueField = new JTextField();
                searchPanel.add(searchValueField);

                int result = JOptionPane.showConfirmDialog(null, searchPanel, "Nhập tiêu chí tìm kiếm", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    String searchCriteria = (String) searchCriteriaComboBox.getSelectedItem();
                    String searchValue = searchValueField.getText().trim();

                    if (!searchValue.isEmpty()) {
                        List<HoaDon> searchResults = null;

                        switch (searchCriteria) {
                            case "Mã Hóa Đơn":
                                try {
                                    int soHD = Integer.parseInt(searchValue);
                                    HoaDon hoaDon = HoaDonDAO.getHoaDonById(soHD);
                                    if (hoaDon != null) {
                                        searchResults = List.of(hoaDon);
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Vui lòng nhập mã hóa đơn dưới dạng số.");
                                }
                                break;
                            case "Mã Nhân Viên":
                                searchResults = HoaDonDAO.searchByMaNV(searchValue);
                                break;
                            case "Mã Bàn":
                                searchResults = HoaDonDAO.searchByMaBan(searchValue);
                                break;
                            case "Trạng Thái":
                                searchResults = HoaDonDAO.searchByTrangThai(searchValue);
                                break;
                        }

                        if (searchResults != null && !searchResults.isEmpty()) {
                            // Xóa dữ liệu hiện có trong JTable
                            hoaDonTableModel.setRowCount(0);

                            // Thêm các hóa đơn tìm thấy vào JTable
                            for (HoaDon hoaDon : searchResults) {
                                hoaDonTableModel.addRow(new Object[]{
                                    hoaDon.getSoHD(),
                                    hoaDon.getMaNV(),
                                    hoaDon.getMaBan(),
                                    hoaDon.getNgHD(),
                                    hoaDon.getTongTien(),
                                    hoaDon.getTrangThai()
                                });
                            }

                            // Hiển thị thông báo
                            JOptionPane.showMessageDialog(null, "Đã tìm thấy " + searchResults.size() + " hóa đơn.");
                        } else {
                            // Hiển thị thông báo nếu không tìm thấy hóa đơn
                            JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn với tiêu chí " + searchCriteria + " = " + searchValue);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị tìm kiếm.");
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = hoaDonTable.getSelectedRow();
                if (selectedRow != -1) {
                    int soHD = (int) hoaDonTable.getValueAt(selectedRow, 0);
                    int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa hóa đơn này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        // Xóa hóa đơn trong cơ sở dữ liệu
                        HoaDonDAO.delete(soHD);
                        // Xóa hóa đơn trong JTable
                        hoaDonTableModel.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một hóa đơn để xóa.");
                }
            }
        });

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = hoaDonTable.getSelectedRow();
                if (selectedRow != -1) {
                    int soHD = (int) hoaDonTable.getValueAt(selectedRow, 0);
                    List<CTHD> cthds = CTHDDAO.getCTHDsBySoHD(soHD);
                    HoaDon hoaDon = HoaDonDAO.getHoaDonById(soHD);

                    ThanhToanGUI thanhToanGUI = new ThanhToanGUI();
                    thanhToanGUI.updateData(cthds, hoaDon.getTongTien());
                    thanhToanGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            // Cập nhật trạng thái hóa đơn thành "đã thanh toán"
                            loadHoaDons();
                        }
                    });
                    thanhToanGUI.setVisible(true);

                    // Chọn phương thức thanh toán
                    String[] paymentMethods = {"Tiền mặt", "Thẻ"};
                    String selectedPaymentMethod = (String) JOptionPane.showInputDialog(null, "Chọn phương thức thanh toán:",
                            "Chọn Phương Thức Thanh Toán", JOptionPane.QUESTION_MESSAGE, null, paymentMethods, paymentMethods[0]);

                    if (selectedPaymentMethod != null) {
                        // Xác nhận thanh toán
                        int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xác nhận thanh toán?", "Xác nhận thanh toán", JOptionPane.YES_NO_OPTION);
                        if (confirmation == JOptionPane.YES_OPTION) {
                            // Cập nhật trạng thái hóa đơn
                            HoaDonDAO.updateStatus(soHD, "da thanh toan");

                            // In hóa đơn ra file txt
                            String fileName = "HoaDon_" + soHD + ".txt";
                            try (FileWriter fw = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(fw)) {
                                bw.write("Hóa Đơn Số: " + soHD);
                                bw.newLine();
                                bw.write("Ngày Hóa Đơn: " + hoaDon.getNgHD());
                                bw.newLine();
                                bw.write("Phương thức thanh toán: " + selectedPaymentMethod);
                                bw.newLine();
                                bw.write("Mã Món Ăn\tSố Hóa Đơn\tSố Lượng\tThành Tiền");
                                bw.newLine();
                                for (CTHD cthd : cthds) {
                                    bw.write(cthd.getMaMonAn() + "\t" + cthd.getSoHD() + "\t" + cthd.getSoLuong() + "\t" + cthd.getThanhTien());
                                    bw.newLine();
                                }
                                bw.write("Tổng Tiền: " + hoaDon.getTongTien());
                                bw.newLine();
                                JOptionPane.showMessageDialog(null, "Hóa đơn đã được in ra file: " + fileName);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Lỗi khi in hóa đơn: " + ex.getMessage());
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn phương thức thanh toán.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một hóa đơn để thanh toán.");
                }
            }
        });

        // Thêm các sự kiện xử lý cho các nút khác tương tự
    }

    private void loadHoaDons() {
        // Xóa dữ liệu cũ trong model
        hoaDonTableModel.setRowCount(0);

        // Lấy danh sách hóa đơn từ cơ sở dữ liệu
        List<HoaDon> hoaDons = HoaDonDAO.getAllHoaDons();

        // Thêm hóa đơn vào model của JTable
        for (HoaDon hoaDon : hoaDons) {
            hoaDonTableModel.addRow(new Object[]{
                hoaDon.getSoHD(),
                hoaDon.getMaNV(),
                hoaDon.getMaBan(),
                hoaDon.getNgHD(),
                hoaDon.getTongTien(),
                hoaDon.getTrangThai()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HoaDonGUI(3).setVisible(true);
            }
        });
    }

}
