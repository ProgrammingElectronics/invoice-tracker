package com.invoicetracker.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invoicetracker.repositories.ServiceItemRepository;
import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.ServiceItem;

@CrossOrigin
@Controller
@RequestMapping("/search-serviceItem-view")
public class ServiceItemController {
	
	@Resource
	private ServiceItemRepository serviceItemRepo;

	@GetMapping("")
	private String viewServiceItemList(Model model) {				
		
		Collection<ServiceItem> serviceItems = (Collection<ServiceItem>) serviceItemRepo.findAll();
		model.addAttribute("servieItems", serviceItems);
		
		return "search-serviceItems";
	}

}