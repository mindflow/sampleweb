package com.justright.sampleweb.exception;

import org.springframework.stereotype.Component;

import com.justright.component.defaults.TemplateComponent;
import com.justright.entrypoint.ErrorEntrypoint;
import com.justright.entrypoint.annotation.EntrypointConfig;
import com.justright.entrypoint.defaults.MissingEntrypoint;

@Component("errorEntrypoint")
@EntrypointConfig(uri="/Error",docType=MissingEntrypoint.HTML_4_01_TRANSITIONAL_EN_DOCTYPE)
public class SampleErrorEntrypoint extends ErrorEntrypoint {

	private TemplateComponent templateComponent;
	
	@Override
	public void assemble() {
		templateComponent = new TemplateComponent();
	}

	@Override
	public String render() {
		StringBuilder output = new StringBuilder();
		if (getThrowable() == null && getStatusCode() == null) {
			output.append("<h2>Error information is missing</h2>");
			output.append("Please return to the <a href=\"http://localhost:8080/\">Home Page</a>.");
		} else if (getStatusCode() != null) {
			output.append("The status code : " + getStatusCode());
		}
		output.append("<h2>Sample error information</h2>");
		output.append("Servlet Name : " + getServletName() + "</br>");
		output.append("Exception Type : " + getThrowable().getClass().getName() + "</br>");
		output.append("The request URI: " + getRequestUri() + "<br><br/>");
		output.append(getThrowable().getClass().getName() + " " + getThrowable().getMessage() + "<br/>");
		for (StackTraceElement element : getThrowable().getStackTrace()) {
			if (element.getClassName() != null) {
				output.append("<div style=\"margin-left:40px;color:red;\">"+ element.getClassName()+ "."+ element.getMethodName()+ "("+ asLineNumberInFile(element.getFileName(),element.getLineNumber()) + ")</div>");
			}
		}
		output.append("</body>");
		output.append("</html>");
		//return templateComponent.render();
		return output.toString();
	}
	
	private String asLineNumberInFile(String fileName, int lineNumber) {
		if (lineNumber == -1 || fileName == null) {
			return "Unknown source";
		}
		return fileName + ":" + String.valueOf(lineNumber);
	}

}
