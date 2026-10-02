/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
package bean;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class jPBieuDoTK extends JFrame {

    public jPBieuDoTK(String title) {
        super(title);

        // Create dataset
        CategoryDataset dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Biểu đồ cột",
                "Danh mục",
                "Giá trị",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize the chart (optional)
        // CategoryPlot plot = chart.getCategoryPlot();
        // plot.setRangeGridlinePaint(Color.BLACK);

        // Add the chart to a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1, "Loại 1", "Danh mục 1");
        dataset.addValue(4, "Loại 1", "Danh mục 2");
        dataset.addValue(3, "Loại 1", "Danh mục 3");
        dataset.addValue(5, "Loại 1", "Danh mục 4");

        dataset.addValue(5, "Loại 2", "Danh mục 1");
        dataset.addValue(7, "Loại 2", "Danh mục 2");
        dataset.addValue(6, "Loại 2", "Danh mục 3");
        dataset.addValue(8, "Loại 2", "Danh mục 4");

        dataset.addValue(4, "Loại 3", "Danh mục 1");
        dataset.addValue(3, "Loại 3", "Danh mục 2");
        dataset.addValue(2, "Loại 3", "Danh mục 3");
        dataset.addValue(3, "Loại 3", "Danh mục 4");

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            jPBieuDoTK example = new jPBieuDoTK("Ví dụ biểu đồ cột");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
*/

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import model.tkDAO;

import java.util.ArrayList;


public class jPBieuDoTK extends JPanel {

    ArrayList<tkDAO> tkk=new ArrayList();
    public jPBieuDoTK(ArrayList<tkDAO> tk,String st) {
        // Tạo dataset
        tkk=tk;
        DefaultCategoryDataset dataset = createDataset();

        // Tạo biểu đồ
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ THỐNG KÊ DOANH THU ",
                st+"",
                "Giá trị/.000",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Tạo panel chứa biểu đồ
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(200, 150));

        // Thêm chartPanel vào JPanel
        this.setLayout(new BorderLayout());
        this.add(chartPanel, BorderLayout.CENTER);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Thêm dữ liệu vào dataset
        
        int x=tkk.size();
     for(int i=0;i<x;i++)
       {
            dataset.addValue(tkk.get(i).getDoanhthu()/1000, "Doanh thu ", tkk.get(i).getNgay()+"");
        dataset.addValue(tkk.get(i).getChitieu()/1000, "Chi tiêu", tkk.get(i).getNgay()+"");
        dataset.addValue((tkk.get(i).getDoanhthu()-tkk.get(i).getChitieu())/1000, "Lợi nhuận",tkk.get(i).getNgay()+"");
       }
        return dataset;
    }

    
    
    
     public static void main(String[] args) {
         
         
           tkDAO doa=new tkDAO();
      ArrayList<tkDAO> dad= doa.listTKNam(2);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ví dụ Biểu Đồ Cột trong JPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new jPBieuDoTK(dad,"--/--"));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
     }
}
