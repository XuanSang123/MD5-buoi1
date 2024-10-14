package ra.demo.repository;

import ra.demo.model.Product;

import java.util.List;

public interface IProductRepo extends IResponsitoty<Product,Integer>{
    List<Product> searchByName(String keyword);
}
