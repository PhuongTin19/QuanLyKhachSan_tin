/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author USUS
 */
public class XImage {
    public static Image getAppIcon()
    {
        URL url=XImage.class.getResource("/Icon/GFT.png");
        return new ImageIcon(url).getImage();
    }
    //lưu 1 file vào thư mục logos
    public static void save(File src){
        //Tạo đối tượng file dst tới thư mục logos
        //Lấy tên do người dùng đưa vào
        File dst=new File("logos",src.getName());
        //Kiểm tra xem thư mục logos đã tồn tại hay chưa?
        if(!dst.getParentFile().exists()){
            dst.getParentFile().mkdirs();//Tạo thư mục logos nếu chưa tồn tại
        }
        try {
            Path form=Paths.get(src.getAbsolutePath());
            Path to=Paths.get(dst.getAbsolutePath());
            Files.copy(form,to,StandardCopyOption.REPLACE_EXISTING);//copy file vào thư mục logos
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      
    }
    //Đọc file rồi đưa lên label
    public static ImageIcon read(String fileName){
        File path=new File("logos",fileName);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(300,1000,Image.SCALE_DEFAULT));
    }
    
    
    
}
