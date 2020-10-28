package com.example.taskzostel;

public class UtmSourceInfo {

    public String utmSource;
    public String utmMedium;
    public String utmTerm;
    public String utmContent;
    public String utmCampaign;
    public String token;
    public UtmSourceInfo(){

    }
    public UtmSourceInfo(String utmSource, String utmMedium, String utmTerm, String utmContent, String utmCampaign,String token) {
        this.utmSource = utmSource;
        this.utmMedium = utmMedium;
        this.utmTerm = utmTerm;
        this.utmContent = utmContent;
        this.utmCampaign = utmCampaign;
        this.token = token;
    }

    public String getUtmCampaign() {
        return utmCampaign;
    }

    public void setUtmCampaign(String utmCampaign) {
        this.utmCampaign = utmCampaign;
    }

    public String getUtmSource() {
        return utmSource;
    }

    public void setUtmSource(String utmSource) {
        this.utmSource = utmSource;
    }

    public String getUtmMedium() {
        return utmMedium;
    }

    public void setUtmMedium(String utmMedium) {
        this.utmMedium = utmMedium;
    }

    public String getUtmTerm() {
        return utmTerm;
    }

    public void setUtmTerm(String utmTerm) {
        this.utmTerm = utmTerm;
    }

    public String getUtmContent() {
        return utmContent;
    }

    public void setUtmContent(String utmContent) {
        this.utmContent = utmContent;
    }

    @Override
    public String toString() {
        return "UtmSourceInfo{" +
                "utmSource='" + utmSource + '\'' +
                ", utmMedium='" + utmMedium + '\'' +
                ", utmTerm='" + utmTerm + '\'' +
                ", utmContent='" + utmContent + '\'' +
                ", utmCampaign='" + utmCampaign + '\'' +
                '}';
    }
}