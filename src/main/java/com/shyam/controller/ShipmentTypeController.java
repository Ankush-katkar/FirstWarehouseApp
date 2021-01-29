package com.shyam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shyam.model.ShipmentType;
import com.shyam.service.IShipmentTypeService;

@Controller
@RequestMapping("/st")
public class ShipmentTypeController 
{
	@Autowired
	private IShipmentTypeService service;

	@GetMapping("/register")
	public String showReg()
	{
		return "ShipmentTypeRegister";
	}

	//2. on click submit button read form-->save data
	@PostMapping("/save")
	public String saveShipmentType(@ModelAttribute ShipmentType shipmentType, Model model)
	{
		//call service
		Integer id=service.saveShipmentType(shipmentType);

		//create message
		String message="Shipment Type "+id+ "saved";

		//send message to UI
		model.addAttribute("message",message);

		//go back to same page
		return "ShipmentTypeRegister";
	}

	//get All rows/data
	@GetMapping("/all")
	public String fetchAllShipmentType(Model model)
	{
		//call service layer
		List<ShipmentType> list=service.getAllShipmentType();

		//send data to UI
		model.addAttribute("list", list);

		//return back to Data page
		return "ShipmentTypeData";
	}
	
	@RequestMapping("/delete")
	public String deleteShipmentTypes(@RequestParam("id") Integer sid, Model model)
	{
		if(service.isShipmentTypeExist(sid))
		{
		//call  service
		service.deleteShipmentTypes(sid);
		
		//create msg
		String msg=new StringBuffer("Shipment Type ' ")
						.append(sid)
						.append("'Deleted")
						.toString();
		
		//send to UI
		model.addAttribute("message", msg);
		}
		else
		{
			model.addAttribute("message", sid+" not found!!");
		}
		//latest data
		model.addAttribute("list", service.getAllShipmentType());
		
		return "ShipmentTypeData";
	}
	
	@GetMapping("/edit")
	public String showShipmentTypeEdit(@RequestParam("id") Integer sid, Model model)
	{
		String page=null;
		Optional<ShipmentType> opt=service.getOneShipmentType(sid);
		
		if(opt.isPresent())  //if data is present(not null)
		{
			//object--->Fill in form
			model.addAttribute("shipmentType",opt.get());
			page="ShipmentTypeEdit";
			
		}
		else
		{
			page="redirect:all";
		}
		
		return page;
	}
	
	@PostMapping("/update")
	public String doUpdateShipmentType(@ModelAttribute ShipmentType shipmentType, Model model)
	{
		//calls service to update
		service.updateShipmentType(shipmentType);
		
		//return redirect:all;
		
		//send msg to UI
		model.addAttribute("message", "Shipment Type '" +shipmentType.getId()+ "' Updated!!");
		
		//call service layer for latest data
		List<ShipmentType> list=service.getAllShipmentType();
		
		//send data to UI for HTML code
		model.addAttribute("list", list);
		
		//go back to UI page
		return "ShipmentTypeData";
	}
	
}
