package spring.reqParameterChoice;



// same uri with run-time deciding which uri to use as per parameters.
@RestController
public class HomeController {

	
	@RequestMapping(value="/index", params = {"!name", "!foo"})
    public List<Something> listItems(){
        // retrieve Something list
    }

    @RequestMapping(value="/index", params = "name")
    public List<Something> listItems(String name) {
        // retrieve Something list WHERE name LIKE %name%
    }

    @RequestMapping(value="/index", params = {"!name", "foo"})
    public List<Something> listItems(String foo) {
        // Do something completely different
    }
}
