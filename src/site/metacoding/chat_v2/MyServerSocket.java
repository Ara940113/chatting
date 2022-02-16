package site.metacoding.chat_v2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MyServerSocket {

    // 리스너 (연결받기) - 메인스레드
    ServerSocket serverSocket;
    List<고객전담스레드> 고객리스트;

    // 서버는 메시지 받아서 보내기 (클라이언트 수마다)

    public MyServerSocket() {
        try {
            serverSocket = new ServerSocket(2000);
            고객리스트 = new Vector<>(); // Vector : 동기화가 처리된 ArrayList
            while (true) {
                Socket socket = serverSocket.accept(); // main 스레드
                System.out.println("클라이언트 연결됨");
                고객전담스레드 t = new 고객전담스레드(socket);
                고객리스트.add(t);

                System.out.println("고객리스트 크기 : " + 고객리스트.size());
                new Thread(t).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 내부 클래스
    class 고객전담스레드 implements Runnable {

        Socket socket;
        BufferedReader reader;
        BufferedWriter writer;
        boolean isLogin = true; // 연결해제가 됐을 때 try~catch 계속 안돌게

        public 고객전담스레드(Socket socket) {
            this.socket = socket;
            // new 될때마다 소켓 양쪽 끝단에 버퍼가 만들어짐
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            // 메인스레드한테 부담을 적게 주기 위해서는 버퍼를 여기에 만들어도 된다.
            // while을 위에달면 메인에 갇혀버린다! 새로운 실에 while 달아주자!!
            while (isLogin) {
                try {
                    String inputData = reader.readLine();
                    System.out.println("from 클라이언트 : " + inputData);

                    // 메시지 받았으니까 List<고객전담스레드> 고객리스트 <== 여기에 담긴
                    // 모든 클라이언트에게 메세지 전송 (for문 돌려서)
                    for (고객전담스레드 t : 고객리스트) { // 왼쪽 : 컬렉션 타입, 오른쪽 : 컬렉션
                        if (t != this) { // 자기자신에게도 메시지가 가지않게
                            t.writer.write(inputData + "\n");
                            t.writer.flush();
                        }

                    }

                } catch (Exception e) {

                    try {
                        System.out.println("통신실패:" + e.getMessage());
                        isLogin = false; // while을 빠져나가면 실이 종료
                        고객리스트.remove(this); // 고객리스트가 힙에 떠있으니까 지운다
                        reader.close();//
                        writer.close();// 안적어도 가비지컬렉션은 되지만 시간이 걸려 통신의 부하가 걸리기 때문에 미리 날린다
                        socket.close();// 통신은 i/o가 발생하니까
                    } catch (Exception e1) {
                        System.out.println("연결해제프로세스실패" + e1.getMessage());
                    }

                }

            }

        }

    }

    public static void main(String[] args) {
        new MyServerSocket();
    }
}