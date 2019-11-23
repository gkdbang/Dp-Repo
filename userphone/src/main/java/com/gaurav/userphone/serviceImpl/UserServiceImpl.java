package com.gaurav.userphone.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.userphone.model.User;
import com.gaurav.userphone.repository.UserRepository;
import com.gaurav.userphone.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> addUser(List<User> user) throws Exception {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() throws Exception {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) throws Exception {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> getUserByName(String name) throws Exception {
		return userRepository.findUserByName(name);
	}

	@Override
	public List<User> getUserByPhoneNumber(String phoneNumber) throws Exception {
		return userRepository.findUserByPhoneNumber(phoneNumber);
		
		// Logic for get user but only one phone Number
		
/*		List<User> users=new ArrayList<User>();
		users=userRepository.findUserByPhoneNumber(phoneNumber);
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			List<PhoneNumber> PhoneNumbers=user.getPhones();
			for (Iterator<PhoneNumber> iterator2 = PhoneNumbers.iterator(); iterator2.hasNext();) {
				PhoneNumber phoneNumber2 = iterator2.next();
				if(!(phoneNumber.equalsIgnoreCase(phoneNumber2.getPhoneNumber()))){
					iterator2.remove();
				}
			}
		}
		return users;*/
		
	}

	@Override
	public List<User> getUserByPhoneType(String phoneType) throws Exception {
		return userRepository.findUserByPhoneType(phoneType);
		
		
		// Logic for get user but only one phone type
		
/*		List<User> users=new ArrayList<User>();
		users=userRepository.findUserByPhoneType(phoneType);
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			List<PhoneNumber> PhoneNumbers=user.getPhones();
			for (Iterator<PhoneNumber> iterator2 = PhoneNumbers.iterator(); iterator2.hasNext();) {
				PhoneNumber phoneNumber = iterator2.next();
				if(!(phoneType.equalsIgnoreCase(phoneNumber.getPhoneType()))){
					iterator2.remove();
				}
			}
		}
		return users;*/
	}

	@Override
	public List<User> UpdateUser(User user, Integer id) throws Exception {
		userRepository.save(user);
		return getAllUser();
	}

	@Override
	public List<User> deleteUserById(Integer id) throws Exception {
		userRepository.delete(id);
		return getAllUser();
	}

	@Override
	public List<User> deleteAllUser() throws Exception {
		userRepository.deleteAll();
		return getAllUser();
	}
	
}
