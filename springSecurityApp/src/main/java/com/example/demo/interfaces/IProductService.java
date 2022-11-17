package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.beans.Product;

public interface IProductService {
	public List<Product> obtenerTodos();
	public void crearProducto(Product producto);
}
