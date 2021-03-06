package site.metacoding.chat_v2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClientSocket {

    Socket socket;

    // 스레드 (키보드로 받아서 바로 쓸 스레드)
    BufferedWriter writer;
    Scanner sc;

    // 스레드 (읽는 스레드)
    BufferedReader reader;

    public MyClientSocket() {
        try {
            socket = new Socket("192.168.0.132", 2000); // 1번 소켓 연결 127.0.0.1 : 루프백 주소 자기주소

            // 2번 버퍼연결
            sc = new Scanner(System.in);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 새로운 스레드는 (읽기전용) - 메인스레드보다 나중에 나오면 메인은 와일을 돌거기 때문에 안온다.
            new Thread(new 읽기전담스레드()).start();

            // 메인스레드 (쓰기전용)
            while (true) {
                String keyboardInputData = sc.nextLine();
                writer.write(keyboardInputData + "\n"); // 버퍼에 담기
                writer.flush(); // 버퍼에 담긴 것을 stream으로 흘려보내기 - 통신의 시작
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 내부클래스로 만드면 좋은점 : 전역변수를 다 쓸 수 있다.
    class 읽기전담스레드 implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    String inputData = reader.readLine();
                    System.out.println("받은 메시지 : " + inputData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new MyClientSocket();
    }
}
