/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Desktop;
import java.io.File;

/**
 *
 * @author Admin
 */
public class XFile {
    public static void OpenFile(String file){
        try{
            File pathFile  = new File(file);
            Desktop.getDesktop().open(pathFile);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
