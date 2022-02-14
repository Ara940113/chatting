package site.metacoding.chat;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MyClientSocket {

    Socket socket;
    BufferedWriter writer;

    public MyClientSocket() {
        try {
            socket = new Socket("localhost", 1078);
            writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            writer.write("안녕\n"); // \n은 메세지의 끝을 알려주는것
            writer.flush(); // 버퍼에 담은후 물 내려주는것
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyClientSocket();
    }
}