package site.metacoding.hospital;

public class Hospital {
    private String addr; // 주소
    private String mgtStaDd; // 운영시작일자
    private String pcrPsblYn; // pcr가능여부
    private String ratPsblYn; // rat가능여부
    private int recuClCd; // 요양종별코드
    private String rprtWorpClicFndtTgtYn;
    private String sgguCdNm; // 시군구명
    private String sidoCdNm; // 시도명
    private String telno;
    private String XPosWgs84; // 세계지구 x좌표
    private String YPosWgs84; // 세계지구 y좌표
    private String yadmNm; // 요양기관명
    private String ykihoEnc; // 암호화된 요양기호

    public Hospital(
            String addr, // 주소
            String mgtStaDd, // 운영시작일자
            String pcrPsblYn, // pcr가능여부
            String ratPsblYn, // rat가능여부
            int recuClCd, // 요양종별코드
            String rprtWorpClicFndtTgtYn,
            String sgguCdNm, // 시군구명
            String sidoCdNm, // 시도명
            String telno,
            String XPosWgs84, // 세계지구 x좌표
            String YPosWgs84, // 세계지구 y좌표
            String yadmNm, // 요양기관명
            String ykihoEnc // 암호화된 요양기호
    ) {
        this.addr = addr;
        this.mgtStaDd = mgtStaDd;
        this.ratPsblYn = ratPsblYn;
        this.pcrPsblYn = pcrPsblYn;
        this.recuClCd = recuClCd;
        this.rprtWorpClicFndtTgtYn = rprtWorpClicFndtTgtYn;
        this.sgguCdNm = sgguCdNm;
        this.sidoCdNm = sidoCdNm;
        this.telno = telno;
        this.XPosWgs84 = XPosWgs84;
        this.YPosWgs84 = YPosWgs84;
        this.yadmNm = yadmNm;
        this.ykihoEnc = ykihoEnc;

    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMgtStaDd() {
        return mgtStaDd;
    }

    public void setMgtStaDd(String mgtStaDd) {
        this.mgtStaDd = mgtStaDd;
    }

    public String getPcrPsblYn() {
        return pcrPsblYn;
    }

    public void setPcrPsblYn(String pcrPsblYn) {
        this.pcrPsblYn = pcrPsblYn;
    }

    public String getRatPsblYn() {
        return ratPsblYn;
    }

    public void setRatPsblYn(String ratPsblYn) {
        this.ratPsblYn = ratPsblYn;
    }

    public int getRecuClCd() {
        return recuClCd;
    }

    public void setRecuClCd(int recuClCd) {
        this.recuClCd = recuClCd;
    }

    public String getRprtWorpClicFndtTgtYn() {
        return rprtWorpClicFndtTgtYn;
    }

    public void setRprtWorpClicFndtTgtYn(String rprtWorpClicFndtTgtYn) {
        this.rprtWorpClicFndtTgtYn = rprtWorpClicFndtTgtYn;
    }

    public String getSgguCdNm() {
        return sgguCdNm;
    }

    public void setSgguCdNm(String sgguCdNm) {
        this.sgguCdNm = sgguCdNm;
    }

    public String getSidoCdNm() {
        return sidoCdNm;
    }

    public void setSidoCdNm(String sidoCdNm) {
        this.sidoCdNm = sidoCdNm;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getXPosWgs84() {
        return XPosWgs84;
    }

    public void setXPosWgs84(String xPosWgs84) {
        XPosWgs84 = xPosWgs84;
    }

    public String getYPosWgs84() {
        return YPosWgs84;
    }

    public void setYPosWgs84(String yPosWgs84) {
        YPosWgs84 = yPosWgs84;
    }

    public String getYadmNm() {
        return yadmNm;
    }

    public void setYadmNm(String yadmNm) {
        this.yadmNm = yadmNm;
    }

    public String getYkihoEnc() {
        return ykihoEnc;
    }

    public void setYkihoEnc(String ykihoEnc) {
        this.ykihoEnc = ykihoEnc;
    }

}
