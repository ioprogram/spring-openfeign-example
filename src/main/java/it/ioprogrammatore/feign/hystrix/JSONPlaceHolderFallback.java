package it.ioprogrammatore.feign.hystrix;

import it.ioprogrammatore.feign.client.JSONPlaceHolderClient;
import it.ioprogrammatore.feign.model.Comment;
import it.ioprogrammatore.feign.model.Post;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class JSONPlaceHolderFallback implements JSONPlaceHolderClient {

    @Override
    public List<Post> getPosts() {
        return Collections.emptyList();
    }

    @Override
    public Post getPostById(Long postId) {
        return new Post();
    }

    @Override
    public List<Comment> getCommentsPostById(Long postId) {
        return Collections.emptyList();
    }

    @Override
    public Post addPosts(Post post) {
        return new Post();
    }

    @Override
    public Post updatePostById(Long postId, Post post) {
        return post;
    }

    @Override
    public void deletePostById(Long postId) {

    }

}
