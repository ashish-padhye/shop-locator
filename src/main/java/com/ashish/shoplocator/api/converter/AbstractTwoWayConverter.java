package com.ashish.shoplocator.api.converter;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
public abstract class AbstractTwoWayConverter<S, T> implements GenericConverter {

	private Class<S> sourceClass;
	private Class<T> targetClass;
	
	protected AbstractTwoWayConverter() {
		this.sourceClass = (Class<S>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.targetClass = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> conversionPairs = new HashSet<ConvertiblePair>();
		conversionPairs.add(new ConvertiblePair(sourceClass, targetClass));
		conversionPairs.add(new ConvertiblePair(targetClass, sourceClass));
		return conversionPairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType,	TypeDescriptor targetType) {
		if(sourceClass.equals(sourceType.getType())){
			return this.convert((S) source);
		} else {
			return this.convertBack((T) source);
		}
	}
	
	protected abstract T convert(S source);
	protected abstract S convertBack(T target);

}
