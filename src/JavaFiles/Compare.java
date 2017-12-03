/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Harshit
 */
class Compare {
    Compare(File file1, File file2){
        f1 = file1;
        f2 = file2;
    }
    boolean compare(){
        if(f1.compareTo(f2) == 0)
            return true;
        else{
            int il=0;
            char c1,c2;
            double i=0,j=0,k=0;
            try(FileInputStream fin1 = new FileInputStream(f1);FileInputStream fin2 = new FileInputStream(f2)){
                do{
                    il++;
                    c1=(char)fin1.read();
                    c2=(char)fin2.read();
                    if(c1=='A'||c1=='T'||c1=='G'||c1=='C'||c2=='A'||c2=='T'||c2=='G'||c2=='C'){
                        if(c1!=c2)
                            i+=1;
                        if(c1!=-1)
                            j+=1;
                        if(c2!=-1)
                            k+=1;
                    }
                    else
                        break;
                }while(c1!=-1||c2!=-1);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Invalid File!","Error!",JOptionPane.ERROR_MESSAGE);
            }
            if(j>k)
                return (((j-k)/j)*100)>98;
            else{ 
                if(j<k)
                    return (((k-j)/k)*100)>98;
                else{
                    if(j==k)
                        return (((k-i)*100)/k)>98;
                }
            }
        }
        return false;
    }
    
    //variable decleration
    private final File f1;
    private final File f2;
    //end of variable decleration
}