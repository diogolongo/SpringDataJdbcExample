package br.com.llongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.llongo.persistence.entities.Task;
import br.com.llongo.persistence.repository.TaskRepository;

@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {
	private TaskRepository taskRepository;

	@Autowired
	public HelloWorldController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(ModelMap model) {
		model.addAttribute("msg", taskRepository.findOne(2).getName());
		return "helloWorld";
	}
	@RequestMapping(value = "/insert/{id}/{name}/{desc}", method = RequestMethod.GET)
	@Transactional(propagation=Propagation.REQUIRED)
	public String insert(ModelMap model, @PathVariable Integer id,@PathVariable String name,@PathVariable String desc) {
		taskRepository.save(new Task(null,name,desc));
		return "success";
	}

	@RequestMapping(value = "/displayMessage/{msg}", method = RequestMethod.GET)
	public String displayMessage(@PathVariable Integer msg, ModelMap model) {
		model.addAttribute("msg", taskRepository.findOne(msg).getName());
		return "helloWorld";
	}

}