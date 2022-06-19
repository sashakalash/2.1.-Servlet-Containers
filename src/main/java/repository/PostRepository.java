package repository;

import model.Post;

import java.util.*;

public class PostRepository {
    private final Map<Long, Post> posts = new HashMap<>();

    public List<Post> all() {
        return new ArrayList<Post>(posts.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.of(posts.get(id));
    }

    public Post add(Post post) {
        posts.put(post.getId(), post);
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