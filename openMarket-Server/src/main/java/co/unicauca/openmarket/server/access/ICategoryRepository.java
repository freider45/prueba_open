/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.openmarket.server.access;

import co.unicauca.openmarket.commons.domain.Category;
import java.util.List;
/**
 *
 * @author brayan
 */
public interface ICategoryRepository {
    
   boolean save(Category newCategory);
   boolean edit(Long id, Category category);
   boolean delete(Long id);
   Category findById(Long id);
   List<Category> findAll();
   public List<Category> findByName(String name);
   //boolean clearCategories();

}
