@Component
public class PostGraphQLResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private PostRepository postRepository;

    public Post postByID(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Post createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        return postRepository.save(post);
    }

    public Post updatePost(Long id, String title, String content) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitle(title);
                    post.setContent(content);
                    return postRepository.save(post);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
    }
}
