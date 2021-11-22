/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.Socket;

/**
 *
 * @author 002493781
 */
public class Client {
    public static void main(String[] args) {
 
        //Host del servidor
        final String HOST = "127.0.0.1";
        //Puerto del servidor
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;
 
        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, PUERTO);
 
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
 
            //Envio un mensaje al cliente
            out.writeUTF("¡Hola mundo desde el cliente!");
 
            //Recibo el mensaje del servidor
            String mensaje = in.readUTF();
 
            System.out.println(mensaje);
 
            sc.close();
 
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
 
    }
    
    public String sendMessages(String paciente) {
 
        //Host del servidor
        final String HOST = "127.0.0.1";
        //Puerto del servidor
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;
        
        String response = "";
 
        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, PUERTO);
 
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
 
            //Envio un mensaje al cliente
            out.writeUTF(paciente);
 
            //Recibo el mensaje del servidor
            response = in.readUTF();
 
            System.out.println(response);
 
            sc.close();
 
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        
        return response;
    }
    
}
