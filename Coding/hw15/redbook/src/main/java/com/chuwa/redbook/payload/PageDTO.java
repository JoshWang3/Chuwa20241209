package com.chuwa.redbook.payload;

import java.util.List;

public class PageDTO<T> {
    private Long queryId;

    private List<T> data;

    private long totalElements;

    private int totalPages;

    private boolean isLast;

    private boolean hasNext;

    private int number;

    private int startPage;

    private int pageSize;

    public PageDTO() {

    }

    public PageDTO(List<T> data, long totalElements, int totalPages, boolean isLast, boolean hasNext) {
        this.data = data;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.isLast = isLast;
        this.hasNext = hasNext;
    }

    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "queryId=" + queryId +
                ", data=" + data +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", isLast=" + isLast +
                ", hasNext=" + hasNext +
                ", number=" + number +
                ", startPage=" + startPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
