package certus.edu.pe.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import certus.edu.pe.modelo.Categoria;
import certus.edu.pe.repositorios.CategoriaRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaServicios {

	@Autowired
	public CategoriaRepositorio repositorio;
	
	
	public Categoria crear(Categoria categoria) {
		return repositorio.save(categoria);
	}
	
	public List<Categoria> buscarTodo(){
		return (ArrayList<Categoria>) repositorio.findAll();
	}
	
	public Categoria buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public Categoria actualizar(Categoria categoriaActualizar) {
		
		Categoria categoriaActual = repositorio.findById(categoriaActualizar.getIdCategoria()).get();
		
		categoriaActual.setIdCategoria(categoriaActualizar.getIdCategoria());
		categoriaActual.setCodigo(categoriaActualizar.getCodigo());
		categoriaActual.setDescripcion(categoriaActualizar.getDescripcion());
		
		Categoria categoriaActualizado  = repositorio.save(categoriaActual);
		return categoriaActualizado;
	}
	
	public void eliminarCategoria(Integer id) {
		repositorio.deleteById(id);
	}
	
	public void actualizar(int id, Categoria categoria) {
		
		Categoria categoriaActual = repositorio.findById(id).get();
		
		categoriaActual.setIdCategoria(categoria.getIdCategoria());
		categoriaActual.setCodigo(categoria.getCodigo());
		categoriaActual.setDescripcion(categoria.getDescripcion());
		repositorio.save(categoriaActual);
		
	}
	
	
}
