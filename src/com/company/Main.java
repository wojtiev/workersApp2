package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int employeeID = 1;

        Employee employee1 = new Employee("John", "Doe", "Manager", employeeID++, 75000);
        Employee employee2 = new Employee("Jane", "Smith", "Accountant", employeeID++, 60000);
        Employee employee3 = new Employee("Michael", "Johnson", "Accountant", employeeID++, 55000);
        Employee employee4 = new Employee("Emily", "Jones", "Marketing Specialist", employeeID++, 50000);
        Employee employee5 = new Employee("David", "Brown", "Accountant", employeeID++, 45000);
        Employee employee6 = new Employee("Laura", "Taylor", "Human Resources Manager", employeeID++, 70000);
        Employee employee7 = new Employee("Kevin", "Wilson", "IT Specialist", employeeID++, 60000);
        Employee employee8 = new Employee("Samantha", "Davis", "Customer Service Representative", employeeID++, 40000);


        String imie = null;
        String nazwisko = null;
        String stanowisko = null;
        int zarobki = 0;
        int idWorker = 0;
        Scanner inputReader = new Scanner(System.in);

        HashMap<Integer,Employee> employeeHashMap = new HashMap<>();
        EmployeeManager employeeManager = new EmployeeManager(employeeHashMap);
        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);
        employeeManager.addEmployee(employee3);
        employeeManager.addEmployee(employee4);
        employeeManager.addEmployee(employee5);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            System.out.println("1.Dodaj pracownika");
            System.out.println("2.Usuń pracownika");
            System.out.println("3.Zaktualizuj dane o pracowniku");
            System.out.println("4.Wyszukaj pracownika po ID");
            System.out.println("5.Wyświetl liste wszystkich pracownikow");
            System.out.println("6.Wyszukaj pracownika po pozycji");
            System.out.println("Inna wartosc zakonczy program");
            int input = Integer.parseInt(bufferedReader.readLine());
            switch (input){
                case 1:
                    //employeeManager.addEmployee(employee7);
                    System.out.println("Podaj imie <potwierdz Enter>:");
                    imie=inputReader.nextLine();
                    System.out.println("Podaj nazwisko <potwierdz Enter>:");
                    nazwisko=inputReader.nextLine();
                    System.out.println("Podaj stanowisko <potwierdz Enter>:");
                    stanowisko=inputReader.nextLine();
                    System.out.println("Określ zarobki <potwierdz Enter>:");
                    zarobki= Integer.parseInt(bufferedReader.readLine());

                    //System.out.println("imie, nazwisko, stanowisko, zarobki, id: "+imie+", "+nazwisko+", "+stanowisko+", "+zarobki+", "+idWorker);
                    employeeManager.addEmployee(new Employee(imie, nazwisko, stanowisko, employeeID++, zarobki));
                    break;
                case 2:
                {
                    System.out.println("Podaj id pracownika do usunięcia <potwierdz Enter>:");
                    int id = Integer.parseInt(bufferedReader.readLine());
                    employeeManager.removeEmployee(employeeManager.searchEmployeeByID(id));
                    break;
                }
                case 3:
                {
                    System.out.println("Podaj id pracownika do edycji <potwierdz Enter>:");
                    int id = Integer.parseInt(bufferedReader.readLine());
                    Employee employee = employeeManager.searchEmployeeByID(id);
                    if(employee != null){
                        System.out.println("Obecne zarobki pracownika: " + employee.getSalary());
                        System.out.println("Podaj nowe zarobki pracownika <potwierdz Enter>:");
                        int noweZarobki = Integer.parseInt(bufferedReader.readLine());
                        employee.setSalary(noweZarobki);
                        System.out.println("Obecne stanowisko pracownika: " + employee.getPosition());
                        System.out.println("Podaj nowe stanowisko pracownika <potwierdz Enter>:");
                        String noweStanowisko = bufferedReader.readLine();
                        employee.setPosition(noweStanowisko);
                        employeeManager.updateEmployee(id,employee);}
                    break;

                }
                case 4:
                {
                    System.out.println("Podaj id pracownika do wyszukania <potwierdz Enter>:");
                    int id = Integer.parseInt(bufferedReader.readLine());
                    Employee employee = employeeManager.searchEmployeeByID(id);
                    System.out.println(employee);
                    break;
                }
                case 5:
                {
                    employeeManager.listAllEmployees();
                    break;
                }
                case 6:
                {
                    System.out.println("Podaj stanowisko pracownika do wyszukania <potwierdz Enter>:");
                    String position = bufferedReader.readLine();
                    HashSet<Employee> employeeHashSet = employeeManager.searchEmployeesByPosition(position);
                    for (Employee employee: employeeHashSet
                    ) {
                        System.out.println(employee);
                    }
                    break;

                }
                default:
                    System.exit(0);
            }
        }
    }
}
