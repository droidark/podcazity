package net.virux.podcazity.controller;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWSController {

	@RequestMapping(value = "/rest", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<String> hola(){
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("hola");
		lista.add("mundo");
		return lista;
	}
}
