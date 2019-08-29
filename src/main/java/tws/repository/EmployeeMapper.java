package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();
    
    void insertOne(@Param("employee") Employee employee);

    void updateOne(@Param("id") int id, @Param("employee") Employee employee);

    void deleteOne(@Param("id") int id);
}
