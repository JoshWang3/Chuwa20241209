@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return postRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContent(updatedPost.getContent());
                    return ResponseEntity.ok(postRepository.save(post));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (!postRepository.existsById(id)) {
            throw new ResourceNotFoundException("Post not found with id: " + id);
        }
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
