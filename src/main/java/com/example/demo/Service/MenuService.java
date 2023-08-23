package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Menu;
import com.example.demo.Repository.MenuRepo;

@Service
public class MenuService {
	@Autowired
	MenuRepo mr;
	
	public Menu saveinfo(Menu m)
	{
		return mr.save(m);
	}
	
	public List<Menu> showinfo(){
		return mr.findAll();
	}
	public List<Menu> savedetails(List<Menu> m)
	{
		return (List<Menu>)mr.saveAll(m);
	}
	public Menu changeinfo(Menu m)
	{
		return mr.saveAndFlush(m);
	}
	public void deleteoid(int id)
	{
		mr.deleteById(id);
	}
	public void delete()
	{
		mr.deleteAll();
	}
	public Optional<Menu> getid(int id) {
		return mr.findById(id);
	}
	public String updatebyid(int id,Menu m)
	{
		mr.saveAndFlush(m);
		if(mr.existsById(id))
		{
			return "Updated successfully";
		}
		else
		{
			return "Enter valid order id";
		}
	}

}
