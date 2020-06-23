
package web_sever;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public  class Main
{
    ServerSocket serverSocket;
public static void main(String argv[]) throws IOException
{
    new Main().runServer();
    
}

    public void runServer() throws IOException{
        System.out.println("server start");
        serverSocket=new ServerSocket(4321);//port number
        acceptrequest();
    }
     private void acceptrequest() throws IOException{
         while(true){//to accept all request
        Socket s=serverSocket.accept();
        connection c=new connection(s);
        c.start();
         }
     }
}