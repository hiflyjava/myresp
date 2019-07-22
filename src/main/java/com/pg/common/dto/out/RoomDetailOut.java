package com.pg.common.dto.out;

/**
 * @Auther: admin
 * @Date: 2019/6/5 17:16
 * @Description:
 */
public class RoomDetailOut {


    private Integer bedroom;

    private Integer beds;

    private Integer bathroom;

    private Integer uptopeople;

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public Integer getUptopeople() {
        return uptopeople;
    }

    public void setUptopeople(Integer uptopeople) {
        this.uptopeople = uptopeople;
    }

    public Integer getBedroom() {
        return bedroom;
    }

    public void setBedroom(Integer bedroom) {
        this.bedroom = bedroom;
    }
}
