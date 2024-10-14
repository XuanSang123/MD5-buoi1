package ra.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import ra.demo.model.Product;

import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = entityManager.createQuery("from Product ", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public Product findById(Integer id) {
        TypedQuery<Product> typedQuery = entityManager.createQuery("from Product where id= :id", Product.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
        } else {
            Product pro = findById(product.getId());
            pro.setName(product.getName());
            pro.setPrice(product.getPrice());
            pro.setStock(product.getStock());
            pro.setStatus(product.getStatus());
            pro.setCreated(product.getCreated());
            entityManager.merge(pro);
        }

    }

    @Override
    public List<Product> searchByName(String keyword) {
        TypedQuery<Product> typedQuery = entityManager.createQuery("from Product where name like :keyword", Product.class);
        typedQuery.setParameter("keyword", "%" + keyword + "%");
        return typedQuery.getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.remove(findById(id));
    }
}
