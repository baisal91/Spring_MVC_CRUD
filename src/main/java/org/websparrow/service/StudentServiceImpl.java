package org.websparrow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.websparrow.model.City;
import org.websparrow.model.Subject;

@Service
public class StudentServiceImpl implements StudentService{

	@Override
	public List<Subject> getAllSubjects() {
		List<Subject> subList = new ArrayList<Subject>();
		subList.add(new Subject("math", "math"));
		subList.add(new Subject("physics", "physics"));
		subList.add(new Subject("computer science", "computer science"));
		return subList;
	}

	@Override
	public List<City> getAllCities() {
		List<City> cityList= new ArrayList<City>();
		cityList.add(new City(1, "Santa Cruz"));
		cityList.add(new City(2, "NYC"));
		cityList.add(new City(3, "Toronto"));
		
		return cityList;
	}

}
