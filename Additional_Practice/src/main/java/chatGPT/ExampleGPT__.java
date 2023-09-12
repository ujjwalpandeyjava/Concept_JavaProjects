package chatGPT;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ExampleGPT__ {
	public static void main(String[] a) {
		String apiKey = "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";
		String url = "https://api.openai.com/v1/chat/completions";
		String model = "gpt-3.5-turbo";
		
		OpenAiService service = new OpenAiService(apiKey);
		System.out.println(service);
		CompletionRequest completionRequest = CompletionRequest.builder()
		        .prompt("hello, how are you? Can you tell me what's a Fibonacci Number?")
		        .model("GPT base")
		        .echo(true)
		        .build();
		
		service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
	}
}


/**
//	Curl Requset
curl --location 'https://api.openai.com/v1/embeddings' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer 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' \
--data '{
    "input": "list the indian dog breads",
    "model": "text-embedding-ada-002"
}'
 
 
Response: 
{
    "error": {
        "message": "You exceeded your current quota, please check your plan and billing details.",
        "type": "insufficient_quota",
        "param": null,
        "code": "insufficient_quota"
    }
}


I tried several modules yet always getting response of insufficient_quota.

 */