package com.example.demo.domain.page;

import java.util.HashMap;

/**
 * Created by zhuxin5 on 2018/3/20.
 */
public class DBQueryRequest extends HashMap {

    private Pagination page;

    public Pagination getPage() {
        return page;
    }

    /**
     *
     * setter of page
     * @param page
     *
     **/
    public void setPage(Pagination page) {
        this.page = page;
        this.put("page",page);
    }
}
