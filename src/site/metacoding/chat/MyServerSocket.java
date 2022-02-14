package site.metacoding.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

    ServerSocket serverSocket; // 리스너 (연결 =세션)
    Socket socket; // 메시지 통신
    BufferedReader reader;

    public MyServerSocket() {
        try {
            // 1. 서버소켓 생성 (리스너))
            // 잘 알려진 포트 0~1023
            serverSocket = new ServerSocket(1078); // 내부적으로 while이 돈다.
            System.out.println("서버소켓 생성됨");
            socket = serverSocket.accept(); // while을 돌면서 대기(랜덤포트) - 클라이언트가 접속할 때까지
            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String inputData = reader.readLine();
            System.out.println("받은메세지: " + inputData);
            System.out.println("클라이언트 연결됨");
        } catch (Exception e) {
            System.out.println("통신오류발생" + e.getMessage());
            // e.printStackTrace(); //어느파일에서 잘못됐는지 확인하려면.!
        }
    }

    public static void main(String[] args) {
        new MyServerSocket();
        System.out.println("메인종료");

    }
}