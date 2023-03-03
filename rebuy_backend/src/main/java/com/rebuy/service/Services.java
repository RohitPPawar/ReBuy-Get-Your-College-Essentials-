package com.rebuy.service;

import java.util.List;

public abstract class Services<T, K> {

	public abstract T create(T t);

	public abstract T update(T t, K k);

	public abstract T getById(K k);

	public abstract List<T> getAll();

	public abstract void delete(K k);
}
