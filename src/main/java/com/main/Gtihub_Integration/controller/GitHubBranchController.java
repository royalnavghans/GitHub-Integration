package com.main.Gtihub_Integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.Gtihub_Integration.entity.Branch;
import com.main.Gtihub_Integration.entity.Commit;
import com.main.Gtihub_Integration.entity.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/branch")
public class GitHubBranchController {

    @Autowired
    CommonMethods commonMethods;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;
    //____________________________________________________________List branches___________________________________________________________________________________________________

    @GetMapping("/List/{owner}/{repo}")
    public ResponseEntity<String> getListBranches(
            @PathVariable String owner,
            @PathVariable String repo) {


        HttpHeaders headers = commonMethods.createTokenHeaders();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        return restTemplate.exchange(Constants.BASE_URL + "repos/" + owner + "/" + repo + "/branches", HttpMethod.GET, entity, String.class);
    }
    //____________________________________________________________find particular branch___________________________________________________________________________________________________

    @GetMapping("/find/{owner}/{repo}/{branch}")
    public ResponseEntity<String> getBranch(
            @PathVariable String owner,
            @PathVariable String repo,
            @PathVariable String branch) {


        HttpEntity<String> entity = commonMethods.createHeadersEntity();

        return restTemplate.exchange(Constants.BASE_URL + "repos/" + owner + "/" + repo + "/branches/" + branch, HttpMethod.GET, entity, String.class);
    }
    //____________________________________________________________rename particular branch___________________________________________________________________________________________________

    @PostMapping("/rename/{owner}/{repo}/{branch}")
    public ResponseEntity<String> RenameBranch(
            @PathVariable String owner,
            @PathVariable String repo,
            @PathVariable String branch,
            @RequestBody Branch branchClass) throws JsonProcessingException {

        HttpHeaders headers = commonMethods.createTokenHeaders();
        String requestBody = objectMapper.writeValueAsString(branchClass);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        return restTemplate.exchange(Constants.BASE_URL + "repos/" + owner + "/" + repo + "/branches/" + branch + "/rename", HttpMethod.POST, entity, String.class);
    }
    //____________________________________________________________create org branch___________________________________________________________________________________________________

    @PostMapping("/create/{owner}/{repo}")
    public ResponseEntity<String> createBranch(
            @PathVariable String owner,
            @PathVariable String repo,
            @RequestBody Branch branchClass
    ) throws JsonProcessingException {

        HttpHeaders headers = commonMethods.createTokenHeaders();
        String requestBody = objectMapper.writeValueAsString(branchClass);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        System.out.println(requestBody);


        return restTemplate.exchange(Constants.BASE_URL + "repos/" + owner + "/" + repo + "/git/refs", HttpMethod.POST, entity, String.class);
    }
}
//____________________________________________________________Merge a branch___________________________________________________________________________________________________

//    @PostMapping("/repos/{owner}/{repo}/merges")
//    public ResponseEntity<String> mergeBranch(
//            @PathVariable String owner,
//            @PathVariable String repo) {
//         
//        HttpHeaders headers = createTokenHeaders();
//        String resposeBody = createRequestBodyNewName();
//        HttpEntity<String> entity =  new HttpEntity<>(resposeBody, headers);
//
//
//        ResponseEntity<String> result = restTemplate.exchange( Constants.BASE_URL + "repos/" + owner +"/"+ repo + "/branches/"+ branch + "/rename", HttpMethod.POST, entity, String.class);
//        return result;
//    }


