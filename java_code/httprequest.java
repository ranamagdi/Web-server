/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_sever;

/**
 *
 * @author vip
 */
public class httprequest {
String filename;
    public httprequest() {  }

    httprequest(String request) {
         String lines[]=request.split("\n");
         filename=lines[0].split(" ")[1];
    }
    
}
