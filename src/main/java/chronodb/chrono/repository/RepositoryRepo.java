package chronodb.chrono.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chronodb.chrono.models.Repository;

public interface RepositoryRepo extends JpaRepository<Repository,String> {

}
