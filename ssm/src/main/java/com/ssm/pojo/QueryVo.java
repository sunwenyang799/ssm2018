package com.ssm.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 16:08 2020/8/16
 * @ Description：包装user的对象
 */
public class QueryVo implements Serializable {

    private User user;

    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
