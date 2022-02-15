package site.metacoding.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServerSocket {

    ServerSocket serverSocket; // 리스너 (연결 =세션)
    Socket socket; // 메시지 통신
    BufferedReader reader;

    // 추가(클라이언트에게 메세지 보내기)
    BufferedWriter writer;
    Scanner sc;

    public MyServerSocket() {
        try {
            // 1. 서버소켓 생성 (리스너))
            // 잘 알려진 포트 0~1023
            serverSocket = new ServerSocket(1078); // 내부적으로 while이 돈다.
            System.out.println("서버소켓 생성됨");
            socket = serverSocket.accept(); // while을 돌면서 대기(랜덤포트) - 클라이언트가 접속할 때까지
            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // 메시지 보내기
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            sc = new Scanner(System.in);
            // 메시지 반복해서 받는 서버 소켓
            while (true) {
                String inputData = reader.readLine();
                System.out.println("받은메세지: " + inputData);

            }

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
