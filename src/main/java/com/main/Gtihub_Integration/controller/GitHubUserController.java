package com.main.Gtihub_Integration.controller;

import com.main.Gtihub_Integration.entity.Branch;
import com.main.Gtihub_Integration.entity.Constants;
import com.main.Gtihub_Integration.entity.RepositoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class GitHubUserController {

    @Autowired
    CommonMethods CommonMethods;
    @Autowired
    RestTemplate restTemplate;
    //____________________________________________________________get user___________________________________________________________________________________________________
    @GetMapping("findUser/{userName}")
    public ResponseEntity<String> getUserInfo(@PathVariable String userName) {
         
        HttpEntity<String> entity = CommonMethods.createHeadersEntity();
        return restTemplate.exchange(Constants.BASE_URL + "users/" + userName, HttpMethod.GET, entity, String.class);
    }

    //____________________________________________________________repositories of Authenticated user___________________________________________________________________________________________________
    @GetMapping("/repositories")
    public ResponseEntity<String> getRepoOfAuthenticatedUser() {
         

        HttpHeaders headers = CommonMethods.createTokenHeaders();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.exchange(Constants.BASE_URL + "user/repos", HttpMethod.GET, entity, String.class);
    }

    //____________________________________________________________get user repo___________________________________________________________________________________________________
    @GetMapping("/{userName}/repos")
    public ResponseEntity<String> getUserRepository(@PathVariable String userName) {
         
        HttpEntity<String> entity = CommonMethods.createHeadersEntity();
        return restTemplate.exchange(Constants.BASE_URL + "users/" + userName + "/repos", HttpMethod.GET, entity, String.class);
    }

    //____________________________________________________________create repo for Authenticated user___________________________________________________________________________________________________
    @PostMapping("/create/repo")
    public ResponseEntity<String> createAtuhUserRepository(@RequestBody RepositoryRequest repositoryRequest) {

        String requestBody = CommonMethods.createRequestBody(repositoryRequest);
        HttpHeaders headers = CommonMethods.createTokenHeaders();

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

         
        return restTemplate.exchange(Constants.BASE_URL + "user/repos", HttpMethod.POST, entity, String.class);
    }
    //____________________________________________________________create branch in user repo___________________________________________________________________________________________________

    @PostMapping("createBranch/{owner}/{repo}")
    public ResponseEntity<String> createUserBranch(
            @PathVariable String owner,
            @PathVariable String repo,
            @RequestBody Branch branch
    ) {
         
        HttpHeaders headers = CommonMethods.createTokenHeaders();
        String resposeBody = CommonMethods.createRequestBodyNewBranch(branch);
        HttpEntity<String> entity = new HttpEntity<>(resposeBody, headers);


        return restTemplate.exchange(Constants.BASE_URL + "repos/" + owner + "/" + repo + "/git/refs", HttpMethod.POST, entity, String.class);
    }


//    @DeleteMapping("user/repo/delete/Branch/{owner}/")

}


