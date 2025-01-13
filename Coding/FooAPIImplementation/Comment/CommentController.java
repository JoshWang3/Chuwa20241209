@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestParam Long postId, @RequestBody Comment comment) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));
        comment.setPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentRepository.save(comment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        return commentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment updatedComment) {
        return commentRepository.findById(id)
                .map(comment -> {
                    comment.setText(updatedComment.getText());
                    return ResponseEntity.ok(commentRepository.save(comment));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        if (!commentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Comment not found with id: " + id);
        }
        commentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
