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
import org.springframework.web.bind.annotation.ResponseBody;

import com.shyam.model.OrderMethod;
import com.shyam.service.IOrderMethodService;

@Controller
@RequestMapping("/om")
public class OrderMethodController
{
	@Autowired
	private IOrderMethodService service;

	@GetMapping("/register")
	public String showReg()
	{
		return "OrderMethodRegister";
	}

	//click on submit button read form--->save data
	@PostMapping("/save")
	public String saveOrderMethod(@ModelAttribute OrderMethod orderMethod,Model model)
	{
		//call  service
		Integer id=service.saveOrderMethod(orderMethod);

		//create Message
		String message="Order Method "+id+ " saved!!";

		//send msg to UI
		model.addAttribute("message", message);

		//go back to same Page
		return "OrderMethodRegister";
	}

	//get all rows/data
	@GetMapping("/all")
	public String fetchAllOrderMethod(Model model)
	{
		//calls service
		List<OrderMethod> list=service.getAllOrderMethod();

		//send data to UI
		model.addAttribute("list", list);

		//return back to data page
		return "OrderMethodData";
	}

	//delete data by ID
	@RequestMapping("/delete")
	public String deleteOrderMethods(@RequestParam("id") Integer omid,Model model)
	{
		if(service.isOrderMethodExist(omid))
		{
			//calls service
			service.deleteOrderMethods(omid);

			//create message
			String message="Order Method '"+omid+"' Deleted";

			//send to Ui
			model.addAttribute("message", message);
		}
		else
		{
			model.addAttribute("message", omid+" Not Found!!");
		}

		//latest Data
		model.addAttribute("list", service.getAllOrderMethod());

		//return to UI page
		return "OrderMethodData";

	}

	@GetMapping("/edit")
	public String showOrderMethodEdit(@RequestParam("id") Integer omid, Model model)
	{
		String page=null;
		Optional<OrderMethod> opt=service.getOneOrderMethod(omid);

		if(opt.isPresent())
		{
			//object--->Fill inn form
			model.addAttribute("orderMethod", opt.get());
			page="OrderMethodEdit";
		}
		else
		{
			page="redirect:all";
		}
		return page;

	}

	@PostMapping("/update")
	public String doUpdateOrderMethod(@ModelAttribute OrderMethod orderMethod, Model model)
	{
		//calls service to Upadte
		service.updateOrderMthod(orderMethod);


		//return redirect:all;

		//send msg ot ui
		model.addAttribute("message", "Order Type '"+orderMethod.getId()+"' Updated!!");

		//calls service service layers for latest data
		List<OrderMethod> list=service.getAllOrderMethod();

		//send data to Ui for HTML Code
		model.addAttribute("list", list);

		//go  back to UI page
		return "OrderMethodData";

	}

	// AJAX VALIDATIONS
	@GetMapping("/validateCode")
	public @ResponseBody String validateOrderCode(@RequestParam("code") String orderCode) {
		
		String message="";
		if(service.isOrderMethodExistByCode(orderCode))
		{
			message="Order Method '"+orderCode+"' Exists! Try Different";
		}
		return message;
	}
}
