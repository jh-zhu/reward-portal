package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Product_category;
import com.demo.model.Product_info;
import com.demo.service.CategoryService;
import com.demo.service.ProductService;
import com.demo.vo.ProductInfoVO;
import com.demo.vo.ProductVO;
import com.demo.vo.ResultVO;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	/*
	 * get all products that are availiable
	 * get category type list
	 * process data
	 * */
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/list")
		public ResultVO<ProductVO> list(){
			List<Product_info> productInfoList = productService.findUpAll();
			List<Integer> categoryTypeList = productInfoList.stream().map(Product_info::getCategoryType)
					.collect(Collectors.toList());
			
			List<Product_category>  categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
			
			List<ProductVO> productVOList = new ArrayList<>();
			for(Product_category category: categoryList) {
				ProductVO productVO = new ProductVO();
				productVO.setCategoryName(category.getCategoryName());
				productVO.setCategoryType(category.getCategoryType());
				
				
				List<ProductInfoVO> productInfoVOList = new ArrayList<>();
				for(Product_info productInfo:productInfoList) {
					if(productInfo.getCategoryType().equals(category.getCategoryType())) {
						
						ProductInfoVO productInfoVO = new ProductInfoVO();
						BeanUtils.copyProperties(productInfo, productInfoVO);
						productInfoVOList.add(productInfoVO);
					}
				}
				productVO.setProductInfoVOList(productInfoVOList);
				productVOList.add(productVO);
			}
			
			ResultVO resultVO = new ResultVO();
			resultVO.setData(productVOList);
			resultVO.setCode(0);
			resultVO.setMessage("success");
			
			return resultVO;
		}
}
