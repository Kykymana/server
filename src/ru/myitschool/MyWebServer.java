package ru.myitschool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyWebServer {
    public static void print(String html, PrintStream out){
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");
        out.println();
        out.println("<h1> Hello world! <h1>");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8000);
        System.out.println("Started");
        while(true){
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            Scanner sc = new Scanner(is);
            OutputStream os = s.getOutputStream();
            PrintStream out = new PrintStream(os);
            print("<h1>Hello</h1>", out);
            s.close();
        }
    }
}
