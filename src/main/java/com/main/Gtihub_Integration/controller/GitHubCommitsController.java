package com.main.Gtihub_Integration.controller;

import com.main.Gtihub_Integration.entity.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/commits")
public class GitHubCommitsController {
    @Autowired
    CommonMethods  commonMethods;

    @Autowired
    RestTemplate restTemplate;

//____________________________________________________________List of commits ___________________________________________________________________________________________________

    @GetMapping("/repository/commit/list/{owner}/{repo}")
    public ResponseEntity<String> getListCommits(
            @PathVariable String owner,
            @PathVariable String repo) {


        HttpEntity<String> entity =  commonMethods.createHeadersEntity();

        return commonMethods.restTemplate.exchange(Constants.BASE_URL + "repos/" + owner +"/"+ repo + "/commits", HttpMethod.GET, entity, String.class);

    }
    //____________________________________________________________List branches for HEAD commit___________________________________________________________________________________________________


    @GetMapping("/repository/list/branches/headcommit/{owner}/{repo}/commits/{commit_sha}/branches-where-head")
    public ResponseEntity<String> getBranchesHeadCommits(
            @PathVariable String owner,
            @PathVariable String repo,
            @PathVariable String commit_sha) {

        HttpHeaders headers = commonMethods.createTokenHeaders();

        HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
      return restTemplate.exchange(
                Constants.BASE_URL + "repos/" + owner + "/" + repo +"/commits/" + commit_sha + "/branches-where-head",
                HttpMethod.GET, entity,  String.class);
    }
    //____________________________________________________________List pull requests associated with a commit ___________________________________________________________________________________________________

    @GetMapping("/repository/pull/request/{owner}/{repo}/commits/{commit_sha}")
    public ResponseEntity<String> pullRequestCommit(
            @PathVariable String owner,
            @PathVariable String repo,
            @PathVariable String commit_sha) {

        HttpHeaders headers = commonMethods.createTokenHeaders();

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
      return restTemplate.exchange(
                Constants.BASE_URL + "repos/" + owner + "/" + repo +"/commits/" + commit_sha + "/pulls",
                HttpMethod.GET, entity,  String.class);
    }
    //____________________________________________________________number of lines with a commit ___________________________________________________________________________________________________

    @GetMapping("/commit/lines/{owner}/{repo}/{commit_sha}")
    public ResponseEntity<String> commitlines(
            @PathVariable String owner,
            @PathVariable String repo,
            @PathVariable String commit_sha) {
                                                                            //additional api
        HttpHeaders headers = commonMethods.createTokenHeaders();

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.exchange(
                Constants.BASE_URL + "repos/" + owner + "/" + repo +"/commits/" + commit_sha ,
                HttpMethod.GET, entity,  String.class);
    }
    //____________________________________________________________Get a commit___________________________________________________________________________________________________

    @GetMapping("/getCommits/{owner}/{repo}/{ref}")
    public ResponseEntity<String> getCommit(
            @PathVariable String owner,
            @PathVariable String repo,
            @PathVariable String ref) {

        HttpHeaders headers = commonMethods.createTokenHeaders();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

       return restTemplate.exchange(
                Constants.BASE_URL + "repos/"+ owner +"/"+ repo +"/commits/"+ ref,
                HttpMethod.GET, entity,  String.class);
    }
    //____________________________________________________________Compare two commits___________________________________________________________________________________________________

    @GetMapping("/compare/commit/repository/{owner}/{repo}/{basehead}")
    public ResponseEntity<String> compareTwoCommit(
            @PathVariable String owner,
            @PathVariable String repo,
            @PathVariable String basehead) {

        HttpHeaders headers = commonMethods.createTokenHeaders();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

      return restTemplate.exchange(
                Constants.BASE_URL + "repos/"+ owner +"/"+ repo +"/compare/"+ basehead,
                HttpMethod.GET, entity,  String.class);
    }
    //**********************************pending*********************************

}
