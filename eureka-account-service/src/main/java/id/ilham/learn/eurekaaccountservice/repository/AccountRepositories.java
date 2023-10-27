package id.ilham.learn.eurekaaccountservice.repository;


import id.ilham.learn.eurekaaccountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositories extends JpaRepository<Account, Integer> {
}
