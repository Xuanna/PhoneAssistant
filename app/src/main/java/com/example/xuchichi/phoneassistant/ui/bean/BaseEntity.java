package com.example.xuchichi.phoneassistant.ui.bean;

import java.io.Serializable;

/**
 * 菜鸟窝http://www.cniao5.com 一个高端的互联网技能学习平台
 *
 * @author Ivan
 * @version V1.0
 * @Package com.cniao5.cniao5play.bean
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date
 */

public class BaseEntity implements Serializable {


    public static final int SUCCESS = 1;
    private int status;

    private String message;

    public static int getSUCCESS() {
        return SUCCESS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
