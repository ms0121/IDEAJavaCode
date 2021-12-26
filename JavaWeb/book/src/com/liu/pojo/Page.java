package com.liu.pojo;

import java.awt.*;
import java.awt.print.Pageable;
import java.util.List;

/**
 * @author lms
 * @date 2021-04-05 - 10:57
 */
public class Page<T> {
    // 表示每页显示4个数据信息
    public static final Integer PAGE_SIZE = 4;
    // 当前页码
    private Integer pageNo;
    // 总的页码
    private Integer pageTotal;
    // 当前页显示的数量
    private Integer pageSize = PAGE_SIZE;
    // 总记录数量
    private Integer pageTotalCount;
    // 当前页数据
    private List<T> items;
    // 设置相应的url
    private String url;

    public Page() {

    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, Integer pageTotalCount, List<T> items, String url) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNo() {
        // /* 数据边界的有效检查 */
//        if (pageNo < 1) {
//            pageNo = 1;
//        }
//        if (pageNo > pageTotal) {
//            pageNo = pageTotal;
//        }

        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
//        if (pageNo < 1){
//            this.pageNo = 1;
//        }
//        if (pageNo > this.pageTotal){
//            this.pageNo = this.pageTotal;
//        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
