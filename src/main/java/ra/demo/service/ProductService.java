package ra.demo.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.demo.model.Product;
import ra.demo.repository.IProductRepo;

import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepo.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public List<Product> searchByName(String keyword) {
        return productRepo.searchByName(keyword);
    }

    @Override
    public void deleteById(Integer id) {
        productRepo.deleteById(id);
    }
}
