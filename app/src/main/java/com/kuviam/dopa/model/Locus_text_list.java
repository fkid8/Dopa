package com.kuviam.dopa.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "LOCUS_TEXT_LIST".
 */
public class Locus_text_list {

    private Long id;
    private long locusId;
    /** Not-null value. */
    private String item;

    public Locus_text_list() {
    }

    public Locus_text_list(Long id) {
        this.id = id;
    }

    public Locus_text_list(Long id, long locusId, String item) {
        this.id = id;
        this.locusId = locusId;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getLocusId() {
        return locusId;
    }

    public void setLocusId(long locusId) {
        this.locusId = locusId;
    }

    /** Not-null value. */
    public String getItem() {
        return item;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setItem(String item) {
        this.item = item;
    }

}
