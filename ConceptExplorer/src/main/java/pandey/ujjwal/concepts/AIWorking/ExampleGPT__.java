package pandey.ujjwal.concepts.AIWorking;

import java.util.Map;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.theokanning.openai.client.OpenAiApi;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import reactor.core.publisher.Flux;

public class ExampleGPT__ {
	
	@Value("${OPENAI_API_KEY:default_value}")
	private String OPENAI_API_KEY;
	
	public static void main(String[] a) {
		String apiKey = "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";
		String url = "https://api.openai.com/v1/chat/completions";
		String model = "gpt-3.5-turbo";

		OpenAiService service = new OpenAiService(apiKey);
		System.out.println(service);
		CompletionRequest completionRequest = CompletionRequest.builder()
				.prompt("hello, how are you? Can you tell me what's a Fibonacci Number?").model("GPT base").echo(true)
				.build();

		service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
	}

	@GetMapping("/ai/generateStream")
	public Flux<ChatResponse> generateStream(
			@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
		Prompt prompt = new Prompt(new UserMessage(message));
//	        return chatClient.stream(prompt);
		return null;
	}

	@GetMapping("/ai/generate")
	    public Map generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
//	    	
//	        
//	    	var openAiApi = new org.springframework.ai.openai.api.OpenAiApi(OPENAI_API_KEY);
//	        var chatClient = new OpenAiChatClient(openAiApi).
//	        		.withDefaultOptions(
//	        				OpenAiChatOptions.builder()
//	        				.withModel("gpt-35-turbo")
//	        				.withTemperature(0.5f)
//	        				.withMaxTokens(200)
//	        				.build()
//	                );
//
////	        ChatResponse response = chatClient.call(new Prompt("Generate the names of 5 famous pirates."));
////	        Flux<ChatResponse> response = chatClient.stream(new Prompt("Generate the names of 5 famous pirates."));
//	        
////	        return Map.of("generation", chatClient.call(new Prompt(message)));
	        return null;

	}
}

/**
 * // Curl Requset curl --location 'https://api.openai.com/v1/embeddings' \
 * --header 'Content-Type: application/json' \ --header 'Authorization: Bearer
 * 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' \ --data '{ "input":
 * "list the indian dog breads", "model": "text-embedding-ada-002" }'
 * 
 * 
 * Response: { "error": { "message": "You exceeded your current quota, please
 * check your plan and billing details.", "type": "insufficient_quota", "param":
 * null, "code": "insufficient_quota" } }
 * 
 * 
 * I tried several modules yet always getting response of insufficient_quota.
 * 
 */