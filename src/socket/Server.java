/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Equipo 6
 */
public class Server {
    
    private static ArrayList<ClientHandler> clientes = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        ServerSocket ss = new ServerSocket(7777);
        
        while (true) {
            System.out.println("ServerSocket awaiting connections...");
            Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
            
            ClientHandler clietntHandler = new ClientHandler(socket);
            clientes.add(clietntHandler);
            
            pool.execute(clietntHandler);
        }
        
    }
    
}
