/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Function.FileCopy;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author zeppr
 */
public class UploadPDFCore {

    public static boolean UploadPDF(String Sourc, String Dest, String NameFile) {
        //System.out.println("LProses.UploadPDFCore.UploadPDF() SOURC " + Sourc);
        //System.out.println("LProses.UploadPDFCore.UploadPDF() SOURC " + Dest);
        if (!"".equals(Sourc) && !"".equals(Dest) && Sourc != null && Dest != null) {
            try {
                File source = new File(Sourc);
                File dest = new File(Dest);
                //System.out.println("UploadPDF() s =" + source);
                //System.out.println("UploadPDF() d =" + dest);
                
                if(!Sourc.toUpperCase().matches("(.*)" + "192.168.1.32" + "(.*)")){
                    FileCopy.copyFile(source, dest);
                }
                return true;
            } catch (IOException e) {
                Eror.LogEror.SaveEror(e);
                ////System.err.println("E filecopy" + e);
                return false;
            }
        } else {
            return true;
        }
    }
}
