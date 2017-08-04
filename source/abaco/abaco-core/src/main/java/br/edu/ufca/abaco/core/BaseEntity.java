package br.edu.ufca.abaco.core;

import java.io.Serializable;

public interface BaseEntity<K> extends Serializable{
	
	K getId();
	
}
