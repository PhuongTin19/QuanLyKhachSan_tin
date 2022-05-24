package utils;



import entity.NhanVien;
import entity.TaiKhoan;


public class Auth {
   
    //khai báo user =>Duy trì user đăng nhập vào hệ thống
    public static TaiKhoan user;
    //Xóa user khi người dùng đăng xuất
    public static void clear(){
        Auth.user=null;
       
    }
    //Kiểm tra đăng nhập hay chưa?
    public static boolean isLogin(){
        return Auth.user!=null ;
    }
    public static String isRole(){
        return user.getChucVu();
    } 
}
