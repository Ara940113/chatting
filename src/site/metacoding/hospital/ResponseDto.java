package site.metacoding.hospital;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDto {
    private Response response;

    @AllArgsConstructor
    @Data
    class Response {
        private Header header;
        private Body body;

        @AllArgsConstructor
        @Data
        class Header {
            private String resultCode;
            private String resultMsg;
        }

        @AllArgsConstructor
        @Data
        class Body {
            private Items items;
            private int numOfRows;
            private int pageNo;
            private int totalCount;

            @AllArgsConstructor
            @Data
            class Items {
                private List<list> item;

                @AllArgsConstructor
                @Data
                class list {
                    private String addr; // 주소
                    private String mgtStaDd; // 운영시작일자
                    private String pcrPsblYn; // pcr가능여부
                    private String ratPsblYn; // rat가능여부
                    private int recuClCd; // 요양종별코드
                    private String rprtWorpClicFndtTgtYn; // 요양종별코드
                    private String sgguCdNm; // 시군구명
                    private String sidoCdNm; // 시도명
                    private String telno; // 전화번호
                    private String XPosWgs84; // 세계지구 x좌표
                    private String YPosWgs84; // 세계지구 y좌표
                    private String yadmNm; // 요양기관명
                    private String ykihoEnc; // 암호화된 요양기호

                }
            }
        }
    }

}
