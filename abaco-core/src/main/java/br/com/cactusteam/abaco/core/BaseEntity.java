package br.com.cactusteam.abaco.core;

import java.io.Serializable;

public interface BaseEntity<K> extends Serializable{
	
	K getId();
	
}
