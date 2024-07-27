package com.iiht.restjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.restjpa.entity.Product;
import com.iiht.restjpa.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product save(Product product) {
		return productRepository.save(product);
		
	}
	public Product fetch(Long productId) {
		
		Optional<Product> optional=productRepository.findById(productId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else
			return null;
	}
	public List<Product> fetchAll() {
		
		List<Product> list=productRepository.findAll();
		return list;
	}
	public boolean delete(Long productId) {
		if(productRepository.existsById(productId)) {
			productRepository.deleteById(productId);
			return true;
		}
		else
				return false;			
	}
	public Product update(Long productId, Product product) {
		if(productRepository.existsById(productId)) {
			Product savedproduct=productRepository.save(product);
			return savedproduct;}
			else 
				return null;
		}
		
	

}
