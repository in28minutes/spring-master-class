#First Spring MVC Controller
- @RequestMapping(value = "/login", method = RequestMethod.GET)
- http://localhost:8080/spring-mvc/login
- web.xml - <url-pattern>/spring-mvc/*</url-pattern>
- Why @ResponseBody?
- Important of RequestMapping method
- Can I have multiple urls rendered from Same Controller?

#Snippets
```
package com.in28minutes.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	@ResponseBody
	public String sayHello() {
		return "Hello World dummy";
	}
}

```

## Files List
NOT AVAILABLE
