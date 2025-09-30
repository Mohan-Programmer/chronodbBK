    package chronodb.chrono.repository;

    import org.springframework.data.jpa.repository.JpaRepository;

    import chronodb.chrono.models.ApiKey;

    public interface ApiKeyRepository extends JpaRepository<ApiKey,String>{

    }
