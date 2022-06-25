package Control;

import java.net.*;
import java.time.LocalDate;

import static View.Collection.Cli;

import java.io.*;
import java.util.*;

import Model.Client;
import Model.GymClasses;
import Model.MemberShip;
import Model.Trainer;
import View.FirstChoice;
import View.Collection;
import View.userFunc;

public class ServerNetwork {
        public static void main(String[] args) throws IOException{
                ServerSocket serverSocket = null;
                Socket clientSocket = null;
                try {
                        serverSocket = new ServerSocket(5000);
                } catch (IOException e) {
                        System.err.println("Could not listen on port: 5000.");
                        System.exit(1);
                }
                while(true) {
                try {
                        clientSocket = serverSocket.accept();
                } catch (IOException e) {
                        System.err.println("Accept failed.");
                        System.exit(1);
                }
                Routing ClientR = new Routing(clientSocket);
                ClientR.start();
                }
        }

}