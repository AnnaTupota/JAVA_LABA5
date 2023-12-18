import java.io.*;
import java.net.*;

public class Client1 {
    public static void main(String[] args) {
        try {
            // Создание сокета для подключения к серверу
            Socket socket = new Socket("localhost", 12345);

            // Получение входного и выходного потоков для сервера
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            System.out.print("Введите информацию для отправки на сервер: ");
            while ((userInput = stdIn.readLine()) != null) { // Чтение информации от пользователя
                serverWriter.println(userInput); // Отправка информации на сервер

                String serverResponse =  serverReader.readLine(); // Ожидание ответа от сервера
                System.out.println("От сервера получено: " + serverResponse);

                System.out.print("Введите информацию для отправки на сервер: ");
            }

            // Закрытие соединения и потоков
            serverReader.close();
            serverWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}