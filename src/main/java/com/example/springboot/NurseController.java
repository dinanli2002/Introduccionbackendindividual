package com.example.springboot;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nurses")
public class NurseController {
	
	private List<Nurse> nurseList = new ArrayList<>();

    public NurseController() {
        nurseList.add(new Nurse("nurse1", "password1"));
        nurseList.add(new Nurse("nurse2", "password2"));
    }
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestParam String username, @RequestParam String password) {
        for (Nurse nurse : nurseList) {
            if (nurse.getUsername().equals(username) && nurse.getPassword().equals(password)) {
            	return new ResponseEntity<>(true, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
    }


}
