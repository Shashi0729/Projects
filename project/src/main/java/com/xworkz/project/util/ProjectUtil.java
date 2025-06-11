package com.xworkz.project.util;

import org.springframework.beans.BeanUtils;

import com.xworkz.project.dto.IndustryDto;
import com.xworkz.project.dto.ItemsDto;
import com.xworkz.project.dto.SignUpDto;
import com.xworkz.project.entity.IndustryEntity;
import com.xworkz.project.entity.ItemsEntity;
import com.xworkz.project.entity.SignUpEntity;

public class ProjectUtil {
	
	private ProjectUtil() {
		
	}
	
	public static SignUpDto convertEntityToDto(SignUpEntity entity) {
		SignUpDto dto = new SignUpDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static SignUpEntity convertDtoToEntity(SignUpDto dto) {
		SignUpEntity entity = new SignUpEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public static IndustryEntity convertDtoToEntity(IndustryDto dto) {
		IndustryEntity entity = new IndustryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static IndustryDto convertEntityToDto(IndustryEntity entity) {
		IndustryDto dto = new IndustryDto();
		BeanUtils.copyProperties(entity,dto);
		return dto;
	}
	
	public static ItemsEntity itemConvertDtoToEntity(ItemsDto dto) {
		ItemsEntity entity = new ItemsEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static ItemsDto itemConvertEntityToDto(ItemsEntity entity) {
		ItemsDto dto = new ItemsDto();
		BeanUtils.copyProperties(entity,dto);
		return dto;
	}

}
