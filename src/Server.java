import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Создание серверного сокета для прослушивания клиентов
            ServerSocket serverSocket = new ServerSocket(12345);

            System.out.println("Сервер запущен и ожидает подключения клиентов...");

            // Ожидание подключения клиента номер 1
            Socket client1Socket = serverSocket.accept();
            System.out.println("Клиент номер 1 подключился.");

            // Ожидание подключения клиента номер 2
            Socket client2Socket = serverSocket.accept();
            System.out.println("Клиент номер 2 подключился.");

            // Получение входного и выходного потоков для клиентов
            BufferedReader client1Reader = new BufferedReader(new InputStreamReader(client1Socket.getInputStream()));
            PrintWriter client2Writer = new PrintWriter(client2Socket.getOutputStream(), true);

            // Чтение сообщения от клиента номер 1
            String messageFromClient1 = client1Reader.readLine();
            System.out.println("Сообщение от клиента номер 1: " + messageFromClient1);

            // Передача сообщения от клиента номер 1 клиенту номер 2
            client2Writer.println(messageFromClient1);
            System.out.println("Сообщение успешно передано клиенту номер "+messageFromClient1);

            // Закрытие соединений и потоков
            client1Reader.close();
            client2Writer.close();
            client1Socket.close();
            client2Socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}