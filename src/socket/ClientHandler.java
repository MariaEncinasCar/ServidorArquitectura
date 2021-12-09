/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import blackboard.Blackboard;
import control.Control;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Andrea
 */
public class ClientHandler implements Runnable {
    
    private Socket socket;
    private ObjectInputStream flujoEntradaDatos;
    private ObjectOutputStream flujoSalidaDatos;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.flujoEntradaDatos = new ObjectInputStream(socket.getInputStream());
        this.flujoSalidaDatos = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        String jsonAtrapa="";
        String envia="";
        try {
            while (true) {

                // read the list of messages from the socket
                jsonAtrapa = (String) flujoEntradaDatos.readObject();

                if (jsonAtrapa.equalsIgnoreCase("terminar")) {
                    break;
                }

                Blackboard blackboard = new Blackboard(jsonAtrapa);
                Control control = new Control(blackboard);

                envia = control.getAgente();

                flujoSalidaDatos.writeObject(envia);

                flujoSalidaDatos.flush();

            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        } finally {
            try {
                System.out.println("Closing sokets from server side.");
                flujoEntradaDatos.close();
                flujoSalidaDatos.close();
            } catch (IOException ex1) {
                System.out.println(ex1);
            }
        }
    }

}
