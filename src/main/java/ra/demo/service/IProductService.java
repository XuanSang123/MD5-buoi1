package ra.demo.service;

import ra.demo.model.Product;

import java.util.List;

public interface IProductService extends IService<Product,Integer>{
    List<Product> searchByName(String keyword);

}
