
package co.unicauca.openmarket.client.domain.service;

import co.unicauca.openmarket.client.access.ICategoryAccess;
import co.unicauca.openmarket.commons.domain.Category;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author brayan
 */
public class CategoryService {
    
    public CategoryService(){
        
    }
    private ICategoryAccess repository;
    
    public CategoryService(ICategoryAccess repository){
        this.repository=repository;
    }
    public boolean saveCategory (Long id,String name)throws Exception{
        Category newCategory=new Category();
        newCategory.setCategoryId(id);
        newCategory.setName(name);
        if(newCategory.getName().isBlank()){
            return false;
        }
        return repository.save(newCategory);
    }
    public boolean editCategory(Long categoryId,Category cat) throws Exception {
        
        //Validate product
        if(cat==null || cat.getName().isBlank()){
            return false;
        }
      
       
        return repository.edit(categoryId,cat);
    }
    
    public boolean deleteCategory(Long id) throws Exception{
        return repository.delete(id);
    }  
    public Category findCategoryById(Long id)throws Exception{
        return repository.findById(id);
    }
       public List<Category> findAllCategories() throws Exception{
        return repository.findAll();
    }
       
       public List<Category> findCategoriesByName(String name)throws Exception{
        return repository.findByName(name);
    }
}  
        
