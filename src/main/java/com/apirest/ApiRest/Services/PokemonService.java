@Service
public class PokemonService {
    private final RestTemplate restTemplate;

    @Autowired
    public PokemonService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPokemon(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        return restTemplate.getForObject(url, String.class);
    }
}
