package dao;

import entity.DatPhong;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.JDBCHelper;
import utils.XDate;

/**
 *
 * @author USUS
 */
public class DatPhongDAO {

    String INSERT_SQL = "{CALL insert_DatPhong(?,?,?,?,?,?,?)}";
    String UPDATE_SQL = "{CALL Update_datphong(?,?,?,?)}";
    String DELETE_SQL = "{CALL delete_DatPhong(?)}";
    String SELECT_ALL_SQL = "{CALL list_DatPhong}";
    String SELECT_BY_ID = "{CALL Find_DatPhong(?)}";
    String UpdateByPhongDADAT = "{CALL UpdateByPhongDaDat(?)}";
    String UpdateByPhongDangThue = "{CALL UpdateByPhongDangThue(?)}";

    public void insert(String MaDP, String ngayDat, String ngayTra, String maNV, String maPhong, String maKH, float tienCoc) {
        JDBCHelper.update(INSERT_SQL, MaDP, XDate.toDate(ngayDat, "dd/MM/yyyy"), XDate.toDate(ngayTra, "dd/MM/yyyy"), maNV, maPhong, maKH, tienCoc);
    }

    public void update(String ngayDat, String ngayTra, float tienCoc, String maDP) {
        JDBCHelper.update(UPDATE_SQL, XDate.toDate(ngayDat, "dd/MM/yyyy"), XDate.toDate(ngayTra, "dd/MM/yyyy"), tienCoc, maDP);
    }

    public void updateTT(String maPhong, int updatetype) {
        //UPDATE THEO PHÒNG ĐÃ ĐẶT 
        if (updatetype == 0) {
            JDBCHelper.update(UpdateByPhongDADAT, maPhong);
        }
        // UPDATE THEO PHÒNG ĐANG THUÊ
        if (updatetype == 1) {
            JDBCHelper.update(UpdateByPhongDangThue, maPhong);
        }
    }

    public void delete(String key) {
        JDBCHelper.update(DELETE_SQL, key);
    }

    public List<DatPhong> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public DatPhong selectID(String key) {
        List<DatPhong> list = this.selectBySql(SELECT_BY_ID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    protected List<DatPhong> selectBySql(String sql, Object... args) {
        List<DatPhong> list = new ArrayList<DatPhong>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DatPhong entity = new DatPhong();
                entity.setMadatPhong(rs.getString("MaDP"));
                entity.setMaKH(rs.getString("MaKH"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMaPhong(rs.getString("MaPhong"));
                entity.setNgayDat(rs.getDate("NgayDat"));
                entity.setNgayTra(rs.getDate("NgayTra"));
                entity.setTienCoc(rs.getFloat("TienCoc"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected List<DatPhong> selectBySqlPhong(String sql, Object... args) {
        List<DatPhong> list = new ArrayList<DatPhong>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DatPhong entity = new DatPhong();
                entity.setMadatPhong(rs.getString("MaDP"));
                entity.setMaKH(rs.getString("MaKH"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMaPhong(rs.getString("MaPhong"));
                entity.setNgayDat(rs.getDate("NgayDat"));
                entity.setNgayTra(rs.getDate("NgayTra"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<DatPhong> selectByPhongDangThue(String tinhtrang) {
        String sql = "{CALL List_PHONGDANGTHUE(?)}";
        return this.selectBySqlPhong(sql, tinhtrang);
    }

    public List<DatPhong> selectByPhongDatTruoc(String tinhtrang) {
        String sql = "{CALL List_PHONGDADAT(?)}";
        return this.selectBySql(sql, tinhtrang);
    }

    public List<DatPhong> selectByKeyWord(String key) {
        String sql = "{CALL FindPhong_InDatPhong(?)}";
        return this.selectBySql(sql, "%" + key + "%");
    }
    public List<DatPhong> selectByKeyWordPhongThue(String key) {
        String sql = "{CALL FindPhong_PhongDangThue(?)}";
        return this.selectBySql(sql, "%" + key + "%");
    }
    

    public List<Integer> selectYears() {
        String sql = "{CALL selectYear}";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected List<DatPhong> selectBySqlMaDP(String sql, Object... args) {
        List<DatPhong> list = new ArrayList<DatPhong>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DatPhong entity = new DatPhong();
                entity.setMadatPhong(rs.getString("MaDP"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected List<DatPhong> selectBySqlTienCoc(String sql, Object... args) {
        List<DatPhong> list = new ArrayList<DatPhong>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DatPhong entity = new DatPhong();
                entity.setTienCoc(rs.getFloat("TienCoc"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<DatPhong> selectMaDPTienCocByMaKH(int selecttype, String makh) {
        // 0 LÀ MÃ ĐẶT PHÒNG
        if (selecttype == 0) {
            String sql = "{CALL select_MaDP_TienCocByMaKH(?,?)}";
            return this.selectBySqlMaDP(sql, selecttype, makh);
        }
        // 1 là TIỀN CỌC
        if (selecttype == 1) {
            String sql = "{CALL select_MaDP_TienCocByMaKH(?,?)}";
            return this.selectBySqlTienCoc(sql, selecttype, makh);
        }
        return null;
    }
}
