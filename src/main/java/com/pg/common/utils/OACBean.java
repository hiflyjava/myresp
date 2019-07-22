package com.pg.common.utils;

import java.util.Arrays;
import java.util.List;

public class OACBean {


    public static final int SORT_TYPE_1 = 1;
    public static final int SORT_TYPE_2 = 2;
    public static final int SORT_TYPE_3 = 3;
    public static final int SORT_TYPE_4 = 4;
    public static final int SORT_TYPE_5 = 5;
    public static final int VERIFY_TYPE_1 = 1;
    public static final int VERIFY_TYPE_2 = 2;
    public static final int VERIFY_TYPE_3 = 3;
    public static final int VERIFY_TYPE_4 = 4;
    private static final int INIT_X_TIMES = 1;

    private String id;
    private String randomNumbersA;
    private String randomNumbersB;
    private String encode;
    private long createTime;
    private long startDate;
    private long endDate;
    private String arrayX;
    private String arrayY;
    private String randomNumbersC;
    private String randomNumbersD;
    private int sortType;
    private int verifyType;
    private String uuid;
    private String userEmail;
    private String password;
    private boolean byLongTerm;
    private List<String> arrayAList;
    private List<String> encodeList;
    private List<String> arrayXList;
    private List<String> arrayYList;
    private int xTimes = INIT_X_TIMES;
    private int yTimes;


    private String name;
    private String message;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRandomNumbersA() {
        return randomNumbersA;
    }

    public void setRandomNumbersA(String randomNumbersA) {
        this.randomNumbersA = randomNumbersA;
        this.arrayAList = Arrays.asList(randomNumbersA.split(","));
    }

    public String getRandomNumbersB() {
        return randomNumbersB;
    }

    public void setRandomNumbersB(String randomNumbersB) {
        this.randomNumbersB = randomNumbersB;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
        this.encodeList = Arrays.asList(encode.split(","));
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public List<String> getArrayAList() {
        return arrayAList;
    }

    public void setArrayAList(List<String> arrayAList) {
        this.arrayAList = arrayAList;
    }

    public String getArrayX() {
        return arrayX;
    }

    public void setArrayX(String arrayX) {
        this.arrayX = arrayX;
        this.arrayXList = Arrays.asList(arrayX.split(","));
    }

    public String getArrayY() {
        return arrayY;
    }

    public void setArrayY(String arrayY) {
        this.arrayY = arrayY;
        this.arrayYList = Arrays.asList(arrayY.split(","));
    }

    public String getRandomNumbersC() {
        return randomNumbersC;
    }

    public void setRandomNumbersC(String randomNumbersC) {
        this.randomNumbersC = randomNumbersC;
    }

    public String getRandomNumbersD() {
        return randomNumbersD;
    }

    public void setRandomNumbersD(String randomNumbersD) {
        this.randomNumbersD = randomNumbersD;
    }

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    public int getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(int verifyType) {
        this.verifyType = verifyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isByLongTerm() {
        return byLongTerm;
    }

    public void setByLongTerm(boolean byLongTerm) {
        this.byLongTerm = byLongTerm;
    }

    public List<String> getEncodeList() {
        return encodeList;
    }

    public void setEncodeList(List<String> encodeList) {
        this.encodeList = encodeList;
    }

    public List<String> getArrayXList() {
        return arrayXList;
    }

    public void setArrayXList(List<String> arrayXList) {
        this.arrayXList = arrayXList;
    }

    public List<String> getArrayYList() {
        return arrayYList;
    }

    public void setArrayYList(List<String> arrayYList) {
        this.arrayYList = arrayYList;
    }

    public int getxTimes() {
        return xTimes;
    }

    public void setxTimes(int xTimes) {
        this.xTimes = xTimes;
    }

    public int getyTimes() {
        return yTimes;
    }

    public void setyTimes(int yTimes) {
        this.yTimes = yTimes;
    }

}
