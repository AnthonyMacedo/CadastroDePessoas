package com.cadastropessoas.repository;

import java.util.List;

public interface BaseRepository<T> {
	
	T salvar(T entity);
	
	void remover(T entity);
	
	T buscarPorId(Class<T> classe, Long id);
	
	List<T> buscarTodos(Class<T> classe);
	
}
