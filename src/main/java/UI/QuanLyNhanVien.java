package UI;

import dao.NhanVienDAO;
import entity.NhanVien;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
import utils.Auth;
import utils.MsgBox;
import utils.XDate;
import utils.XImage;
import static org.junit.Assert.*;

/**
 *
 * @author USUS
 */
public class QuanLyNhanVien extends javax.swing.JDialog {

    //Gọi class NhanVienDAO
    NhanVienDAO nvdao = new NhanVienDAO();

    /**
     * Creates new form QuanLyNhanVien2
     */
    public QuanLyNhanVien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        setIconImage(XImage.getAppIcon());
        load();
    }

    //Đưa form ra giữa màn hình
    private void init() {
        this.setLocationRelativeTo(null);
        Random rd = new Random();
        String manv = "NV" + (1 + rd.nextInt(99));
        txtMaNV.setText(manv);
    }

    //Đổ dữ liệu lên bảng
    public void load() {
        DefaultTableModel model = (DefaultTableModel) tblBangNV.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> nv = nvdao.selecbyKeyword(txtTimKiem.getText());
            //List<NhanVien> nv=nvdao.selectAll();
            for (NhanVien nhanVien : nv) {
                Object[] row = {
                    nhanVien.getMaNV(),
                    nhanVien.getHoTen(),
                    XDate.toString(nhanVien.getNgaySinh()),
                    nhanVien.getGioiTinh() ? "Nam" : "Nữ",
                    nhanVien.getCCCD(),
                    nhanVien.getChucVu(),
                    nhanVien.getEmail(),
                    nhanVien.getSodienThoai(),
                    nhanVien.getDiaChi()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    //Bắt lỗi
    public boolean valida_data() {
        String patternSo = "[0-9 ]+";
        // HỌ TÊN
        if (txtHoTen.getText().equals("")) {
            lblBatLoiHoTen.setText("Họ tên không được bỏ trống");
            lblBatLoiHoTen.setForeground(Color.red);
            lblBatLoiHoTen.requestFocus();
            return false;
        } else {
            lblBatLoiHoTen.setText("");
        }
        if (txtHoTen.getText().matches(patternSo)) {
            lblBatLoiHoTen.setText("Họ tên phải nhập chữ");
            lblBatLoiHoTen.setForeground(Color.red);
            lblBatLoiHoTen.requestFocus();
            return false;
        } else {
            lblBatLoiHoTen.setText("");
        }
        // NGÀY SINH
        if (date_NgaySinh.getDate() == null) {
            lblBatLoiNgaySinh.setText("Ngày sinh không được trống");
            lblBatLoiNgaySinh.setForeground(Color.red);
            lblBatLoiNgaySinh.requestFocus();
            return false;
        } else {
            lblBatLoiNgaySinh.setText("");
        }      
        Date ngaysinh = date_NgaySinh.getDate();
        Calendar day1 = Calendar.getInstance();
        day1.setTime(ngaysinh);
        int yearNgaySinh = day1.get(Calendar.YEAR);
        LocalDate localDate = LocalDate.now();
        int yearHienTai = localDate.getYear();
        if (yearNgaySinh > yearHienTai) {
            lblBatLoiNgaySinh.setText("Năm sinh phải nhỏ hơn năm hiện tại");
            lblBatLoiNgaySinh.setForeground(Color.red);
            lblBatLoiNgaySinh.requestFocus();
            return false;
        } else {
            lblBatLoiNgaySinh.setText("");
        }
        // CĂN CƯỚC CÔNG DÂN
        if (txtCCCD.getText().equals("")) {
            lblBatLoiCCCD.setText("CMND/CCCD không được bỏ trống");
            lblBatLoiCCCD.setForeground(Color.red);
            lblBatLoiCCCD.requestFocus();
            return false;
        } else {
            lblBatLoiCCCD.setText("");
        }
        if (!txtCCCD.getText().matches("[0-9]{9,12}")) {
            lblBatLoiCCCD.setText("CMND/CCCD bạn nhập chưa đúng định dạng (từ 0-9)");
            lblBatLoiCCCD1.setText("(CMND đúng 9 số)(CCCD đúng 12 số)");
            lblBatLoiCCCD.setForeground(Color.red);
            lblBatLoiCCCD1.setForeground(Color.red);
            lblBatLoiCCCD.requestFocus();
            return false;
        } else {
            lblBatLoiCCCD.setText("");
            lblBatLoiCCCD1.setText("");
        }
        // EMAIL
        if (txtEmail.getText().equals("")) {
            lblBatLoilEmail.setText("Email không được bỏ trống");
            lblBatLoilEmail.setForeground(Color.red);
            lblBatLoilEmail.requestFocus();
            return false;
        } else {
            lblBatLoilEmail.setText("");
        }
        if (!txtEmail.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            lblBatLoilEmail.setText("Email bạn nhập chưa đúng định dạng");
            lblBatLoilEmail.setForeground(Color.red);
            lblBatLoilEmail.requestFocus();
            return false;
        } else {
            lblBatLoilEmail.setText("");
        }
        // SỐ ĐIỆN THOẠI
        if (txtSoDienThoai.getText().equals("")) {
            lblBatLoSDT.setText("Số điện thoại không được bỏ trống");
            lblBatLoSDT.setForeground(Color.red);
            lblBatLoSDT.requestFocus();
            return false;
        } else {
            lblBatLoSDT.setText("");
        }
        if (!txtSoDienThoai.getText().matches("[0-9]{10}")) {
            lblBatLoSDT.setText("Số điện thoại bạn nhập chưa đúng định dạng (từ 0-9 đúng 10 số) ");
            lblBatLoSDT.setForeground(Color.red);
            lblBatLoSDT.requestFocus();
            return false;
        } else {
            lblBatLoSDT.setText("");
        }
        //ĐỊA CHỈ 
        if (txtDiaChi.getText().equals("")) {
            lblBatLoiDiaChi.setText("Địa chỉ không được bỏ trống");
            lblBatLoiDiaChi.setForeground(Color.red);
            lblBatLoiDiaChi.requestFocus();
            return false;
        } else {
            lblBatLoiDiaChi.setText("");
        }
        return true;
    }

    private boolean CheckTrungMa() {
        if (nvdao.selectID(txtMaNV.getText()) != null) {
            lblBatLoiMaNV.setText("Mã nhân viên đã tồn tại");
            lblBatLoiMaNV.setForeground(Color.red);
            lblBatLoiMaNV.requestFocus();
            return false;
        } else {
            lblBatLoiMaNV.setText("");
        }
        return true;
    }
    //Lấy thông tin của nhân viên có sẵn lên form

    public void setForm(NhanVien nv) {
        txtMaNV.setText(nv.getMaNV());
        txtHoTen.setText(nv.getHoTen());
        date_NgaySinh.setDate(nv.getNgaySinh());
        rdoNam.setSelected(nv.getGioiTinh());
        rdoNu.setSelected(!nv.getGioiTinh());
        txtCCCD.setText(nv.getCCCD());
        txtEmail.setText(nv.getEmail());
        txtSoDienThoai.setText(nv.getSodienThoai());
        txtDiaChi.setText(nv.getDiaChi());
        if (nv.getChucVu().equals("Lễ tân")) {
            cboChucVu.setSelectedIndex(0);
        } else if (nv.getChucVu().equals("Kế toán")) {
            cboChucVu.setSelectedIndex(1);
        } else if (nv.getChucVu().equals("Kinh doanh")) {
            cboChucVu.setSelectedIndex(2);
        } else {
            cboChucVu.setSelectedIndex(3);
        }
    }

    //Lấy thông tin từ form lưu vào bảng 
    public NhanVien getForm() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNV.getText());
        nv.setHoTen(txtHoTen.getText());
        nv.setNgaySinh(new java.sql.Date(date_NgaySinh.getDate().getTime()));
        nv.setGioiTinh(rdoNam.isSelected());
        nv.setCCCD(txtCCCD.getText());
        nv.setChucVu(cboChucVu.getSelectedItem() + "");
        nv.setEmail(txtEmail.getText());
        nv.setSodienThoai(txtSoDienThoai.getText());
        nv.setDiaChi(txtDiaChi.getText());
        return nv;
    }

    //Xóa dữ liệu trên form
    public void clearForm() {
        NhanVien nv = new NhanVien();
        Random rd = new Random();
        String manv = "NV" + (1 + rd.nextInt(99));
        lblBatLoSDT.setText("");
        lblBatLoiCCCD.setText("");
        lblBatLoiCCCD1.setText("");
        lblBatLoiDiaChi.setText("");
        lblBatLoiHoTen.setText("");
        lblBatLoiMaNV.setText("");
        lblBatLoiNgaySinh.setText("");
        lblBatLoilEmail.setText("");
        nv.setMaNV(manv);
        setForm(nv);
        Index = 0;
        updateStatus(true);
    }

    //Thêm 
    public void Them() {
        NhanVien nv = getForm();
        try {
            nvdao.insert(txtMaNV.getText(), txtHoTen.getText(), XDate.toString(date_NgaySinh.getDate()), rdoNam.isSelected(), txtCCCD.getText(),
                    txtDiaChi.getText(), txtEmail.getText(), txtSoDienThoai.getText(), String.valueOf(cboChucVu.getSelectedItem()));
            this.load();
            this.New();
            MsgBox.alert(this, "Thêm thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm thất bại");
            e.printStackTrace();
        }

    }

    //Xóa
    public void delete() {
        String manv = txtMaNV.getText();
        if (MsgBox.confirm(this, "Bạn có muốn xóa nhân viên này không?.")) {
            try {
                nvdao.delete(manv);
                load();
                MsgBox.alert(this, "Đã xóa nhân viên khỏi danh sách");
                New();
            } catch (Exception e) {
                MsgBox.alert(this, "Nhân viên chưa được xóa khỏi danh sách.Xóa thất bại");
                e.printStackTrace();
            }
        }

    }

    //Cập nhật
    public void update() {
        NhanVien nv = getForm();
        try {
            nvdao.update(txtMaNV.getText(), txtHoTen.getText(), XDate.toString(date_NgaySinh.getDate()), rdoNam.isSelected(), txtCCCD.getText(),
                    txtDiaChi.getText(), txtEmail.getText(), txtSoDienThoai.getText(), String.valueOf(cboChucVu.getSelectedItem()));
            load();
            MsgBox.alert(this, "Cập nhật thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại");
        }

    }

    int Index;

    public void edit() {
        String manv = (String) tblBangNV.getValueAt(this.Index, 0);
        NhanVien model = nvdao.selectID(manv);
        setForm(model);
        tabs.setSelectedIndex(0);
        updateStatus(false);
    }

    //Tìm kiếm
    public void timKiem() {
        load();
        //clearForm();
        Index = 0;
    }

    //Mới
    public void New() {
        NhanVien nv = new NhanVien();
        txtMaNV.setText(nv.getMaNV());
        txtHoTen.setText(nv.getHoTen());
        date_NgaySinh.setDate(nv.getNgaySinh());
        rdoNam.setSelected(nv.getGioiTinh());
        rdoNu.setSelected(!nv.getGioiTinh());
        txtCCCD.setText(nv.getCCCD());
        txtEmail.setText(nv.getEmail());
        txtSoDienThoai.setText(nv.getSodienThoai());
        txtDiaChi.setText(nv.getDiaChi());
        cboChucVu.setSelectedIndex(0);
        Random rd = new Random();
        String manv = "NV" + (1 + rd.nextInt(99));
        txtMaNV.setText(manv);
        updateStatus(true);
    }

    public void updateStatus(boolean insertable) {
        txtMaNV.setEditable(insertable);
        btnThem.setEnabled(insertable);
        btnCapNhat.setEnabled(!insertable);
        btnXoa.setEnabled(!insertable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        date_NgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboChucVu = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        lblBatLoiMaNV = new javax.swing.JLabel();
        lblBatLoiHoTen = new javax.swing.JLabel();
        lblBatLoiCCCD = new javax.swing.JLabel();
        lblBatLoilEmail = new javax.swing.JLabel();
        lblBatLoSDT = new javax.swing.JLabel();
        lblBatLoiCCCD1 = new javax.swing.JLabel();
        lblBatLoiNgaySinh = new javax.swing.JLabel();
        lblBatLoiDiaChi = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBangNV = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ NHÂN VIÊN ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tabs.setBackground(new java.awt.Color(255, 209, 179));

        jPanel3.setBackground(new java.awt.Color(128, 157, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã nhân viên");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Họ Tên");

        txtMaNV.setCaretColor(new java.awt.Color(0, 0, 102));
        txtMaNV.setDisabledTextColor(new java.awt.Color(0, 0, 102));
        txtMaNV.setEnabled(false);

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ngày Sinh");

        date_NgaySinh.setBackground(new java.awt.Color(204, 204, 204));
        date_NgaySinh.setDateFormatString("dd/MM/yyyy");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Giới Tính");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CMND/CCCD");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Địa chỉ");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số điện thoại");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Chức vụ");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lễ tân", "Kế toán", "Kinh Doanh", "Nhân Sự", " " }));

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtDiaChi);

        rdoNam.setBackground(new java.awt.Color(128, 157, 255));
        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        rdoNu.setBackground(new java.awt.Color(128, 157, 255));
        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(date_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(txtMaNV)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                .addComponent(cboChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9)
                            .addComponent(lblBatLoiMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBatLoiNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBatLoilEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(rdoNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(21, 21, 21)
                                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(lblBatLoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblBatLoiHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBatLoiCCCD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblBatLoiCCCD1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(140, 140, 140))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(lblBatLoiDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblBatLoiMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBatLoiHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGap(7, 7, 7)
                                .addComponent(date_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdoNu)
                                .addComponent(rdoNam)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBatLoiNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(10, 10, 10)
                                .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addComponent(lblBatLoiCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lblBatLoiCCCD1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBatLoilEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBatLoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBatLoiDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        tabs.addTab("Cập nhật", new javax.swing.ImageIcon(getClass().getResource("/Icon/update.png")), jPanel3); // NOI18N

        jPanel2.setBackground(new java.awt.Color(128, 157, 255));

        jScrollPane1.setBackground(new java.awt.Color(128, 157, 255));

        tblBangNV.setBackground(new java.awt.Color(128, 157, 255));
        tblBangNV.setForeground(new java.awt.Color(255, 255, 255));
        tblBangNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ tên", "Ngày sinh", "Giới Tính ", "CCCD/CNND", "Chức vụ", "Email", "Điện thoại", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBangNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangNVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblBangNVMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblBangNV);

        jPanel6.setBackground(new java.awt.Color(128, 157, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tìm kiếm");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách", new javax.swing.ImageIcon(getClass().getResource("/Icon/list.png")), jPanel2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 657, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if (valida_data()) {
            update();
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        updateStatus(true);
    }//GEN-LAST:event_formWindowOpened

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (valida_data()) {
            if (CheckTrungMa()) {
                Them();
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblBangNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangNVMouseClicked
        if (evt.getClickCount() == 2) {
            this.Index = tblBangNV.rowAtPoint(evt.getPoint());
            if (this.Index >= 0) {
                this.edit();
                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblBangNVMouseClicked

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        New();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        timKiem();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        timKiem();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tblBangNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangNVMouseEntered

    }//GEN-LAST:event_tblBangNVMouseEntered

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
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyNhanVien dialog = new QuanLyNhanVien(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChucVu;
    private com.toedter.calendar.JDateChooser date_NgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBatLoSDT;
    private javax.swing.JLabel lblBatLoiCCCD;
    private javax.swing.JLabel lblBatLoiCCCD1;
    private javax.swing.JLabel lblBatLoiDiaChi;
    private javax.swing.JLabel lblBatLoiHoTen;
    private javax.swing.JLabel lblBatLoiMaNV;
    private javax.swing.JLabel lblBatLoiNgaySinh;
    private javax.swing.JLabel lblBatLoilEmail;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblBangNV;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
