package com.mycompany.socket;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        try {
            String link = JOptionPane.showInputDialog("");
            int porta = Integer.parseInt(JOptionPane.showInputDialog(""));
            Socket sock = new Socket(link, porta);
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String linha = "";
            out.println("GET / HTTP/1.0\n");
            while ((linha = in.readLine()) != null) {
                System.out.println("echo: " + linha);
            }
        } catch (IOException e) {
            System.err.println("Problemas de IO");
        }
    }
}