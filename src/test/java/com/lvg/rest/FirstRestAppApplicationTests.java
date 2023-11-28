package com.lvg.rest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.lvg.rest.entity.Product;
import com.lvg.rest.repository.ProductRepository;
import com.lvg.rest.service.ProductService;
@SpringBootTest
class FirstRestAppApplicationTests {
     @Autowired
     ProductService productService;
     @MockBean  //insted of using Repo we use mock object thats duplicate obj  
     ProductRepository productRepository;
	@Test
	//void contextLoads() {
	void getAllProductsTest() {
		List<Product>  plist=Arrays.asList(new Product(7001,"Lux Soap","Toilet Soap",15,50),
				new Product (7002,"Parachute Oil","Coconut Oil",115,250));
		when(productRepository.findAll()).thenReturn(plist);
		assertEquals(2,productService.getAllProducts().size());
	}
	@Test
	public void insertOrModifyTest() {
		Product prod=new Product(7002,"Parachute Oil","Coconut Oil",115,250);//first created one dummy obj
		when(productRepository.save(prod)).thenReturn(prod);
		assertEquals(true,productService.insertOrModifyProduct(prod));
	}
	@Test
	public void deleteProductById() {
		int productId=7001;
		//when(productRepository.deleteById(productId)).thenReturn();
		assertEquals(true,productService.deleteProductById(productId));
	}
}