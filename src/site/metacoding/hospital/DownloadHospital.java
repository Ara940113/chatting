package site.metacoding.hospital;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import site.metacoding.hospital.ResponseDto.Response.Body.Items.list;

public class DownloadHospital {

    public static List<Hospital> gethospitalList(
    // String sgguCdNm
    ) {
        List<Hospital> hospitalList = new ArrayList<>();
        try {
            URL url = new URL(
                    "http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService?serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D&pageNo=1&numOfRows=5190&_type=json");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

            String responseJson = br.readLine();
            Gson gson = new Gson();
            ResponseDto dto = gson.fromJson(responseJson, ResponseDto.class);

            List<list> result = dto.getResponse().getBody().getItems().getItem();
            // System.out.println(result);

            int totalCount = dto.getResponse().getBody().getTotalCount();

            url = new URL(
                    "http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService?serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D&pageNo=1&numOfRows=5190&_type=json");

            conn = (HttpURLConnection) url.openConnection();

            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

            responseJson = br.readLine();
            gson = new Gson();
            dto = gson.fromJson(responseJson, ResponseDto.class);

            result = dto.getResponse().getBody().getItems().getItem();

            // 컬렉션 어떻게 담지?
            for (int i = 0; i < result.size(); i++) {
                Hospital hospital = new Hospital(
                        result.get(i).getAddr(),
                        result.get(i).getMgtStaDd(),
                        result.get(i).getPcrPsblYn(),
                        result.get(i).getRatPsblYn(),
                        result.get(i).getRecuClCd(),
                        result.get(i).getRprtWorpClicFndtTgtYn(),
                        result.get(i).getSgguCdNm(),
                        result.get(i).getSidoCdNm(),
                        result.get(i).getTelno(),
                        result.get(i).getXPosWgs84(),
                        result.get(i).getYPosWgs84(),
                        result.get(i).getYadmNm(),
                        result.get(i).getYkihoEnc());

                hospitalList.add(hospital);

            }

            return hospitalList;

        } catch (Exception e) {
            System.out.println("검사기관 조회중 오류가 발생하였습니다.");
        }
        return null;
    }
}