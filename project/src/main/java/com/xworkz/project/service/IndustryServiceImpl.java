package com.xworkz.project.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.project.dto.IndustryDto;
import com.xworkz.project.dto.ItemsDto;
import com.xworkz.project.entity.IndustryEntity;
import com.xworkz.project.entity.ItemsEntity;
import com.xworkz.project.entity.SignUpEntity;
import com.xworkz.project.repo.AdminRepo;
import com.xworkz.project.repo.IndustryRepo;
import com.xworkz.project.resources.IndustryResources;
import com.xworkz.project.util.ProjectUtil;
import com.xworkz.project.util.mailutil.MailSender;

@Component
public class IndustryServiceImpl implements IndustryService {
	@Autowired
	IndustryRepo repo;
	@Autowired
	MailSender emailsender;
	@Autowired
	AdminRepo aRepo;

	@Override
	public boolean onSave(IndustryDto dto) {
		if (dto != null) {
			IndustryEntity entity = ProjectUtil.convertDtoToEntity(dto);
			entity.setCreatedBy(dto.getUserName());
			entity.setCreatedOn(LocalDateTime.now());
			entity.setActive(true);
			repo.onSave(entity);
			emailsender.sendWelComeMessage(entity.getEmail());
			System.out.println("saved");
		}
		return false;
	}



	@Override
	public boolean getemail(String email) {
		if (email != null) {
			if (repo.getemail(email) != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getGST(String Gst) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getcontact(Long contactNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IndustryDto findByEmail(String email) {
		if (email != null) {
			IndustryEntity entity = repo.getemail(email);
			IndustryDto dto = ProjectUtil.convertEntityToDto(entity);
			return dto;

		}
		return null;
	}

	@Override
	public IndustryDto findByEmailInActive(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateByEmail(IndustryDto dto) {
		if (dto != null) {
			IndustryEntity entity = ProjectUtil.convertDtoToEntity(dto);
			entity.setActive(true);
			entity.setApproved(true);
			entity.setUpdatedBy(dto.getUserName());
			entity.setUpdatedOn(LocalDateTime.now());
			repo.update(entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteByEmail(IndustryDto dto) {

		if (dto != null) {
			IndustryEntity entity = ProjectUtil.convertDtoToEntity(dto);
			entity.setActive(false);
			entity.setUpdatedBy(dto.getUserName());
			entity.setUpdatedOn(LocalDateTime.now());
			repo.update(entity);
			return true;
		}
		return false;
	}

	@Override
	public int generateOTP() {
		SecureRandom random = new SecureRandom();
		return 100000 + random.nextInt(900000);
	}

	@Override
	public boolean sendOTP(String email) {
		IndustryEntity entity = repo.getemail(email);
		int OTP = generateOTP();
		entity.setOtp(OTP);
		repo.update(entity);
		emailsender.sendOtp(OTP, entity.getEmail(), entity.getUserName());
		return false;
	}

	@Override
	public boolean validateOTP(int OTP, String email) {
		IndustryEntity entity = repo.getemail(email);
		if (entity.getOtp() == OTP) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getApproved(String email) {
		IndustryEntity entity = repo.getemail(email);
		entity.setApproved(true);
		repo.update(entity);
		emailsender.ApproveAndSendOtp(entity.getEmail(), entity.getUserName());
		return true;
	}

	@Override
	public boolean getRejected(String email) {
		IndustryEntity entity = repo.getemail(email);
		entity.setApproved(false);
		repo.update(entity);
		emailsender.sendRejectMessage(email);
		return true;
	}

	private static final String filePath = "D:/ProjectImage/ItemImages/";

	@Override
	public boolean itemSave(ItemsDto dto, MultipartFile file,String email) {
		IndustryEntity industryentity = repo.getemail(email);
		if (!file.isEmpty()) {
			String imageName = file.getOriginalFilename();
			File destFile = new File(filePath + dto.getItemNo() + "@" + imageName);
			try {
				file.transferTo(destFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			dto.setImageName(dto.getItemNo() + "@" + imageName);
		}
	//	ItemsEntity itemEntity=new ItemsEntity();
		ItemsEntity itementity = ProjectUtil.itemConvertDtoToEntity(dto);
		System.out.println(industryentity);
        itementity.setCompanyDetails(industryentity);
      //  BeanUtils.copyProperties(dto, itemEntity);
		repo.itemSave(itementity);
	
		return true;
     
	}

}
