package com.info.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.dao.CategoryRepository;
import com.info.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public List<Category> listCategory() {
		return categoryRepository.findAll();
		//Phương thức này trả về tất cả các thực thể từ bảng.
	}

	@Override
	public void deleteCategory(long categoryId) {
		categoryRepository.deleteById(categoryId);
		//Tìm một thực thể theo ID đã cho và xóa.
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);
		//https://www.baeldung.com/spring-data-crud-repository-save
	}

	@Override
	public Optional<Category> getCategory(long categoryId) {
		return categoryRepository.findById(categoryId);
		//Optional findById(ID id) – Tìm entity theo ID.
///User user = userRepository.findById(1);
	}

}
