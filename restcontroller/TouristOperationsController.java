package in.priyankait.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.priyankait.entity.Tourist;
import in.priyankait.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {
	@Autowired
	private ITouristMgmtService service;	
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist)throws  Exception{
		
			//use service
			String resultMsg=service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);//201 content created successfully
		
	}//method
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourists()throws Exception{
		List<Tourist> list =service.fetchAllTourists();
		return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id")Integer id)throws Exception{
		System.out.println("TouristOperationsController.displayTouristById()--before");
		Tourist list =service.getTouristById(id);
		System.out.println("TouristOperationsController.displayTouristById()--after");
		return new ResponseEntity<Tourist>(list,HttpStatus.OK);
	}
	/*
	@PutMapping("/Modify")
	public ResponseEntity<String> ModifyTourist(@RequestBody Tourist tourist)throws Exception{
		String msg=service.updateTouristDetails(tourist);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
		
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTourist(@PathVariable("id")Integer id)throws Exception{
		String msg=service.deleteTourist(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> ModifyTouristBudgetById(@PathVariable("id")Integer id,@PathVariable("hike")
	                                                Float hikePercent)throws Exception{
		String msg=service.updateTouristBudgetById(id,hikePercent);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}*/

}
