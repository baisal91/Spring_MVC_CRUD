package org.websparrow.service;

import java.util.List;

import org.websparrow.model.City;
import org.websparrow.model.Subject;

public interface StudentService {

	public List<Subject> getAllSubjects();
	public List<City> getAllCities();
}
