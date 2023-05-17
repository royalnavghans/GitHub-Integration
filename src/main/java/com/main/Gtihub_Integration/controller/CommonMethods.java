package com.main.Gtihub_Integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.Gtihub_Integration.entity.Branch;
import com.main.Gtihub_Integration.entity.RepositoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommonMethods {

     @Autowired
     RestTemplate restTemplate;
     @Autowired
    ObjectMapper objectMapper;
    //____________________________________________________________create Headers Entity Method___________________________________________________________________________________________________

    public HttpEntity<String> createHeadersEntity() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        return new HttpEntity<>("parameters", headers);
    }
    //____________________________________________________________create token Headers Entity Method___________________________________________________________________________________________________

    public HttpHeaders createTokenHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer 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");
        headers.set("Accept", "application/vnd.github+json");
        headers.set("X-GitHub-Api-Version", "2022-11-28");

        return headers;
    }
    //____________________________________________________________create  Request Body for ref sha Method___________________________________________________________________________________________________

    public String createRequestBodyNewBranch(Branch branch) {

        // Prepare the request body
        return "{\"ref\":\"" + branch.getNew_name() + "\",\"sha\":\"" + branch.getSha() + "\"}";
    }

    //____________________________________________________________create  Request Body Method___________________________________________________________________________________________________

    public String createRequestBody(RepositoryRequest repositoryrequest) {

        // Prepare the request body
        return "{\"name\":\"" + repositoryrequest.getName() + "\",\"description\":\"" +
                repositoryrequest.getDescription() + "\",\"private\":" + repositoryrequest.isPrivate() + "}";
    }
    //____________________________________________________________create  Request Body for Name Method___________________________________________________________________________________________________

    public String createRequestBodyNewName(Branch branch) {
        // Prepare the request body
        return "{\"new_name\":\"" + branch.getNew_name() + "\"}";
    }
}
