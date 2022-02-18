package site.metacoding.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import site.metacoding.hospital.ResponseDto.Response.Body.Items.list;

public class HospitalDB {

    public static void main(String[] args) {
        List<Hospital> hospitalList = DownloadHospital.gethospitalList();
        try {
            // connection 연결
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
            System.out.println("db연결완료");

            // 버퍼
            String sql = "INSERT INTO hospital(addr,mgtStaDd,pcrPsblYn,ratPsblYn,"
                    + "recuClCd,RprtWorpClicFndtTgtYn,sgguCdNm,sidoCdNm,Telno,XPosWgs84,YPosWgs84,yadmNm,YKIHOENC)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            for (int i = 0; i < hospitalList.size(); i++) {
                pstmt.setString(1, hospitalList.get(i).getAddr());
                pstmt.setString(2, hospitalList.get(i).getMgtStaDd());
                pstmt.setString(3, hospitalList.get(i).getPcrPsblYn());
                pstmt.setString(4, hospitalList.get(i).getRatPsblYn());
                pstmt.setInt(5, hospitalList.get(i).getRecuClCd());
                pstmt.setString(6, hospitalList.get(i).getRprtWorpClicFndtTgtYn());
                pstmt.setString(7, hospitalList.get(i).getSgguCdNm());
                pstmt.setString(8, hospitalList.get(i).getSidoCdNm());
                pstmt.setString(9, hospitalList.get(i).getTelno());
                pstmt.setString(10, hospitalList.get(i).getXPosWgs84());
                pstmt.setString(11, hospitalList.get(i).getYPosWgs84());
                pstmt.setString(12, hospitalList.get(i).getYadmNm());
                pstmt.setString(13, hospitalList.get(i).getYkihoEnc());

                pstmt.executeUpdate();

            }

            // pstmt.executeQuery();
            System.out.println("통신끝");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            // e.printStackTrace();

        }

    }

}
