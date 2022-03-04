package lab12.reports;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lab12.entities.*;

public class BusinessReport {

    public static Map<Disability, List<Employee>> getEmployeesOnSameDisability(Business business) {
        // Get employees and map them on the type of disability they possess

        return business.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDisability));
    }

    public static long getNumberOfDifferentProjectsWorkedByCurrentFemaleEmployees(Business business) {
        // Get employees, filter by gender, get their projects without duplicates, count
        List<Employee> femaleEmployees = business.getEmployees().stream()
                .filter(employee -> employee.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        List<Project> projectsByFemalesEmployees = femaleEmployees.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .collect(Collectors.toList());
        projectsByFemalesEmployees = projectsByFemalesEmployees.stream()
                .distinct()
                .collect(Collectors.toList());

        return projectsByFemalesEmployees.size();
    }

    public static SortedSet<Employee> getEmployeesMaxByReligionMinByGenderSortedByCitySortedByAge(Business business) {
        // Get the employees with majority by religion, from this group select the subgroup that has the minority by gender
        // Sort the set by city and, in case of equality, by age
        Map<Religion, List<Employee>> employeesByReligion = business.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getReligion));
        SortedMap<Religion, List<Employee>> sortedEmployeesByReligion= new TreeMap<>((o1, o2) ->
                employeesByReligion.get(o2).size() - employeesByReligion.get(o1).size());
        sortedEmployeesByReligion.putAll(employeesByReligion);

        List<Employee> employeesWithMaxReligion = sortedEmployeesByReligion.get(sortedEmployeesByReligion.firstKey());

        Map<Gender, List<Employee>> employeesByGender = employeesWithMaxReligion.stream()
                .collect(Collectors.groupingBy(Employee::getGender));

        Gender minorityGender = employeesByGender.get(Gender.MALE).size()
                > employeesByGender.get(Gender.FEMALE).size() ? Gender.FEMALE : Gender.MALE;
        List<Employee> employeesWithMaxReligionMinGender = employeesByGender.get(minorityGender);

        SortedSet<Employee> employeesMaxByReligionMinByGenderSortedByCitySortedByAge = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getCity().compareTo(o2.getCity()) == 0) {
                    return o1.getAge() - o2.getAge();
                } else {
                    return o1.getCity().compareTo(o2.getCity());
                }
            }
        });

        employeesMaxByReligionMinByGenderSortedByCitySortedByAge.addAll(employeesWithMaxReligionMinGender);

        return employeesMaxByReligionMinByGenderSortedByCitySortedByAge;
    }

    public static Religion getReligionOfEmployeesWithMostAccounts(Business business) {
        // Group employees by religion, count the accounts in each group, return the religion with biggest score
        Map<Religion, List<Employee>> employeesByReligion = business.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getReligion));

        Map<Religion, Integer> employeesByReligionAndAccounts = new HashMap<>();
        for (Map.Entry<Religion, List<Employee>> entry : employeesByReligion.entrySet()) {
            List<Employee> employeesList = entry.getValue();
            Integer numAccounts = employeesList.stream()
                    .mapToInt(employee -> employee.getAccounts().size())
                    .sum();
            employeesByReligionAndAccounts.put(entry.getKey(), numAccounts);
        }

        SortedMap<Religion, Integer> sortedEmployeesByReligionAndAccounts = new TreeMap<>(new Comparator<Religion>() {
            @Override
            public int compare(Religion o1, Religion o2) {
                return employeesByReligionAndAccounts.get(o2) - employeesByReligionAndAccounts.get(o1);
            }
        });

        sortedEmployeesByReligionAndAccounts.putAll(employeesByReligionAndAccounts);


        return sortedEmployeesByReligionAndAccounts.firstKey();
    }

    public static Map<Religion, Map<Gender, List<Employee>>> getEmployeesOnSameReligionAndGender(Business business) {
        // Map the employees by religion (Map<Religion, List<Employee>>) then map each of the lists by city (Map<String, List<Employee>>)
        // Hint: use Collectors.groupingBy(Function, Collector)

        return business.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getReligion,
                        Collectors.groupingBy(Employee::getGender)));
    }

    public static Map<Project, Map<String, List<Employee>>> getEmployeesOnSameProjectAndCity(Business business) {
        // Map the employees to the business projects (not to their respective projects)

        Map<Project, Map<String, List<Employee>>> map = new HashMap<>();
        for (Project project : business.getProjects()) {
            List<Employee> workers = business.getEmployees().stream()
                    .filter(employee -> employee.getProjects().contains(project))
                    .collect(Collectors.toList());
            Map<String, List<Employee>> citiesAndEmployeesList = workers.stream()
                    .collect(Collectors.groupingBy(Employee::getCity));

            map.put(project, citiesAndEmployeesList);
        }

        return map;
    }
}
