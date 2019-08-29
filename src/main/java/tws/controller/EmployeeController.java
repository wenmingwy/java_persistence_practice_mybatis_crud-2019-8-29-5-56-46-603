package tws.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.Employee;
import tws.repository.EmployeeMapper;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        employeeMapper.insertOne(employee);
        return employee;
    }

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		employeeMapper.updateOne(id, employee);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmployee(@PathVariable int id) {
		employeeMapper.deleteOne(id);
	}

}
