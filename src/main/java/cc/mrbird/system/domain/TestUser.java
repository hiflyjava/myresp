package cc.mrbird.system.domain;

import java.io.Serializable;

public class TestUser implements Serializable {



     private String  userName;
     private String  userDep;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDep() {
        return userDep;
    }

    public void setUserDep(String userDep) {
        this.userDep = userDep;
    }
}
