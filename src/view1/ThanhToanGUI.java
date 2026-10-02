package view1;
import model.HoaDonDAO;
import model.CTHD;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ThanhToanGUI extends JFrame {
    private JTable chiTietTable;
    private DefaultTableModel chiTietTableModel;
    private JLabel tongTienLabel;
    private int soHD;
    public  ThanhToanGUI(int soHD)
    {   this.soHD= soHD;
    }   

    public ThanhToanGUI() {
        setTitle("Thanh Toán");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        chiTietTableModel = new DefaultTableModel();
        chiTietTableModel.addColumn("Mã Món Ăn");
        chiTietTableModel.addColumn("Số Lượng");
        chiTietTableModel.addColumn("Thành Tiền");

        chiTietTable = new JTable(chiTietTableModel);
        JScrollPane scrollPane = new JScrollPane(chiTietTable);

        tongTienLabel = new JLabel("Tổng Tiền: ");

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(tongTienLabel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
          addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Cập nhật trạng thái hóa đơn thành "đã thanh toán"
                HoaDonDAO.updateStatus(soHD, "da thanh toan");
            }
        });
         
    }

    public void updateData(List<CTHD> cthds, float tongTien) {
        chiTietTableModel.setRowCount(0);
        for (CTHD cthd : cthds) {
            chiTietTableModel.addRow(new Object[]{
                cthd.getMaMonAn(),
                cthd.getSoLuong(),
                cthd.getThanhTien()
            });
        }
        tongTienLabel.setText("Tổng Tiền: " + tongTien);
    }
}