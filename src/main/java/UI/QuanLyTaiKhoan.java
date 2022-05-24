package UI;

import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import entity.NhanVien;
import entity.TaiKhoan;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import utils.Auth;
import utils.MsgBox;
import utils.XImage;

/**
 *
 * @author USUS
 */
public class QuanLyTaiKhoan extends javax.swing.JDialog {
    //Gọi class TaiKhoanDAO
    TaiKhoanDAO taiKhoan=new TaiKhoanDAO();
    NhanVienDAO nhanVien=new NhanVienDAO();
    List<TaiKhoan>list=taiKhoan.selectAll();
  
    public QuanLyTaiKhoan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        setIconImage(XImage.getAppIcon());
       
    }
    //Đưa form ra giữa màn hình
    public void init(){
        this.setLocationRelativeTo(null);
        this.fillComboBoxNV();
        btnCapNhat.setEnabled(false);
        btnXoa.setEnabled(false);
         load();
    }
    //Đổ dữ liệu lên bảng
    public void load(){
       DefaultTableModel model=(DefaultTableModel) tblTaiKhoan.getModel();
       model.setRowCount(0);
        try {
            List<TaiKhoan> nv=taiKhoan.selecbyKeyword(txtTimKiem.getText());
            for (TaiKhoan taiKhoan : nv) {
                TaiKhoan tk=new TaiKhoan();
                Object[] row={
                    taiKhoan.getTentaiKhoan(),
                    taiKhoan.getMatKhau().replaceAll("(?s).", "*"),
                    taiKhoan.getChucVu(),
                    taiKhoan.getMaNV()
                };
                model.addRow(row);
            }     
        }catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!"); 
            e.printStackTrace();
        }
    }
    //Bắt lỗi
    public  boolean valida_data(){
        if(txtTaiKhoan.getText().equals("")){
            lblBatLoiTaiKhoan.setText("Chưa nhập tên tài khoản");
            lblBatLoiTaiKhoan.setForeground(Color.red);
            lblBatLoiTaiKhoan.requestFocus();
            return false;
        }else{
            lblBatLoiTaiKhoan.setText("");
        }
        if(txtMatKhau.getText().equals("")){
            lblBatLoiMatKhau.setText("Chưa nhập mật khẩu");
            lblBatLoiMatKhau.setForeground(Color.red);
            lblBatLoiMatKhau.requestFocus();
            return false;
        }else{
            lblBatLoiMatKhau.setText("");
        }
        if(txtXacNhanMK.getText().equals("")){
            lblBatLoiXacNhanMK.setText("Chưa nhập xác nhận mật khẩu");
            lblBatLoiXacNhanMK.setForeground(Color.red);
            lblBatLoiXacNhanMK.requestFocus();
            return false;
        }else{
            lblBatLoiXacNhanMK.setText("");
        }
        if(cboMaNV.getSelectedItem().equals("")){
            lblBatLoiMaNV.setText("Chưa nhập xác nhận mật khẩu");
            lblBatLoiMaNV.setForeground(Color.red);
            lblBatLoiMaNV.requestFocus();
            return false;
        }else{
            lblBatLoiXacNhanMK.setText("");
        }
        return true;
    }
    
    private boolean CheckTrungMa(){
        if (taiKhoan.selectID(txtTaiKhoan.getText()) != null) {
            lblBatLoiTaiKhoan.setText("Tài khoản đã tồn tại");
            lblBatLoiTaiKhoan.setForeground(Color.red);
            lblBatLoiTaiKhoan.requestFocus();
            return false;
        }else{
            lblBatLoiTaiKhoan.setText("");
        }
        return true;
    }
    private boolean  checktaikhoannv(){
        if (taiKhoan.selectBYMaNV((String) cboMaNV.getSelectedItem()) != null) {
            lblBatLoiMaNV.setText("Mỗi nhân viên chỉ có duy nhất một tài khoản");
            lblBatLoiMaNV.setForeground(Color.red);
            lblBatLoiMaNV
                    .requestFocus();
            return false;
        }else{
            lblBatLoiMaNV.setText("");
        }
        return true;
    }
     //Lấy thông tin của tài khoản có sẵn hiện lên form
    
    public void setForm(TaiKhoan nv){
        txtTaiKhoan.setText(nv.getTentaiKhoan());
        txtMatKhau.setText(nv.getMatKhau());
        txtXacNhanMK.setText(nv.getMatKhau());
        if(nv.getChucVu().equals("Lễ tân")){
            cboChucVu.setSelectedIndex(0);
        }else if(nv.getChucVu().equals("Kế toán")){
            cboChucVu.setSelectedIndex(1);
        }else if(nv.getChucVu().equals("Kinh doanh")){
            cboChucVu.setSelectedIndex(2);
        }else{
            cboChucVu.setSelectedIndex(3);
        }
        cboMaNV.setSelectedItem(nv.getMaNV());
    }
    private void fillComboBoxNV() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboMaNV.getModel();
        model.removeAllElements();
        List<NhanVien> list = nhanVien.selectAll();
        for (NhanVien nv : list) {
            model.addElement(nv.getMaNV());
        }
    }
    
     //Lấy ra tài khoản từ thông tin nhập trên form cho vào bảng
    public TaiKhoan getForm(){
        TaiKhoan nv=new TaiKhoan();
        nv.setTentaiKhoan(txtTaiKhoan.getText());
        nv.setMatKhau(new String(txtMatKhau.getPassword()));
        nv.setChucVu( cboChucVu.getSelectedItem()+"");
        nv.setMaNV(cboMaNV.getSelectedItem().toString());
        return nv;
    }
    int Index=0;
    //Xóa form
    public void clearForm(){
        TaiKhoan nv=new TaiKhoan();
        lblBatLoiMaNV.setText("");
        lblBatLoiMatKhau.setText("");
        lblBatLoiTaiKhoan.setText("");
        lblBatLoiXacNhanMK.setText("");
        cboMaNV.setSelectedIndex(0);
        cboChucVu.setSelectedIndex(0);
        txtTaiKhoan.setText("");
        txtMatKhau.setText("");
        txtXacNhanMK.setText("");
       // setForm(nv);
        Index=0;
        updateStatus(true);
    }
    //Khi kích vào table sẽ hiện thông tin lên form
    public void edit(){
       try{
            String tk = (String) tblTaiKhoan.getValueAt(this.Index,0);
           // String tk = (String) tblTaiKhoan.getValueAt(this.Index,0);
            TaiKhoan model = taiKhoan.selectID(tk);
            if(model != null){
                setForm(model);
                updateStatus(false);
              }
            }catch(Exception a){
                MsgBox.alert(this, "lỗi truy vấn dữ liệu!");
                a.printStackTrace();
         }
       
    }
    
    //Thêm mới dữ liệu vào bảng
    public void insert(){
        TaiKhoan nv=getForm();
        String xacNhanMK=new String(txtXacNhanMK.getPassword());
        if(!xacNhanMK.equals(nv.getMatKhau())){
            lblBatLoiXacNhanMK.setText("Xác nhận mật khẩu bạn nhập chưa đúng vui lòng nhập lại");
            lblBatLoiXacNhanMK.setForeground(Color.red);
        }else{
            try {
                taiKhoan.insert(txtTaiKhoan.getText(),new String(txtMatKhau.getPassword()),String.valueOf(cboChucVu.getSelectedItem())
                        ,cboMaNV.getSelectedItem().toString());
                load();
                clearForm();
                MsgBox.alert(this,"Đã thêm tài khoản vào danh sách");
            } catch (Exception e) {
                MsgBox.alert(this,"Thêm thất bại");
                e.printStackTrace();
            }
        
        }
    }
    public void delete(){
        String tk = txtTaiKhoan.getText();
            if(MsgBox.confirm(this, "Bạn có muốn xóa tài khoản này không?.")){
                try {
                    taiKhoan.delete(tk);
                    load();
                    MsgBox.alert(this,"Đã xóa tài khoản khỏi danh sách");
                    clearForm();
                } catch (Exception e) {
                    MsgBox.alert(this, "Tài khoản chưa được xóa khỏi danh sách.Xóa thất bại");
                }
            }
    }
    //Cập nhật
    public void update(){
        TaiKhoan nv=getForm();
            try {
                taiKhoan.update(txtTaiKhoan.getText(),new String(txtMatKhau.getPassword()),String.valueOf(cboChucVu.getSelectedItem()));
                load();
                MsgBox.alert(this,"Cập nhật thành công");
            } catch (Exception e) {
                MsgBox.alert(this,"Cập nhật thất bại");
                e.printStackTrace();
            }
    }
     //Mới
//    public void New (){
//        NhanVien nv=new NhanVien();
//        txtTaiKhoan.setText(nv.getMaNV());
//        txtMatKhau.setText(nv.getHoTen());
//        txtXacNhanMK.setText(nv.getCCCD());
//        updateStatus(true);
//}
      public  void updateStatus(boolean insertable){ 
        txtTaiKhoan.setEditable(insertable); 
        btnthem.setEnabled(insertable); 
        btnCapNhat.setEnabled(!insertable);
        btnXoa.setEnabled(!insertable);
        txtMatKhau.setEnabled(insertable);
        txtXacNhanMK.setEnabled(insertable);
        cboMaNV.setEnabled(insertable);
        txtTaiKhoan.setEnabled(insertable);
    }
    //Tìm kiếm
    public void timKiem(){
        load();
        //clearForm();
        Index = 0;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboChucVu = new javax.swing.JComboBox<>();
        lblBatLoiTaiKhoan = new javax.swing.JLabel();
        lblBatLoiMatKhau = new javax.swing.JLabel();
        lblBatLoiXacNhanMK = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        txtXacNhanMK = new javax.swing.JPasswordField();
        lblBatLoiMaNV = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboMaNV = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ TÀI KHOẢN");

        tabs.setBackground(new java.awt.Color(255, 209, 179));

        jPanel3.setBackground(new java.awt.Color(128, 157, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tài khoản");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mật khẩu");

        txtTaiKhoan.setCaretColor(new java.awt.Color(0, 0, 102));
        txtTaiKhoan.setDisabledTextColor(new java.awt.Color(0, 0, 102));

        jPanel4.setBackground(new java.awt.Color(128, 157, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnthem.setBackground(new java.awt.Color(255, 153, 102));
        btnthem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnthem.setForeground(new java.awt.Color(255, 255, 255));
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add.png"))); // NOI18N
        btnthem.setText("THÊM");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
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

        btnCapNhat.setBackground(new java.awt.Color(255, 153, 102));
        btnCapNhat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/update1.png"))); // NOI18N
        btnCapNhat.setText("CẬP NHẬT");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 153, 102));
        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnthem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Xác nhận mật khẩu");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Chức vụ");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lễ tân", "Kế toán", "Kinh doanh", "Nhân sự", " " }));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mã nhân viên");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboMaNV, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboChucVu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBatLoiMaNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBatLoiTaiKhoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBatLoiMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBatLoiXacNhanMK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtXacNhanMK, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 332, Short.MAX_VALUE)))
                        .addGap(35, 35, 35)))
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBatLoiTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBatLoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtXacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBatLoiXacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBatLoiMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addGap(16, 16, 16)
                .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Cập nhật", new javax.swing.ImageIcon(getClass().getResource("/Icon/update.png")), jPanel3); // NOI18N

        jPanel2.setBackground(new java.awt.Color(128, 157, 255));

        jScrollPane1.setBackground(new java.awt.Color(128, 157, 255));

        tblTaiKhoan.setBackground(new java.awt.Color(128, 157, 255));
        tblTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tài khoản", "Mật khẩu", "Chức vụ", "Mã nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTaiKhoan);

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
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách", new javax.swing.ImageIcon(getClass().getResource("/Icon/list.png")), jPanel2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if(valida_data() && CheckTrungMa() && checktaikhoannv()){

                insert();
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if(valida_data()){
            update();
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiKhoanMouseClicked
        if(evt.getClickCount() == 2){
            this.Index = tblTaiKhoan.rowAtPoint(evt.getPoint());
            if (this .Index >= 0) {
                this. edit();
                tabs.setSelectedIndex(0);
            }
          
        
        }
    }//GEN-LAST:event_tblTaiKhoanMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        timKiem();
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
            java.util.logging.Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyTaiKhoan dialog = new QuanLyTaiKhoan(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnthem;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JComboBox<String> cboMaNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBatLoiMaNV;
    private javax.swing.JLabel lblBatLoiMatKhau;
    private javax.swing.JLabel lblBatLoiTaiKhoan;
    private javax.swing.JLabel lblBatLoiXacNhanMK;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JPasswordField txtXacNhanMK;
    // End of variables declaration//GEN-END:variables
}
