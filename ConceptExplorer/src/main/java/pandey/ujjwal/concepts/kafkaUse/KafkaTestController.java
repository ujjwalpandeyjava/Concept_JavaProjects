package pandey.ujjwal.concepts.kafkaUse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaTestController {

	@Autowired
	private MyKafkaProducer producer;

	@PostMapping("/send")
	public String send(@RequestParam String message) {
		producer.sendMessage("my-topic", message);
		return "Message sent!";
	}
}
