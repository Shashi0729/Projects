package com.xworkz.project.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xworkz.project.dto.SignInDto;
import com.xworkz.project.dto.SignUpDto;
import com.xworkz.project.entity.SigninEntity;
import com.xworkz.project.entity.SignUpEntity;
import com.xworkz.project.repo.ProjectRepo;
import com.xworkz.project.util.ProjectUtil;
import com.xworkz.project.util.mailutil.MailSender;

@Component
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepo repo;
	@Autowired
	MailSender emailsender;

	@Override
	public boolean onSave(SignUpDto dto) {
		if (dto != null) {
			SignUpEntity entity = ProjectUtil.convertDtoToEntity(dto);
			entity.setCreatedBy(dto.getUserName());
			entity.setCreatedOn(LocalDateTime.now());
			// dto.setActive(true);
			entity.setActive(true);

			repo.onSave(entity);
			System.out.println("saved");
		}
		return false;
	}

	@Override
	public boolean signIn(String email, String password) {
		int count = 0;
		SigninEntity entity = new SigninEntity();

		if (email != null && password != null) {
			SignUpEntity uEntity = repo.signIn(email, password);
			try {
				if (uEntity != null) {
					System.out.println("Login done");
					entity.setUserId(uEntity.getId());
					entity.setLogInTime(LocalDateTime.now());
					repo.signInSave(entity);
					SignUpEntity UEntity = repo.getemail(email);
					SignUpEntity Uid = repo.getid(UEntity.getId());
					System.out.println(UEntity);
					Uid.setAttempts(0);
					Uid.setActive(true);
					repo.update(Uid);

					return true;
				} else {
					SignUpEntity UEntity = repo.getemail(email);
					SignUpEntity Uid = repo.getid(UEntity.getId());
					System.out.println(UEntity);
					Uid.setAttempts(Uid.getAttempts() + 1);
					Uid.setActive(true);
					repo.update(Uid);
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();

			}

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
	public boolean getadhar(Long adhar) {
		if (adhar != null) {
			if (repo.getadhar(adhar)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getcontact(Long contactNo) {
		if (contactNo != null) {
			if (repo.getcontact(contactNo)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public SignUpDto findByEmail(String email) {
		if (email != null) {
			SignUpEntity entity = repo.getemail(email);
			if (entity != null) {
				return ProjectUtil.convertEntityToDto(entity);
			} else {
				System.out.println("data is null in service");
			}

		}
		return null;
	}

	@Override
	public SignUpDto findByEmailInActive(String email) {
		if (email != null) {
			SignUpEntity entity = repo.getemailInActive(email);
			if (entity != null) {
				return ProjectUtil.convertEntityToDto(entity);
			} else {
				System.out.println("data is null in service");
			}

		}

		return null;
	}

	@Override
	public boolean updateByEmail(SignUpDto dto) {
		SignUpEntity entity = new SignUpEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setActive(true);
		entity.setUpdatedBy(dto.getUserName());
		entity.setUpdatedOn(LocalDateTime.now());
		SignUpEntity entity1 = repo.update(entity);
		System.out.println(entity1);
		return true;
	}

	@Override
	public boolean deleteByEmail(SignUpDto dto) {
		if (dto != null) {
			SignUpEntity entity = new SignUpEntity();
			BeanUtils.copyProperties(dto, entity);
			entity.setActive(false);
			entity.setUpdatedBy(dto.getUserName());
			entity.setUpdatedOn(LocalDateTime.now());
			SignUpEntity entity1 = repo.update(entity);
			System.out.println(entity1);
			return true;

		}
		return false;
	}

	@Override
	public List<SignInDto> history(int id) {
		if (id != 0) {
			List<SigninEntity> list = repo.history(id);
			return list.stream().map(this::convertToDto).collect(Collectors.toList());
		}
		return null;
	}

	public SignInDto convertToDto(SigninEntity entity) {
		SignInDto dto = new SignInDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public SigninEntity convertToEntity(SignInDto dto) {
		SigninEntity entity = new SigninEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public int generateOTP() {
		SecureRandom random = new SecureRandom();
		return 100000 + random.nextInt(900000);

	}

	@Override
	public boolean sendOTP(String email) {
		SignUpEntity entity = repo.getemail(email);
	    int OTP = generateOTP();
		entity.setOTP(OTP);
		repo.update(entity);
		emailsender.sendOtp(OTP, entity.getEmail(), entity.getUserName());
		return false;
	}

	@Override
	public boolean validateOTP(int OTP,String email) {
		SignUpEntity entity = repo.getemail(email);
		if(entity.getOTP()==OTP) {
		return	true;
		}

		return false;
	}

	@Override
	public boolean resetPassword(String password, String email) {
		SignUpEntity entity = repo.getemail(email);
	   entity.setPassword(password);
		entity.setOTP(0);
		entity.setAttempts(0);
		repo.update(entity);
		return true;
	}

}
