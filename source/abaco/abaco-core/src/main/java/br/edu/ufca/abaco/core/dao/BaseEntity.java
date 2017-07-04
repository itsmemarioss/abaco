package br.edu.ufca.abaco.core.dao;

import java.io.Serializable;

public interface BaseEntity<K> extends Serializable{
	
	K getId();
	
}
