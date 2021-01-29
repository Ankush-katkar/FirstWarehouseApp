package com.shyam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shyam.model.Uom;
import com.shyam.service.IUomService;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;

	@GetMapping("/register")
	public String showRegister() {
		return "UomRegister";
	}

	@PostMapping("/save")
	public String saveUom(@ModelAttribute Uom uom, Model model) {
		// call service
		Integer id = service.saveUom(uom);

		// create message
		String message = "Uom " + id + " Saved";
		model.addAttribute("message", message);

		// back to the same page
		return "UomRegister";
	}

	@GetMapping("/all")
	public String fetchAllUom(Model model) {
		List<Uom> list = service.getAllUom();

		// send data to UI
		model.addAttribute("list", list);

		// return back to Data page
		return "UomData";
	}

	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer uid, Model model)
	{

		if(service.isUomExist(uid)) 
		{ 
			//call service
			service.deleteUom(uid);

			//creste message
			String msg=new StringBuffer("Uom '")
							.append(uid)
							.append("' Deleted")
							.toString();

			//send to Ui 
			model.addAttribute("message", msg);
		} 
		else 
		{
			model.addAttribute("message", uid+ " Not Found");
		}
		
		//latest data
		model.addAttribute("list", service.getAllUom());
		
		return "UomData";
	}
}
