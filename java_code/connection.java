/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_sever;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author vip
 */
public class connection extends Thread{
    Socket s;
    PrintWriter sendoutput;//to send output to client
   BufferedReader getinput;//to get input from client

    public connection( Socket s) throws IOException {
        this.s=s;
        getinput=new BufferedReader(new InputStreamReader(s.getInputStream()));
        sendoutput=new PrintWriter(s.getOutputStream());
    }

    @Override
    public void run() {
        String request="";
        try {
            while (getinput.ready()||request.length()==0) {  request+=(char)getinput.read();}
                    
             System.out.println(request);
            httprequest rq=new httprequest(request);
            httpresponse rs=new httpresponse(rq);
            sendoutput.write(rs.response.toCharArray());
            sendoutput.close();
            getinput.close();
            s.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }
 
}
