package com.example.emptask.repository;


import com.example.emptask.entity.Employee;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //1 Names of all employees
    @Query("SELECT e.name FROM Employee e")
    List<String> getAllEmployeeNames();

    //2 Total employees
    long count();

    //3 Departments
    @Query("SELECT DISTINCT e.department FROM Employee e")
    List<String> getDepartments();

    //4 Employees count in each department
    @Query("SELECT e.department, COUNT(e) FROM Employee e GROUP BY e.department")
    List<Object[]> employeesPerDepartment();

    //5 Highest paid employee
    Employee findTopByOrderBySalaryDesc();

    //6 Lowest paid employee
    Employee findTopByOrderBySalaryAsc();

    //7 Salary > 20000
    List<Employee> findBySalaryGreaterThan(Double salary);

    //8 Average salary
    @Query("SELECT AVG(e.salary) FROM Employee e")
    Double getAverageSalary();

    //9 Top 5 highest salary
    List<Employee> findTop5ByOrderBySalaryDesc();

    //10 Marketing department employees
    List<Employee> findByDepartment(String department);

    //11 Salary between range
    List<Employee> findBySalaryBetween(Double min, Double max);

    //12 Salary NULL
    List<Employee> findBySalaryIsNull();

    //13 Name starting with J
    List<Employee> findByNameStartingWith(String prefix);

    //14 Salaries descending
    @Query("SELECT e.salary FROM Employee e ORDER BY e.salary DESC")
    List<Double> getSalariesDesc();

    //15 Total salary expenditure
    @Query("SELECT SUM(e.salary) FROM Employee e")
    Double totalSalary();

    //16 Employees with same names
    @Query("SELECT e.name FROM Employee e GROUP BY e.name HAVING COUNT(e.name)>1")
    List<String> duplicateNames();

    //17 Employees in Pune
    long countByLocation(String location);

    //18 Average salary Dev department
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department='Dev'")
    Double avgSalaryDev();

    //19 Salary above average
    @Query("SELECT e FROM Employee e WHERE e.salary > (SELECT AVG(e.salary) FROM Employee e)")
    List<Employee> salaryAboveAverage();

    //20 Lowest salary Test department
    Employee findTopByDepartmentOrderBySalaryAsc(String department);

    //21 Employees hired in 2023
    @Query("SELECT e FROM Employee e WHERE YEAR(e.hireDate)=2023")
    List<Employee> employeesHired2023();

    //22 Count hired in 2023
    @Query("SELECT COUNT(e) FROM Employee e WHERE YEAR(e.hireDate)=2023")
    long countHired2023();

    //23 Total salary Dev + Support
    @Query("SELECT SUM(e.salary) FROM Employee e WHERE e.department IN ('Dev','Support')")
    Double totalSalaryDevSupport();

    //24 Salary greater than Dev average
    @Query("SELECT e FROM Employee e WHERE e.salary > (SELECT AVG(e.salary) FROM Employee e WHERE e.department='Dev')")
    List<Employee> salaryGreaterThanDevAverage();

    //25 Total salary in Pune
    @Query("SELECT SUM(e.salary) FROM Employee e WHERE e.location='Pune'")
    Double totalSalaryPune();
}

