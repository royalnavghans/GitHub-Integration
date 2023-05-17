package com.main.Gtihub_Integration.controller;

import com.main.Gtihub_Integration.entity.Commit;
import com.main.Gtihub_Integration.entity.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/sha")
public class GitHubSHAController {
    @Autowired
    CommonMethods  commonMethods;
    @Autowired
    RestTemplate restTemplate;
    //____________________________________________________________latest sha of a user in a repo___________________________________________________________________________________________________

    @GetMapping("/userCommit/sha/{owner}/{repo}/{username}")
    public ResponseEntity<Commit[]> userLatestSHA(
            @PathVariable String owner,
            @PathVariable String repo,
            @PathVariable String username) {

         
        HttpHeaders headers =  commonMethods.createTokenHeaders();

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        HttpEntity<Commit[]> response = restTemplate.exchange(
                 Constants.BASE_URL + "repos/" + owner + "/" + repo + "/commits?per_page=1&sort=created&direction=desc&author=" + username,
                HttpMethod.GET, entity, Commit[].class);
        System.out.println(response);

        return ResponseEntity.ok().body(response.getBody());

    }
    //____________________________________________________________get the SHA of the latest commit___________________________________________________________________________________________________

    @GetMapping("latest/commit/{owner}/{repo}")
    public ResponseEntity<Commit[]> repoLatestSHA(
            @PathVariable String owner,
            @PathVariable String repo) {

         
        HttpHeaders headers =  commonMethods.createTokenHeaders();

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        HttpEntity<Commit[]> response = restTemplate.exchange(
                 Constants.BASE_URL + "repos/" + owner + "/" + repo + "/commits?per_page=1&sort=created&direction=desc",
                HttpMethod.GET, entity, Commit[].class);
        Commit commitData = null;
        if (response.getBody() != null) {
            commitData = response.getBody()[0];
            commitData.getSha();

            System.out.println(commitData.getSha());
        } else {
            System.out.println("No commits found in the repository.");
        }
        return ResponseEntity.ok().body(response.getBody());

    }
}



