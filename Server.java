package pik8;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {
    public static void main(String[] args) throws IOException {
        int number;
        ServerSocket server = new ServerSocket(1212);
        Socket socket = server.accept();
        Scanner scan = new Scanner(socket.getInputStream());
        number = scan.nextInt();
        PrintStream printout = new PrintStream(socket.getOutputStream());
        printout.println("your number is "+number);
        server.close();
        scan.close();
    }
}
