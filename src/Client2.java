import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) {
        try {
            // Создание сокета для подключения к серверу
            Socket socket = new Socket("localhost", 12345);

            // Получение входного и выходного потоков для сервера
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);

            // Получение сообщения от сервера (от клиента номер 1)
            String messageFromClient1 = serverReader.readLine();
            System.out.println("Сообщение от клиента номер 1: " + messageFromClient1);

            // Закрытие соединения и потоков
            serverReader.close();
            serverWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}