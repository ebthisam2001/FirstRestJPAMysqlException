package com.iiht.restjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.restjpa.entity.Product;
import com.iiht.restjpa.exception.InvalidValueException;
import com.iiht.restjpa.services.ProductService;

@RestController
@RequestMapping("/product/api.1.0")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	@RequestMapping(path="create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product savedProduct=productService.save(product);
		return new ResponseEntity<Product>(savedProduct,HttpStatus.CREATED);
	}
	
	//@GetMapping
	@GetMapping("/fetch/{productId}")
	public ResponseEntity<Product> fetch(@PathVariable Long productId){
		return ResponseEntity.ok(productService.fetch(productId));
	}
	
	@GetMapping("/fetchall")
	public ResponseEntity<List<Product>> fetchAll(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.fetchAll());
	}
	
	@DeleteMapping("/deletebyid/{productId}")
	public ResponseEntity<?> deletebyid(@PathVariable Long productId){
		if(productService.delete(productId)) {
		return ResponseEntity.status(HttpStatus.OK).body("Deleted successdully");
				}
		else
			return null;
	}
	
	@PutMapping("/update/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product){
		return ResponseEntity.ok(productService.update(productId, product));
			
	}
	@GetMapping("/test/nullpointer")
	public String message(String str) throws Exception,NullPointerException  {
		//str="abc1";
		str="abc";

		if(str==null)
			throw new NullPointerException("value not provided");
		boolean isNumeric=str.chars().anyMatch(x->Character.isDigit(x));
		if(isNumeric)
			throw new InvalidValueException("Expected value found int");
		if(str.length()<8)
			throw new Exception("length is short");
		else
				return "hello";
		
	}
	@GetMapping("/test/invalidvalue")
	public String message2(String str) throws InvalidValueException{
		if(str==null)
			throw new InvalidValueException("value not provided");
			else
				return "hello";
		
	}

}
