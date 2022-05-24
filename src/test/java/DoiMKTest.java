import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import dao.TaiKhoanDAO;
import entity.TaiKhoan;
import utils.Auth;
import utils.MsgBox;

public class DoiMKTest {
	TaiKhoanDAO dao = new TaiKhoanDAO(); 
	@Test
	public void doiMK(){
		String username = "dung";
		TaiKhoan tk = dao.selectID(username);
        String matKhau = "789";
        String matKhauMoi =  "123";
        String matKhauMoi2 = "123";
        if(!matKhau.equals(tk.getMatKhau())){
            System.out.print("Mật khẩu bạn nhập chưa đúng .Vui lòng nhập lại!");
        }else 
        	if(!matKhauMoi.equals(matKhauMoi2)){
            System.out.print("Xác nhận mật khẩu không đúng.Vui lòng nhập lại");
        }else{
            tk.setMatKhau(matKhauMoi);
            dao.update(tk);
            System.out.print("Đổi mật khẩu thành công");
        }
    }
}
