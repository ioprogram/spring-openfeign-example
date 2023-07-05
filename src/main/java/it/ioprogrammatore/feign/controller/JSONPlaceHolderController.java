package it.ioprogrammatore.feign.controller;

import it.ioprogrammatore.feign.model.Comment;
import it.ioprogrammatore.feign.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/post")
public class JSONPlaceHolderController {

    @Autowired
    private it.ioprogrammatore.feign.client.JSONPlaceHolderClient JSONPlaceHolderClient;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = JSONPlaceHolderClient.getPosts();
        return ResponseEntity.ok(posts);
    }

    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET)
    public ResponseEntity<Post> getPostById(@PathVariable("postId") Long postId) {
        Post postById = JSONPlaceHolderClient.getPostById(postId);
        return ResponseEntity.ok(postById);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/comments", produces = "application/json")
    ResponseEntity<List<Comment>> getCommentsPostById(@RequestParam("postId") Long postId) {
        List<Comment> commentsPostById = JSONPlaceHolderClient.getCommentsPostById(postId);
        return ResponseEntity.ok(commentsPostById);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/posts")
    ResponseEntity<Post> addPosts(@RequestBody Post post) {
        Post postResult = JSONPlaceHolderClient.addPosts(post);
        return ResponseEntity.ok(postResult);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/posts/{postId}", produces = "application/json")
    ResponseEntity<Post> updatePostById(@PathVariable("postId") Long postId, @RequestBody Post post) {
        Post postResult = JSONPlaceHolderClient.updatePostById(postId, post);
        return ResponseEntity.ok(postResult);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/posts/{postId}", produces = "application/json")
    ResponseEntity<String> deletePostById(@PathVariable("postId") Long postId) {
        JSONPlaceHolderClient.deletePostById(postId);
        return ResponseEntity.ok().build();
    }
}
