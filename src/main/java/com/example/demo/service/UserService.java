package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
		
	@Autowired
	private UserRepository userrepository;
	
	
	/*register user has to be allowed to login
	 * register  username="dhanush"
	 * login username="dhanush"
	 */
	
//	it achieves validation and helps to throw error if the validation is unsuccessul
	
	public List<String> registerUser(User user,BindingResult bindingResult){
		
		List<String> errors=new ArrayList<>();
		
//		checking if the username already exists
		
		if(userrepository.findByUsername(user.getUsername())!=null) {
			
			errors.add("username already exists");
		}
		
//		Checks whether the form contains errors or not
		
		if(bindingResult.hasErrors()) {

//			To perform iteration,for checking all the errors like (black,Size,Password etc......)
			for(ObjectError error:bindingResult.getAllErrors()) {
				
				
//				errors----variable created as array list
//				error----to specify each error separately
				errors.add(error.getDefaultMessage());
		}
		}
		
//		to check password and confirm password matches or not
		
		if(!user.isPasswordMatching()) {
			
			errors.add("password and confirm password must be same!!!!");
		}
		
		if(errors.isEmpty()) {
			
			userrepository.save(user);
		}
return errors;
	}
//	close of the method
	

	
//	to perform the success full login
	
	public User loginUser(String username,String password ) {
		
//		it helps to check whether the register is matching the login user
		User user=userrepository.findByUsername(username);
		
		if(user!=null && user.getPassword().equals(password)){
			
			return user;
		}
		return null;
	}

}
