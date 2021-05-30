package tester;

import core.NetworkThread;

import java.util.logging.Logger;

public class ClientMainProva1 {

    private static int port = 25565;
    public static Logger clientLogger = Logger.getLogger("ClientLogger");


    public static void main(String[] args) {

        clientLogger.info("Client starting");
        startGui();
        startConnection(port);
        clientLogger.info("Startup Successful");

    }

    private static void startGui(){
        //TODO ISTANZIA CLASSE
    }

    private static void startConnection(int port){

        NetworkThread networkThread = new NetworkThread(port);
        networkThread.start();

    }

}
