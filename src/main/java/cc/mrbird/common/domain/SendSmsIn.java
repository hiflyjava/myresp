package cc.mrbird.common.domain;

import java.util.List;

public class SendSmsIn {

   private   String accesskey;
   private  String accessSecret;
   private List<String> mobiles;//群发的号码
   private String sendContent;//发送内容

    private String sign;//签名模板

    private String sendUrl;

    private String getBalanceUrl;


    public String getGetBalanceUrl() {
        return getBalanceUrl;
    }

    public void setGetBalanceUrl(String getBalanceUrl) {
        this.getBalanceUrl = getBalanceUrl;
    }

    public String getSendUrl() {
        return sendUrl;
    }

    public void setSendUrl(String sendUrl) {
        this.sendUrl = sendUrl;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAccesskey() {
        return accesskey;
    }

    public void setAccesskey(String accesskey) {
        this.accesskey = accesskey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public List<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
    }

    public String getSendContent() {
        return sendContent;
    }

    public void setSendContent(String sendContent) {
        this.sendContent = sendContent;
    }
}
