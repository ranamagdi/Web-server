/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_sever;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vip
 */
public class httpresponse {
httprequest rq;String notfound="C:\\Users\\vip\\Documents\\NetBeansProjects\\web_sever\\src\\web_sever\\notfound.html";
String response;File root=new File("C:\\Users\\vip\\Documents\\NetBeansProjects\\web_sever\\src\\web_sever");
  File root1=new File(notfound);
    httpresponse(httprequest rq) throws FileNotFoundException, IOException, InterruptedException {
        this.rq=rq;
       File file = new File(root,rq.filename);
       
        
    try {
        response="HTTP/1.1 200\r\n";
        response+="server:out java server/1.0\r\n";
        response+="content-type:text/html \r\n";
        response+="connection-close  \r\n";
        response+="content-length:"+file.length()+ "\r\n";
        response+= "\r\n";
        FileInputStream finput=new FileInputStream(file);
        int l; 
        while ((l=finput.read())!=-1) {
           response+=(char) l;
            
        }
        finput.close();
    } catch (FileNotFoundException ex) {
       
        response="HTTP/1.1 404\r\n";
        response+="server:out java server/1.0\r\n";
        response+="content-type:text/html \r\n";
        response+="connection-close  \r\n";
        response+="content-length:"+root1.length()+ "\r\n";
        response+= "\r\n";
        FileInputStream finput1=new FileInputStream(root1);
        int l; 
        while ((l=finput1.read())!=-1) {
           response+=(char) l;
            
        }
        finput1.close();
        
       
    }
    catch(Exception ex){
         response=response.replace("200", "500");
    }
    }
    
}
