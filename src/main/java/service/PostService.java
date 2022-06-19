package service;

import exception.NotFoundException;
import model.Post;
import repository.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            return repository.add(post);
        } else {
            return repository.save(post).orElseThrow(NotFoundException::new);
        }
    }

    public void removeById(long id) {
        repository.removeById(id).orElseThrow(NotFoundException::new);
    }
}
