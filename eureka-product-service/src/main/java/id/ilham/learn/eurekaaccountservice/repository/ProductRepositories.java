package id.ilham.learn.eurekaaccountservice.repository;


import id.ilham.learn.eurekaaccountservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositories extends JpaRepository<Product, Integer> {
}
