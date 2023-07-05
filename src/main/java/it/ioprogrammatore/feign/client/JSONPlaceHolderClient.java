package it.ioprogrammatore.feign.client;

import it.ioprogrammatore.feign.config.ClientConfiguration;
import it.ioprogrammatore.feign.hystrix.JSONPlaceHolderFallback;
import it.ioprogrammatore.feign.model.Comment;
import it.ioprogrammatore.feign.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/", configuration = ClientConfiguration.class, fallback = JSONPlaceHolderFallback.class)
public interface JSONPlaceHolderClient {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<Post> getPosts();

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
    Post getPostById(@PathVariable("postId") Long postId);

    @RequestMapping(method = RequestMethod.GET, value = "/comments", produces = "application/json")
    List<Comment> getCommentsPostById(@RequestParam("postId") Long postId);

    @RequestMapping(method = RequestMethod.POST, value = "/posts")
    Post addPosts(@RequestBody Post post);

    @RequestMapping(method = RequestMethod.PUT, value = "/posts/{postId}", produces = "application/json")
    Post updatePostById(@PathVariable("postId") Long postId, @RequestBody Post post);

    @RequestMapping(method = RequestMethod.DELETE, value = "/posts/{postId}", produces = "application/json")
    void deletePostById(@PathVariable("postId") Long postId);
}
