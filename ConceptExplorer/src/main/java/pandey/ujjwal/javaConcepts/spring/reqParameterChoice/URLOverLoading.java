package pandey.ujjwal.javaConcepts.spring.reqParameterChoice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Same URI with run-time deciding which uri to use as per parameters.
@RestController
public class URLOverLoading {

	
	@RequestMapping(value="/index", params = {"!name", "!foo"})
    public void listItems(){
		// retrieve Something list
	}

    @RequestMapping(value="/index", params = "name")
    public void listItemsN(String name) {
        // retrieve Something list WHERE name LIKE %name%
    }

    @RequestMapping(value="/index", params = {"!name", "foo"})
    public void listItemsF(String foo) {
        // Do something completely different
    }
}
