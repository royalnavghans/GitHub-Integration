package com.main.Gtihub_Integration.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Branch {

    String new_name;
    String ref;
    String sha;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = "refs/heads/" + ref;
    }

    public String getNew_name() {
        return new_name;
    }

    public void setNew_name(String new_name) {
        this.new_name = new_name;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

}
