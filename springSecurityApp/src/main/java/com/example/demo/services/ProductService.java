package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Product;
import com.example.demo.interfaces.IProductService;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
	ProductRepository pRepository;
	
	public List<Product> obtenerTodos(){
		return pRepository.findAll();
	}
	
	public void crearProducto(Product producto) {
		List<Product> productos = pRepository.findAll();
		if(productos.size() == 0) {
			pRepository.save(producto);
		}else {
			for(int i = 0; i <productos.size();i++) {
				boolean existe = producto.getName().equals(productos.get(i).getName());
				System.err.println("Añadir:");
				System.err.println("Existe: "+existe+".");
				if(existe == false) {
					pRepository.save(producto);
				}
			}
		}
	}
}
