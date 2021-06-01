package core;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import static tester.ClientMainProva1.clientLogger;

public class NetworkThread extends Thread {

    private Socket socket;
    private int port;
    private PrintWriter socketOutput = null;
    private BufferedReader socketInput = null;

    public NetworkThread(int port) {
        this.port = port;
    }

    @Override
    public void run() {

        try {
            this.socket = new Socket("2.36.254.212", port);
            clientLogger.info("Connection established");
        } catch (IOException e) {
            clientLogger.info("Impossible to establish connection to:" + socket.getInetAddress());
        }

        try {
            socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketOutput = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        } catch (IOException e) {
            clientLogger.info("I/O Error");
        }

        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;

        while (true) {

            try {
                msg = tastiera.readLine();
                System.out.println(msg);
                socketOutput.println(msg);
                System.out.println(msg+"inviato");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}