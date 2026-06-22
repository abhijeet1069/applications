package com.satyam.algoexp.list.xmlTools.validator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLSchemaValidator {

	public static class ValidationResult {
		private final boolean valid;
		private final List<String> messages;

		public ValidationResult(boolean valid, List<String> messages) {
			this.valid = valid;
			this.messages = messages;
		}
				
		public boolean isValid() {
			return valid;
		}

		@Override
		public String toString() {
			return "ValidationResult [valid=" + valid + ", messages=" + messages + "]";
		}
	}

	/** Validate XML against XSD. Collects ALL warnings/errors/fatals. */
	public static ValidationResult validate(String xmlPath, String xsdPath) {
		List<String> msgs = new ArrayList<>();
		try {
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(new File(xsdPath));

			Validator v = schema.newValidator();
			v.setErrorHandler(new ErrorHandler() {
				private String fmt(String lvl, SAXParseException e) {
					return String.format("%s %s:%d:%d %s", lvl, safeSystemId(e), e.getLineNumber(), e.getColumnNumber(),
							e.getMessage());
				}

				private String safeSystemId(SAXParseException e) {
					return e.getSystemId() != null ? e.getSystemId() : new File(xmlPath).getName();
				}

				@Override
				public void warning(SAXParseException e) {
					msgs.add(fmt("WARN", e));
				}

				@Override
				public void error(SAXParseException e) {
					msgs.add(fmt("ERROR", e));
				}

				@Override
				public void fatalError(SAXParseException e) {
					msgs.add(fmt("FATAL", e));
				}
			});

			v.validate(new StreamSource(new File(xmlPath)));
			boolean ok = msgs.stream().noneMatch(m -> m.startsWith("ERROR") || m.startsWith("FATAL"));
			return new ValidationResult(ok, msgs);

		} catch (SAXException | IOException ex) {
			msgs.add("FATAL " + ex.getMessage());
			return new ValidationResult(false, msgs);
		}
	}
	
	 /** Unmarshal XML into the given @XmlRootElement type (no schema check here). */
    public static <T> T unmarshal(String xmlPath, Class<T> rootType) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(rootType);
            Unmarshaller um = ctx.createUnmarshaller();
            @SuppressWarnings("unchecked")
            T obj = (T) um.unmarshal(new File(xmlPath));
            return obj;
        } catch (JAXBException e) {
            throw new RuntimeException("Unmarshal failed: " + e.getMessage(), e);
        }
    }

}
