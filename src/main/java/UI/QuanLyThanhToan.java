package UI;

import dao.DKDichVuDAO;
import dao.DatPhongDAO;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.PhongDAO;
import dao.ThanhToanDAO;
import entity.DKDichVu;
import entity.DatPhong;
import entity.NhanVien;
import entity.Phong;
import entity.ThanhToan;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import utils.Auth;
import utils.JDBCHelper;
import utils.MsgBox;
import utils.XDate;

/**
 *
 * @author USUS
 */
public class QuanLyThanhToan extends javax.swing.JDialog {

    /**
     * Creates new form QuanLyThanhToan2
     */
    public QuanLyThanhToan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    public QuanLyThanhToan(java.awt.Frame parent, boolean modal, String makh, int ngayo, String loaiPhong, Date ngaydat, Date ngayTra) {
        super(parent, modal);;
        initComponents();
        init(makh, ngayo, loaiPhong, ngaydat, ngayTra);
        btnIn.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        tabCapNhat = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMaDP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaDK = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtLoaiPhong = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNgayTra = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNgayDat = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTienPhong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNgayO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTienCoc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTienDV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtThanhToan = new javax.swing.JTextField();
        btnTao = new javax.swing.JButton();
        btnIn = new javax.swing.JButton();
        tabDanhSach = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThanhToan = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 54, 230));

        tabs.setBackground(new java.awt.Color(255, 209, 179));

        tabCapNhat.setBackground(new java.awt.Color(128, 157, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã nhân viên");

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(128, 157, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN CHUNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 255));
        jLabel5.setText("Mã đặt phòng");

        txtMaDP.setEditable(false);
        txtMaDP.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Mã đăng ký");

        txtMaDK.setEditable(false);
        txtMaDK.setEnabled(false);
        txtMaDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDKActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 255));
        jLabel9.setText("Mã khách hàng");

        txtMaKH.setEditable(false);
        txtMaKH.setEnabled(false);

        txtLoaiPhong.setEditable(false);
        txtLoaiPhong.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 255));
        jLabel11.setText("Loại phòng");

        txtNgayTra.setEditable(false);
        txtNgayTra.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 255));
        jLabel14.setText("Ngày trả");

        txtNgayDat.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 255, 255));
        jLabel13.setText("Ngày đặt");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaDP, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKH)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(txtMaDK))
                .addGap(77, 77, 77)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNgayDat)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(176, 176, 176)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNgayTra, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtLoaiPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtMaDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(128, 157, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN THANH TOÁN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txtTienPhong.setBackground(new java.awt.Color(204, 204, 204));
        txtTienPhong.setCaretColor(new java.awt.Color(0, 0, 102));
        txtTienPhong.setDisabledTextColor(new java.awt.Color(0, 0, 102));
        txtTienPhong.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 255));
        jLabel4.setText("Tiền phòng");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 255, 255));
        jLabel12.setText("Số ngày ở");

        txtNgayO.setBackground(new java.awt.Color(204, 204, 204));
        txtNgayO.setCaretColor(new java.awt.Color(0, 0, 102));
        txtNgayO.setDisabledTextColor(new java.awt.Color(0, 0, 102));
        txtNgayO.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 255, 255));
        jLabel6.setText("Tiền cọc");

        txtTienCoc.setBackground(new java.awt.Color(204, 204, 204));
        txtTienCoc.setCaretColor(new java.awt.Color(0, 0, 102));
        txtTienCoc.setDisabledTextColor(new java.awt.Color(0, 0, 102));
        txtTienCoc.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 255, 255));
        jLabel7.setText("Tiền dịch vụ");

        txtTienDV.setBackground(new java.awt.Color(204, 204, 204));
        txtTienDV.setCaretColor(new java.awt.Color(0, 0, 102));
        txtTienDV.setDisabledTextColor(new java.awt.Color(0, 0, 102));
        txtTienDV.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 255, 255));
        jLabel8.setText("Thành tiền");

        txtThanhToan.setBackground(new java.awt.Color(204, 204, 204));
        txtThanhToan.setCaretColor(new java.awt.Color(0, 0, 102));
        txtThanhToan.setDisabledTextColor(new java.awt.Color(0, 0, 102));
        txtThanhToan.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(77, 77, 77)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12)
                                .addComponent(txtNgayO, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                .addComponent(txtTienDV))))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(7, 7, 7)
                .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnTao.setBackground(new java.awt.Color(0, 255, 255));
        btnTao.setText("TẠO");
        btnTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoActionPerformed(evt);
            }
        });

        btnIn.setBackground(new java.awt.Color(0, 255, 255));
        btnIn.setText("IN");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabCapNhatLayout = new javax.swing.GroupLayout(tabCapNhat);
        tabCapNhat.setLayout(tabCapNhatLayout);
        tabCapNhatLayout.setHorizontalGroup(
            tabCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCapNhatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(tabCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabCapNhatLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(796, 796, 796)
                        .addComponent(jLabel3)
                        .addGap(124, 124, 124)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabCapNhatLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(btnTao, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabCapNhatLayout.setVerticalGroup(
            tabCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCapNhatLayout.createSequentialGroup()
                .addGroup(tabCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabCapNhatLayout.createSequentialGroup()
                        .addGroup(tabCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabCapNhatLayout.createSequentialGroup()
                                .addGroup(tabCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabCapNhatLayout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel3))
                                    .addGroup(tabCapNhatLayout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabCapNhatLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabCapNhatLayout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(tabCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTao, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44))
        );

        tabs.addTab("Hóa đơn", new javax.swing.ImageIcon(getClass().getResource("/Icon/update.png")), tabCapNhat); // NOI18N

        tabDanhSach.setBackground(new java.awt.Color(128, 157, 255));

        jScrollPane1.setBackground(new java.awt.Color(128, 157, 255));

        tblThanhToan.setBackground(new java.awt.Color(128, 157, 255));
        tblThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        tblThanhToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã thanh toán", "Mã khách hàng", "Mã đặt phòng", "Mã đăng ký", "Mã nhân viên", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThanhToanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThanhToan);

        jPanel6.setBackground(new java.awt.Color(128, 157, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tìm kiếm");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabDanhSachLayout = new javax.swing.GroupLayout(tabDanhSach);
        tabDanhSach.setLayout(tabDanhSachLayout);
        tabDanhSachLayout.setHorizontalGroup(
            tabDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1277, Short.MAX_VALUE)
            .addGroup(tabDanhSachLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabDanhSachLayout.setVerticalGroup(
            tabDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDanhSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách", new javax.swing.ImageIcon(getClass().getResource("/Icon/list.png")), tabDanhSach); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 1282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1295, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDKActionPerformed

    private void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoActionPerformed
        taoHoaDon();
        btnIn.setEnabled(true);
    }//GEN-LAST:event_btnTaoActionPerformed

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        if (txtArea.getText().length() == 0 || txtMaDP.getText().trim().equals("")) {
            MsgBox.alert(this, "Hóa đơn chưa được tạo");
        } else {
            inHoaDon();
            insert();
        }
    }//GEN-LAST:event_btnInActionPerformed

    private void tblThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThanhToanMouseClicked

    }//GEN-LAST:event_tblThanhToanMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        if(txtTimKiem.getText().length()==0){
            load(0);
        }else{
            timKiem();
        }
                
        
        
    }//GEN-LAST:event_txtTimKiemKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyThanhToan dialog = new QuanLyThanhToan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnTao;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel tabCapNhat;
    private javax.swing.JPanel tabDanhSach;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblThanhToan;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtLoaiPhong;
    private javax.swing.JTextField txtMaDK;
    private javax.swing.JTextField txtMaDP;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgayDat;
    private javax.swing.JTextField txtNgayO;
    private javax.swing.JTextField txtNgayTra;
    private javax.swing.JTextField txtThanhToan;
    private javax.swing.JTextField txtTienCoc;
    private javax.swing.JTextField txtTienDV;
    private javax.swing.JTextField txtTienPhong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
   ThanhToanDAO ttdao = new ThanhToanDAO();
    PhongDAO pdao = new PhongDAO();
    DKDichVuDAO dkdvdao = new DKDichVuDAO();
    DatPhongDAO dpdao = new DatPhongDAO();
    KhachHangDAO khdao = new KhachHangDAO();

    public void Deletetab(String role) {
        if (role.equalsIgnoreCase("Kế toán"));
        tabs.removeTabAt(0);
    }

    private void init() {
        this.setLocationRelativeTo(null);
        load(0);

    }

    private void init(String makh, int ngayo, String loaiPhong, Date ngaydat, Date ngayTra) {
        this.setLocationRelativeTo(null);
        loaddataFromDP(makh, ngayo, loaiPhong, ngaydat, ngayTra);
        load(0);

    }

    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void inHoaDon() {
        try {
            txtArea.print();
            openFile(txtArea.toString());
        } catch (Exception e) {
        }
    }

    public void taoHoaDon() {
        if (txtMaDP.getText().trim().length() == 0) {
            MsgBox.alert(this, "Không có dữ liệu để tạo hóa đơn");
        } else {
            Date obj = new Date();
            String date = obj.toString();
            txtArea.setText("GFT HOTEL\n");
            txtArea.setText(txtArea.getText() + "Địa chỉ:45 Phan Chu Trinh,Phường Bến Thành,Quận 1,TP.Hồ Chí Minh \n");
            txtArea.setText(txtArea.getText() + "Điện thoại:0901301277\n");
            txtArea.setText(txtArea.getText() + "\t*           HÓA ĐƠN THANH TOÁN           *\n");
            txtArea.setText(txtArea.getText() + "\t     " + date + "\n");
            txtArea.setText(txtArea.getText() + "_______________________________________________________\n");
            txtArea.setText(txtArea.getText() + "\t     " + "\n");

            txtArea.setText(txtArea.getText() + "Mã thanh toán: " + txtMaDP.getText() + "\t");
            txtArea.setText(txtArea.getText() + "Loại phòng:    " + txtLoaiPhong.getText() + "\n\n");

            txtArea.setText(txtArea.getText() + "Mã khách hàng: " + txtMaKH.getText() + "\t");
            txtArea.setText(txtArea.getText() + "Tiền phòng:      " + txtTienPhong.getText() + "\n\n");

            txtArea.setText(txtArea.getText() + "Mã đăng ký:      " + txtMaDK.getText() + "\t");
            txtArea.setText(txtArea.getText() + "Ngày ở: " + txtNgayO.getText() + "\n\n");

            txtArea.setText(txtArea.getText() + "Ngày đặt: " + txtNgayDat.getText() + "\t");
            txtArea.setText(txtArea.getText() + "Tiền dịch vụ:    " + txtTienDV.getText() + "\n\n");

            txtArea.setText(txtArea.getText() + "Ngày trả: " + txtNgayTra.getText() + "\t");
            txtArea.setText(txtArea.getText() + "Tiền cọc: " + txtTienCoc.getText() + "\n\n");
            txtArea.setText(txtArea.getText() + "________________________________________________________\n\n");
            txtArea.setText(txtArea.getText() + "\t\tSố tiền cần thanh toán: " + txtThanhToan.getText() + "\n");
            txtArea.setText(txtArea.getText() + "________________________________________________________\n");
            txtArea.setText(txtArea.getText() + "\tXin Cảm ơn quý khách đã sử dụng dịch vụ của GFT" + "\n");
            txtArea.setText(txtArea.getText() + "\t\tHẹn gặp lại quý khách vào một ngày không xa");
        }
    }

    //Đổ dữ liệu lên bảng
    public void load(int selecttype) {
        DefaultTableModel model = (DefaultTableModel) tblThanhToan.getModel();
        model.setRowCount(0);
        try {
            List<ThanhToan> tt = ttdao.selecttype(selecttype,txtTimKiem.getText());
            for (ThanhToan thanhtoan : tt) {
                Object[] row = {
                    thanhtoan.getMathanhToan(),
                    thanhtoan.getMaKH(),
                    thanhtoan.getMadatPhong(),
                    thanhtoan.getMaDK(),
                    thanhtoan.getMaNV(),
                    thanhtoan.getThanhTien()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }


    //Lấy thông tin từ form lưu vào bảng 
    public ThanhToan getForm() {
        ThanhToan tt = new ThanhToan();
        tt.setMaDK(txtMaDK.getText());
        tt.setMaKH(txtMaKH.getText());
        //tt.setMaKH(Auth.kh.getMaKH());
        tt.setMadatPhong(txtMaDP.getText());
        tt.setMaNV(Auth.user.getMaNV());
        tt.setThanhTien(Float.valueOf(txtThanhToan.getText()));
        return tt;
    }
    //Thêm 
    public void insert() {
        ThanhToan tt = getForm();
        try {
            ttdao.insert(txtMaDK.getText(), txtMaDP.getText(), Auth.user.getMaNV(), txtMaKH.getText(), Float.valueOf(txtThanhToan.getText()));
            this.load(0);
            // clearForm();
            MsgBox.alert(this, "Thanh toán thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Thanh toán thất bại");
            e.printStackTrace();
        }

    }

    int Index;

    //Tìm kiếm
    public void timKiem() {
        load(1);
        Index = -1;
    }

    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }

    public void loaddataFromDP(String maKH, int ngayo, String loaiphong, Date ngaydat, Date ngayTra) {
        if (dkdvdao.selectmaKH(maKH) == null) {
            txtMaDK.setText("");
            txtTienDV.setText("");
            txtLoaiPhong.setText(loaiphong);
            txtMaKH.setText(maKH);
            txtNgayO.setText(String.valueOf(ngayo));
            txtNgayDat.setText(String.valueOf(ngaydat));
            txtNgayTra.setText(String.valueOf(ngayTra));  
            // MÃ ĐẶT PHÒNG
            List<DatPhong> listmadp = dpdao.selectMaDPTienCocByMaKH(0, txtMaKH.getText());
            for (DatPhong madp : listmadp) {
                txtMaDP.setText(madp.getMadatPhong());
            }
            //TIỀN PHÒNG
            List<Phong> listphong = pdao.SelectGiaPhongByMaDP(txtMaDP.getText());
            for (Phong giaphong : listphong) {
                txtTienPhong.setText(String.valueOf(giaphong.getGiaPhong()));
            }
            // TIỀN CỌC
            List<DatPhong> listtiencoc = dpdao.selectMaDPTienCocByMaKH(1, txtMaKH.getText());
            for (DatPhong tiencoc : listtiencoc) {
                txtTienCoc.setText(String.valueOf(tiencoc.getTienCoc()));
            }
            //THÀNH TIỀN 
            float tiencoc = Float.valueOf(txtTienCoc.getText());
            System.out.println(tiencoc);
            float tienphong = Float.valueOf(txtTienPhong.getText());
            System.out.println(tienphong);
            float tiendv = 0;
            System.out.println(tiendv);
            long thanhtien = (long) ((tienphong * ngayo + tiendv) - tiencoc);
            txtThanhToan.setText(String.valueOf(thanhtien));
        } else {
            txtLoaiPhong.setText(loaiphong);
            txtMaKH.setText(maKH);
            txtNgayO.setText(String.valueOf(ngayo));
            txtNgayDat.setText(String.valueOf(ngaydat));
            txtNgayTra.setText(String.valueOf(ngayTra));
            // MÃ ĐẶT PHÒNG
            List<DatPhong> listmadp = dpdao.selectMaDPTienCocByMaKH(0, txtMaKH.getText());
            for (DatPhong madp : listmadp) {
                txtMaDP.setText(madp.getMadatPhong());

            }
            // MÃ ĐĂNG KÍ
            List<DKDichVu> listdkdv = dkdvdao.selectMaDKByMaKH(maKH);
            for (DKDichVu madk : listdkdv) {
                txtMaDK.setText(madk.getMaDK());
            }
            //TIỀN PHÒNG
            List<Phong> listphong = pdao.SelectGiaPhongByMaDP(txtMaDP.getText());
            for (Phong giaphong : listphong) {
                txtTienPhong.setText(String.valueOf(giaphong.getGiaPhong()));
            }
            // TIỀN CỌC
            List<DatPhong> listtiencoc = dpdao.selectMaDPTienCocByMaKH(1, txtMaKH.getText());
            for (DatPhong tiencoc : listtiencoc) {
                txtTienCoc.setText(String.valueOf(tiencoc.getTienCoc()));
            }
            // TIỀN DỊCH VỤ
            List<DKDichVu> listtiendv = dkdvdao.selectTienDVByMaKH(txtMaKH.getText());
            for (DKDichVu tiendv : listtiendv) {
                txtTienDV.setText(String.valueOf(tiendv.getGia()));
            }
            //THÀNH TIỀN 
            float tiencoc = Float.valueOf(txtTienCoc.getText());
            System.out.println(tiencoc);
            float tienphong = Float.valueOf(txtTienPhong.getText());
            System.out.println(tienphong);
            float tiendv = Float.valueOf(txtTienDV.getText());
            System.out.println(tiendv);
            long thanhtien = (long) ((tienphong * ngayo + tiendv) - tiencoc);
            txtThanhToan.setText(String.valueOf(thanhtien));
        }
    }
}
