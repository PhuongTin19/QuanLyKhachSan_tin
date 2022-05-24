/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import dao.DKDichVuDAO;
import dao.DichVuDAO;
import dao.KhachHangDAO;
import entity.DKDichVu;
import entity.DichVu;
import entity.KhachHang;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import utils.MsgBox;

/**
 *
 * @author USUS
 */

public class DangKyDichVu extends javax.swing.JDialog {

    KhachHangDAO khdao = new KhachHangDAO();
    DichVuDAO dvdao = new DichVuDAO();
    DKDichVuDAO dkdvdao = new DKDichVuDAO();
    int row;
    int sldv = 1;
    float giatienhientai = 0;
    float tongtien = 0;
    String makh = "";
    //int madv;
    String madv = "";

    /**
     * Creates new form DangKyDichVu2
     */
    public DangKyDichVu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        Random rd = new Random();
        String madk = "DK" + (1 + rd.nextInt(99));
        txtMaDangKy.setText(madk);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaDangKy = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cboMaDichVu = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboMaKH = new javax.swing.JComboBox<>();
        txtGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSLDV = new javax.swing.JTextField();
        btnxacnhan = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblTongtien = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDVDaDK = new javax.swing.JTextArea();
        lblBatLoiMaDK = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDangKyDV = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 54, 230));

        tabs.setBackground(new java.awt.Color(255, 209, 179));

        jPanel3.setBackground(new java.awt.Color(128, 157, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã đăng ký");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Mã dịch vụ");

        txtMaDangKy.setEditable(false);
        txtMaDangKy.setCaretColor(new java.awt.Color(0, 0, 102));
        txtMaDangKy.setDisabledTextColor(new java.awt.Color(0, 0, 102));
        txtMaDangKy.setEnabled(false);

        jPanel4.setBackground(new java.awt.Color(128, 157, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThem.setBackground(new java.awt.Color(255, 153, 102));
        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnMoi.setBackground(new java.awt.Color(255, 153, 102));
        btnMoi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        btnMoi.setText("MỚI");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Giá ");

        cboMaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaDichVuActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã khách hàng");

        cboMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaKHActionPerformed(evt);
            }
        });

        txtGia.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Số lượng dịch vụ");

        btnxacnhan.setText("Xác nhận dịch vụ");
        btnxacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxacnhanActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TỔNG GIÁ TIỀN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        lblTongtien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTongtien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblTongtien, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnThanhToan.setText("Thành tiền cho dịch vụ");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtDVDaDK.setColumns(20);
        txtDVDaDK.setRows(5);
        txtDVDaDK.setBorder(javax.swing.BorderFactory.createTitledBorder("DANH SÁCH DỊCH VỤ ĐĂNG KÝ"));
        txtDVDaDK.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane3.setViewportView(txtDVDaDK);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtMaDangKy, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(cboMaDichVu, 0, 409, Short.MAX_VALUE)
                    .addComponent(cboMaKH, 0, 409, Short.MAX_VALUE)
                    .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(txtSLDV, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnThanhToan))
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btnxacnhan))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBatLoiMaDK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1284, 1284, 1284))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBatLoiMaDK, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSLDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnThanhToan)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        tabs.addTab("Cập nhật", new javax.swing.ImageIcon(getClass().getResource("/Icon/update.png")), jPanel3); // NOI18N

        jPanel2.setBackground(new java.awt.Color(128, 157, 255));

        jScrollPane1.setBackground(new java.awt.Color(128, 157, 255));

        tblDangKyDV.setBackground(new java.awt.Color(128, 157, 255));
        tblDangKyDV.setForeground(new java.awt.Color(255, 255, 255));
        tblDangKyDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã đăng ký", "Mã khách hàng", "Mã dịch vụ", "Số lượng dịch vụ", "Tổng giá tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDangKyDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDangKyDVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDangKyDV);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách", new javax.swing.ImageIcon(getClass().getResource("/Icon/list.png")), jPanel2); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        timkiem();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cboMaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaDichVuActionPerformed
        fillComBoBoxGiaByDV();
    }//GEN-LAST:event_cboMaDichVuActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        txtSLDV.setText("");
        lblTongtien.setText("");
        txtDVDaDK.setText("");
        lblBatLoiMaDK.setText("");
        txtGia.setText("0");
        txtDVDaDK.setText("");
        sldv = 1;
        cboMaKH.setSelectedIndex(0);
        cboMaDichVu.setSelectedIndex(0);
        Random rd = new Random();
        String madk = "DK" + (1 + rd.nextInt(99));
        txtMaDangKy.setText(madk);
        updateStatus();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (validate_data() && CheckTrungMa() && CheckDKDV()) {
            insert();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnxacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxacnhanActionPerformed
        //NẾU SỐ LƯỢNG DỊCH VỤ BẰNG 5 THÌ KHÔNG CHO THÊM
        if (txtSLDV.getText().equals("5")) {
            btnxacnhan.setEnabled(false);
            // giá tiền hiện tại ko bằng giá tiền cũ
        } else {
            madv = String.valueOf(cboMaDichVu.getSelectedItem() + "\n");
            // NẾU TRONG BẢNG CÓ DỊCH VỤ NÀY RỒI THÌ KHÔNG CHO THÊM DỊCH VỤ NÀY VÀO NỮA
            if (txtDVDaDK.getText().contains(madv)) {
                MsgBox.alert(this, "Dịch vụ này đã được đăng kí");
            } else {
                txtSLDV.setText(String.valueOf(sldv++));
                giatienhientai = giatienhientai + Float.valueOf(txtGia.getText());
                txtDVDaDK.setText(txtDVDaDK.getText() + madv);
            }
        }
    }//GEN-LAST:event_btnxacnhanActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        tongtien = Float.valueOf(giatienhientai);
        lblTongtien.setText(String.valueOf(tongtien));
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void cboMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaKHActionPerformed

    }//GEN-LAST:event_cboMaKHActionPerformed

    private void tblDangKyDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDangKyDVMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblDangKyDV.rowAtPoint(evt.getPoint());
            this.edit();
        }
    }//GEN-LAST:event_tblDangKyDVMouseClicked

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
            java.util.logging.Logger.getLogger(DangKyDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKyDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKyDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKyDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangKyDichVu dialog = new DangKyDichVu(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnxacnhan;
    private javax.swing.JComboBox<String> cboMaDichVu;
    private javax.swing.JComboBox<String> cboMaKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBatLoiMaDK;
    private javax.swing.JLabel lblTongtien;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblDangKyDV;
    private javax.swing.JTextArea txtDVDaDK;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaDangKy;
    private javax.swing.JTextField txtSLDV;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
public void init() {
        this.setLocationRelativeTo(null);
        fillComboBoxKH();
        fillComboBoxDV();
        fillTable(0);
        txtGia.setEnabled(false);
        txtSLDV.setEnabled(false);
        txtDVDaDK.setEditable(false);
    }

    private boolean validate_data() {
        if (txtSLDV.getText().trim().length() == 0) {
            MsgBox.alert(this, "SLDịch vụ không được để trống");
            return false;
        }
        if (lblTongtien.getText().trim().length() == 0) {
            MsgBox.alert(this, "Tổng tiền không được để trống");
            return false;
        }
        return true;
    }

    private boolean CheckTrungMa() {
        if (dkdvdao.selectID(txtMaDangKy.getText()) != null) {
            lblBatLoiMaDK.setText("Mã đăng ký đã tồn tại");
            lblBatLoiMaDK.setForeground(Color.red);
            lblBatLoiMaDK.requestFocus();
            return false;
        } else {
            lblBatLoiMaDK.setText("");
        }
        return true;
    }

    private boolean CheckDKDV() {
        System.out.println(cboMaKH.getSelectedItem());
        if (dkdvdao.selectmaKH(cboMaKH.getSelectedItem().toString()) != null) {
            MsgBox.alert(this, "Khách hàng này đã đăng kí dịch vụ!");
            return false;
        }
        return true;
    }

    private void fillComboBoxKH() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboMaKH.getModel();
        model.removeAllElements();
        List<KhachHang> list = khdao.selectAll();
        for (KhachHang makh : list) {
            model.addElement(makh);
        }
    }

    private void fillComboBoxDV() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboMaDichVu.getModel();
        model.removeAllElements();
        List<DichVu> list = dvdao.selectAll();
        for (DichVu madv : list) {
            model.addElement(madv);
        }
    }

    private void fillComBoBoxGiaByDV() {
        DichVu madv = (DichVu) cboMaDichVu.getSelectedItem();
        List<DichVu> list = dvdao.SelectGiaByDV(madv.getMaDV());
        for (DichVu gia : list) {
            txtGia.setText(String.valueOf(gia.getGia()));
        }
    }

    private void fillTable(int listtype) {
        DefaultTableModel model = (DefaultTableModel) tblDangKyDV.getModel();
        model.setRowCount(0);
        List<DKDichVu> list = dkdvdao.selectListType(listtype, txtTimKiem.getText());
        for (DKDichVu dkdv : list) {
            Object[] row = {
                dkdv.getMaDK(),
                dkdv.getMaKH(),
                dkdv.getMaDV(),
                dkdv.getSoluongDV(),
                dkdv.getGia()};
            model.addRow(row);
        }
    }

    private void setForm(DKDichVu dkdv) {
        txtMaDangKy.setText(dkdv.getMaDK());
        cboMaKH.setSelectedItem(dkdv.getMaKH());
        cboMaDichVu.setSelectedItem(dkdv.getMaDV());
        txtSLDV.setText(String.valueOf(dkdv.getSoluongDV()));
        lblTongtien.setText(String.valueOf(dkdv.getGia()));
        txtGia.setText(String.valueOf(dkdv.getGia()));
    }

    private DKDichVu getForm() {
        DKDichVu dkdv = new DKDichVu();
        dkdv.setMaDK(txtMaDangKy.getText());
        dkdv.setMaDV(cboMaDichVu.getSelectedItem() + "");
        dkdv.setMaKH(cboMaKH.getSelectedItem() + "");
        dkdv.setGia(Float.valueOf(lblTongtien.getText()));
        return dkdv;
    }

    private void edit() {
        String madk = (String) tblDangKyDV.getValueAt(row, 0);
        DKDichVu dkdv = dkdvdao.selectID(madk);
        setForm(dkdv);
        tabs.setSelectedIndex(0);
        btnThem.setEnabled(false);
    }

    private void clear() {
        DKDichVu dkdv = new DKDichVu();
        Random rd = new Random();
        String madk = "DK" + (1 + rd.nextInt(99));
        dkdv.setMaDK(madk);
        setForm(dkdv);
        this.row = -1;
        updateStatus();
    }

    private void insert() {
        DKDichVu dkdv = getForm();
        try {
            dkdvdao.insert(txtMaDangKy.getText(), String.valueOf(cboMaDichVu.getSelectedItem()),
                    String.valueOf(cboMaKH.getSelectedItem()), Float.valueOf(lblTongtien.getText()), Integer.valueOf(txtSLDV.getText()));
            this.fillTable(0);
            Random rd = new Random();
            String madk = "DK" + (1 + rd.nextInt(99));
            txtMaDangKy.setText(madk);
            MsgBox.alert(this, "Thêm thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm thất bại");
            e.printStackTrace();
        }
    }

    private void updateStatus() {
        boolean edit = this.row >= 0;
        btnThem.setEnabled(!false);

    }

    private void timkiem() {
        fillTable(1);
        updateStatus();
    }
}