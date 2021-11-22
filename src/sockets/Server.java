/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 002493781
 */
public class Server {
    
    private static final String[] doctores = {"Dr. Foreman", "Dr. Melendez", "Dr, Murphy", "Dr. House"};
    static int turno = 1;
    public static void main(String[] args) {
 
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        
 
        //puerto de nuestro servidor
        final int PUERTO = 5000;
 
        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            StringBuilder response;
            //Siempre estara escuchando peticiones
            while (true) {
                response = new StringBuilder();
                System.out.println("Esperando cliente... ");
 
                //Espero a que un cliente se conecte
                sc = servidor.accept();
 
                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
 
                //Leo el mensaje que me envia
                String mensaje = in.readUTF();
 
                System.out.println("Paciente: " + mensaje + " fue registrado exitosamente");
 
                response.append("Numero de turno: ").append(turno++).append("\n");
                response.append("Numero de seguro social: @nss \n");
                response.append("Nombre del paciente: ").append(mensaje).append("\n");
                response.append("Sintomas: @sintomas \n");
                response.append("Nombre del doctor: ").append(asignarDoctor()).append("\n");
                response.append("Numero de consultorio: ").append(String.valueOf((int) (Math.random() * 10 + 1)));
                
                //Le envio un mensaje
                out.writeUTF(response.toString());
 
                //Cierro el socket
                sc.close();
                System.out.println("Cliente desconectado");
 
            }
 
        } catch (Exception ex) {
            System.out.println("Exception: "+ ex.getMessage());
        }
 
    }
    
    private static String asignarDoctor(){
        int index = (int) (Math.random() * doctores.length);
        return doctores[index];
    }
    
}
