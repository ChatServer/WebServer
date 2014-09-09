/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 *
 * @author Ejer
 */
public class WebServer {

    static int port = 8080; //not the final port
    static String ip =  "127.0.0.1"; // not the final IP
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        InetSocketAddress i = new InetSocketAddress(ip, port); //localhost - 127.0.0.1
        HttpServer server = HttpServer.create(i,0);
        server.createContext("/startpage", new PagesHandler());  
        server.createContext("/online" , new OnlineHandler());
        server.createContext("/logfile" , new LogFileHandler());

        server.setExecutor(null);
        server.start();
        
    }
    
    static class PagesHandler implements HttpHandler {

            String content = "public/";

            @Override
            public void handle(HttpExchange he) throws IOException {

                File file = new File(content + "index.html");

                byte[] bytesToSend = new byte[(int) file.length()];
                try {
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                    bis.read(bytesToSend, 0, bytesToSend.length);
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
                he.sendResponseHeaders(200, bytesToSend.length);
                try (OutputStream os = he.getResponseBody()) {
                    os.write(bytesToSend, 0, bytesToSend.length);
                }

            }

        }
    
    

    static class OnlineHandler implements HttpHandler {

            String content = "public/";

            @Override
            public void handle(HttpExchange he) throws IOException {

                File file = new File(content + "html2.html");

                byte[] bytesToSend = new byte[(int) file.length()];
                try {
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                    bis.read(bytesToSend, 0, bytesToSend.length);
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
                he.sendResponseHeaders(200, bytesToSend.length);
                try (OutputStream os = he.getResponseBody()) {
                    os.write(bytesToSend, 0, bytesToSend.length);
                }

            }

        }
    
    static class LogFileHandler implements HttpHandler {

            String content = "public/";

            @Override
            public void handle(HttpExchange he) throws IOException {

                File file = new File(content + "html2.html");

                byte[] bytesToSend = new byte[(int) file.length()];
                try {
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                    bis.read(bytesToSend, 0, bytesToSend.length);
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
                he.sendResponseHeaders(200, bytesToSend.length);
                try (OutputStream os = he.getResponseBody()) {
                    os.write(bytesToSend, 0, bytesToSend.length);
                }

            }

        }
    
}
