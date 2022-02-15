package site.metacoding.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClientSocket {

    Socket socket;
    BufferedWriter writer;

    public MyClientSocket() {
        try {
            socket = new Socket("localhost", 1078);
            writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            // 스캐너 달고 반복 (x)
            Scanner sc = new Scanner(System.in);
            // 키보드로 입력받는 부분
            while (true) {
                String inputData = sc.nextLine();
                writer.write(inputData + "\n"); // \n은 메세지의 끝을 알려주는것
                writer.flush(); // 버퍼에 담은후 물 내려주는것

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyClientSocket();
    }
}