package com.codecomplexity.analyzer.resource;

import com.codecomplexity.analyzer.model.CodeComplexity;
import com.codecomplexity.analyzer.model.Input;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/complexity")
@CrossOrigin("*")
public class CodeComplexityResource {

    private final ChatClient chatClient;

    public CodeComplexityResource(OllamaChatModel ollamaChatModel) {
        this.chatClient = ChatClient.create(ollamaChatModel);
    }

    @PostMapping("/analyzer")
    public ResponseEntity<CodeComplexity> getCodeComplexity(@RequestBody Input input) {

        String message = """
                You are a helpful AI assistant trained to analyze the time complexity of functions.

                Given a function, analyze its time complexity and respond with a single sentence in this **exact** format:
                "The time complexity of this function is O(...), where ..."

                Do NOT provide any explanation, code rewrite, or additional comments. Only return one sentence in the specified format.

                Function:
                %s
                """.formatted(input);

        ChatResponse chatResponse = chatClient
                .prompt(message)
                .call()
                .chatResponse();

        String complexity = chatResponse.getResult().getOutput().getText();
        System.out.println(complexity);
        return ResponseEntity.ok(new CodeComplexity(complexity));
    }
}
