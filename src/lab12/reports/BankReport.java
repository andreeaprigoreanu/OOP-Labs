package lab12.reports;

import java.beans.Customizer;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lab12.entities.*;

public class BankReport {
    // Customer = Employee of the Business
    // Business = a client of the Bank
    // Customers of the Bank = all the Employees that work for the Businesses that are clients of the Bank

    public static int getNumberOfCustomers(Bank bank) {
        // All the customers that have accounts at the bank

        return bank.getClients().stream()
                .mapToInt(business -> business.getEmployees().size())
                .sum();
    }

    public static int getNumberOfAccounts(Bank bank) {
        // Accounts of all the customers of the bank
        int numAccounts = 0;

        for (Business business : bank.getClients()) {
            numAccounts += business.getEmployees().stream()
                    .mapToInt(employee -> employee.getAccounts().size())
                    .sum();
        }
        return numAccounts;
    }

    public static SortedSet<Employee> getCustomersSorted(Bank bank) {
        // Display the set of customers in alphabetical order
        List<Employee> customers = bank.getClients().stream()
                .flatMap(business -> business.getEmployees().stream())
                .collect(Collectors.toList());

        return new TreeSet<>(customers);
    }

    public static double getTotalSumInAccounts(Bank bank) {
        // Sum of all customers' accounts balances
        List<Employee> customers = bank.getClients().stream().flatMap(business -> business.getEmployees().stream())
                .collect(Collectors.toList());
        double sum = 0.0;
        for (Employee customer : customers) {
            sum += customer.getAccounts().stream().mapToDouble(Account::getBalance).sum();
        }

        return sum;
    }

    public static SortedSet<Account> getAccountsSortedBySum(Bank bank) {
        // The set of all accounts, ordered by current account balance
        List<Employee> customers = bank.getClients().stream()
                .flatMap(business -> business.getEmployees().stream())
                .collect(Collectors.toList());
        List<Account> accounts = customers.stream()
                .flatMap(customer -> customer.getAccounts().stream())
                .collect(Collectors.toList());

        return new TreeSet<>(accounts);
    }

    public static Map<Employee, Collection<Account>> getCustomerAccounts(Bank bank) {
        // Return a map of all the customers with their respective accounts
        List<Employee> customers = bank.getClients().stream()
                .flatMap(business -> business.getEmployees().stream())
                .collect(Collectors.toList());

        return customers.stream()
                .collect(Collectors.toMap(customer -> customer, Employee::getAccounts));
    }

    public static Map<String, List<Employee>> getCustomersByCity(Bank bank) {
        // Map all the customers to their respective cities
        List<Employee> customers = bank.getClients().stream()
                .flatMap(business -> business.getEmployees().stream())
                .collect(Collectors.toList());

        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee customer : customers) {
            if (!map.containsKey(customer.getCity())) {
                map.put(customer.getCity(), new ArrayList<>());
            }
            map.get(customer.getCity()).add(customer);
        }

        return map;
    }

    public static Project getProjectWorkedOnByMostCustomers(Bank bank) {
        // Get all the projects from the employees and find the most repeated one in the list
        List<Employee> customers = bank.getClients().stream()
                .flatMap(business -> business.getEmployees().stream())
                .collect(Collectors.toList());
        List<Project> projects = customers.stream()
                .flatMap(customer -> customer.getProjects().stream())
                .collect(Collectors.toList());

        Map <Project, Integer> frequency = new HashMap<>();
        for (Project project : projects) {
            if (!frequency.containsKey(project)) {
                frequency.put(project, 1);
            } else {
                frequency.put(project, frequency.get(project) + 1);
            }
        }
        SortedMap<Project, Integer> sortedMap = new TreeMap<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return frequency.get(o2).compareTo(frequency.get(o1));
            }
        });
        sortedMap.putAll(frequency);

        return sortedMap.firstKey();
    }

    public static Gender getGenderWhoWorkedOnMostProjects(Bank bank) {
        // Get all the pairs <gender, project> or <gender, List<project>>, then reduce the array to only one pair
        // of each gender and retrieve the one with most counted projects (you are expected to count duplicates as well).
        List<Employee> customers = bank.getClients().stream()
                .flatMap(business -> business.getEmployees().stream())
                .collect(Collectors.toList());
        ArrayList<Pair<Gender, Project>> listOfGendersAndProjects = new ArrayList<>();
        for (Employee customer : customers) {
            customer.getProjects().
                    forEach(project -> listOfGendersAndProjects.add(new Pair<>(customer.getGender(),project)));

        }

        List<Pair<Gender, Project>> projectsByMales = listOfGendersAndProjects.stream().
                filter(pair -> pair.key.equals(Gender.MALE)).collect(Collectors.toList());
        List<Pair<Gender, Project>> projectsByFemales = listOfGendersAndProjects.stream()
                .filter(pair -> pair.key.equals(Gender.FEMALE)).collect(Collectors.toList());

        if (projectsByFemales.size() > projectsByMales.size()) {
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }
}
