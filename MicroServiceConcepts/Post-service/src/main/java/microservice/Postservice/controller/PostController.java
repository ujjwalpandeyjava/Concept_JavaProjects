package microservice.Postservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import microservice.Postservice.entities.Post;
import microservice.Postservice.respos.inter.PostRepo;

@RestController
@RequestMapping("/postService")
public class PostController {

	@Autowired
	private PostRepo postRepo;

	@GetMapping("/")
	public ResponseEntity<Object> allPost() {
		return ResponseEntity.status(HttpStatus.OK).body(postRepo.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> allSinglePost(@PathVariable(name = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(postRepo.findById(id));
	}

	@PostMapping("/newPost")
	public ResponseEntity<Object> newPost(@Valid @RequestBody Post newPost) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postRepo.save(newPost));
	}

}
