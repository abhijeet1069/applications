package com.satyam.algoexp.list.main;

import java.util.List;

import com.satyam.algoexp.list.model.Data;
import com.satyam.algoexp.list.xmlTools.validator.XMLSchemaValidator;

// OP - [Fe, Fi, Fo, Fum]

public class App {

	public static void main(String[] args) {
		String xml = "src/main/resources/list/list.xml";
		String xsd = "src/main/resources/list/list.xsd";
		
		XMLSchemaValidator.ValidationResult result = XMLSchemaValidator.validate(xml, xsd);
		if(result.isValid()) {
			Data data = XMLSchemaValidator.unmarshal(xml, Data.class);
			List<String> list = data.getStringList().getValue();
			System.out.println(list);
		}
	}
}
