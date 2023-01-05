package com.example.LiveProject.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.LiveProject.DAO.DataaModel;
import com.example.LiveProject.Model.Dataa;
import com.example.LiveProject.Model.Vehicle;
import com.example.LiveProject.Service.MainService;

@Controller
public class MainController {
	
	@Autowired
	MainService ms;
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String showHomePage(Model model)
	{
		model.addAttribute("DataaModel", new DataaModel());
		return "home.html";
		
	}
	
	@RequestMapping(value = "/submit-data",method =RequestMethod.POST )
	public String saveData(@ModelAttribute DataaModel d,Model model) {
		System.out.print(d.toString());
		ms.saveDataa(d);
		d=new DataaModel();
		model.addAttribute("DataaModel", d);
		
		return "home.html";		
	}
	@RequestMapping(value = "/search",method = RequestMethod.GET)
	public String getsearch(Model model)
	{
		return "select_fetch_type.html";
	}
	
	@RequestMapping(value = "/get_all_data",method = RequestMethod.GET)
	public String getAllData(Model model)
	{
		//ModelAndView mv=new ModelAndView("full_data");
		List<Dataa> list=ms.getAllData();
		//mv.addObject("data", list);
		model.addAttribute("data", list);
		return "full_data.html";
	}
	
	@RequestMapping(value = "/get_all_vehicle",method = RequestMethod.GET)
	public String getVehicle(Model model)
	{
		List<Vehicle> list=ms.getAllVehicle();
		model.addAttribute("vehicle",list);
		return "vehicle_data.html";
	}
	
	@RequestMapping(value = "/get_by_vehicle",method = RequestMethod.GET)
	public String getByVehicle(@RequestParam("say") String no,Model model)
	{
		//System.out.println(no);
		List<Dataa> list=ms.getAllVehiclebyVehicleno(no);
		//System.out.println(list);
		model.addAttribute("data",list);
		return "full_data.html";
	}
	
	@RequestMapping(value="/get_by_date_range",method=RequestMethod.GET)
	public String getByDate(@RequestParam("startdate") String std, @RequestParam("enddate") String edt,Model model)
	{
		System.out.println(std+" "+edt);
		List<Dataa> list=ms.getByDate(std,edt);
		//System.out.println(list);
		model.addAttribute("data",list);
		return "full_data.html";
	}

}
