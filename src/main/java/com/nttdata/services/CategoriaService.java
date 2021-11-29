package com.nttdata.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Categoria;
import com.nttdata.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	public void insertarCategoria(@Valid Categoria categoria) {
		
		categoriaRepository.save(categoria);
	}

	public Object obtenerListaCategorias() {
		
		return categoriaRepository.findAll();
	}

	
	public Categoria buscarCategoria(Long id) {
		
		return categoriaRepository.findById(id).get();
		
	}
	
	public void eliminarCategoria(Long id) {
		
		categoriaRepository.deleteById(id);
		
	}

	public void eliminarCategoriaObjeto(Categoria categoria) {
		categoriaRepository.delete(categoria);
		
	}

	public void editarCategoriaObjeto(Categoria categoria) {
		categoriaRepository.save(categoria);
		
	}

	public void updateCategoria(@Valid Categoria categoria) {
		if(categoriaRepository.existsById(categoria.getId())){
			categoriaRepository.save(categoria);
		}	
	}

}
