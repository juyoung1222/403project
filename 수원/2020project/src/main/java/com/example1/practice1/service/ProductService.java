package com.example1.practice1.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.example1.practice1.domain.Pagination;
import com.example1.practice1.domain.ProductDTO;
import com.example1.practice1.mapper.ProductMapper;

@Repository("com.example1.practice1.service.ProductService")
public class ProductService {
	
	@Resource(name="com.example1.practice1.mapper.ProductMapper")
	ProductMapper productMapper;
	
	public int getProductListCnt() throws Exception{
		
		return productMapper.getproductListCnt();
	}
	//게시글 목록 보기
	public List<ProductDTO> productListService(Pagination pagination) throws Exception {
		return productMapper.productList(pagination);
	}
	//게시글 등록
	public int productInsertService(ProductDTO product) throws Exception {
		return productMapper.productInsert(product);
	}
	//파일 올리기
	public int fileInsertService(ProductDTO product) throws Exception {
		return productMapper.fileInsert(product);
	}
	
	public ProductDTO fileDetailService(int productno) throws Exception {
		return productMapper.fileDetail(productno);
	}
	//게시글 상세보기
	public ProductDTO productDetailService(int productno) throws Exception {
		return productMapper.productDetail(productno);
	}
	
//	// 서비스는 매퍼를 호출한다.
//	@Resource(name = "com.edu.Product.mapper.ProductMapper")
//	ProductMapper ProductMapper;
}
