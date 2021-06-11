package eGov.home.board.domain;

/**
 * @Class Name : BoardVO.java
 * @Description : Board VO class
 * @Modification Information
 *
 * @author fkfkfk9
 * @since 2021-06-11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class BoardVO extends BoardDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** seqno */
    private int seqno;
    
    /** title */
    private java.lang.String title;
    
    /** subtitle */
    private java.lang.String subtitle;
    
    /** content */
    private java.lang.String content;
    
    /** writer */
    private java.lang.String writer;
    
    public int getSeqno() {
        return this.seqno;
    }
    
    public void setSeqno(int seqno) {
        this.seqno = seqno;
    }
    
    public java.lang.String getTitle() {
        return this.title;
    }
    
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    
    public java.lang.String getSubtitle() {
        return this.subtitle;
    }
    
    public void setSubtitle(java.lang.String subtitle) {
        this.subtitle = subtitle;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
    public java.lang.String getWriter() {
        return this.writer;
    }
    
    public void setWriter(java.lang.String writer) {
        this.writer = writer;
    }
    
}
