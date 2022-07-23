package repository;

import model.Post;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PostRepository {
    private final Map<AtomicInteger, Post> posts = new ConcurrentHashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    public List<Post> all() {
        return new ArrayList<>(posts.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.of(posts.get(id));
    }

    public Post add(Post post) {
        post.setId(idCounter.get());
        posts.put(idCounter, post);
        idCounter.incrementAndGet();
        return post;
    }

    public Optional<Post> save(Post post) {
        Post changedPost = posts.get(post.getId());
        if (changedPost != null) {
            changedPost.setContent(post.getContent());
            return Optional.of(changedPost);
        }
        return Optional.empty();
    }

    public Optional<Post> removeById(long id) {
        return Optional.of(posts.remove(id));
    }
}