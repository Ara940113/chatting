package site.metacoding.hospital;

import java.util.List;
import java.util.Scanner;

import site.metacoding.hospital.ResponseDto.Response.Body.Items.list;

public class MainHospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // System.out.println("=====시,도를 입력하세여 ========");
        // System.out.println("ex) 부산");
        // String sido = sc.nextLine();
        System.out.println("=====지역 입력하세여 ========");
        System.out.println("ex) 사상구");
        String SgguCdNm = sc.nextLine();

        List<Hospital> pcrList = DownloadHospital.gethospitalList();

        for (int i = 0; i < pcrList.size(); i++) {
            if (SgguCdNm.equals(pcrList.get(i).getSgguCdNm())) {
                System.out.println("===========================");
                System.out.println("시,도 : " + pcrList.get(i).getSidoCdNm());
                System.out.println("시,군,구 : " + pcrList.get(i).getSgguCdNm());
                System.out.println("병원 : " + pcrList.get(i).getYadmNm());
                System.out.println("주소 : " + pcrList.get(i).getAddr());
                System.out.println("운영시작일자 : " + pcrList.get(i).getMgtStaDd());
                System.out.println("pcr가능여부 : " + pcrList.get(i).getPcrPsblYn());
                System.out.println("rat가능여부 : " + pcrList.get(i).getRatPsblYn());
            }

        }
    }
}