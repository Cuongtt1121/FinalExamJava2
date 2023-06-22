package examjava2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static Map<String, Customer> customerMap = new HashMap<>();
    int choice;
        do {
        System.out.println("-------------List Customer------------ ");
        System.out.println("1.Add new customer.");
        System.out.println("2.Find by name");
        System.out.println("3.Display all cutomer");
        System.out.println("4.Exit");
        System.out.print("Enter your option:... ");
        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                displayAllCustomers();
                break;
            case 2:
                findCustomerByName(sc);
                break;
            case 3:
                displayAllCustomers(sc);
                break;
            case 4:
                System.out.println("Ứng dụng đã kết thúc.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                break;

        }while  (choice != 4);

    }



    private void displayAllCustomers() {
        try  {
            for (String i : customerMap.keySet()) {
                Customer displayCustomer = customerMap.get(i);
                System.out.println("Tên Khách: " + displayCustomer.getName());
                System.out.println("Email: " + displayCustomer.getEmail());
                System.out.println("Số Điện Thoại: " + displayCustomer.getPhone());
                System.out.println();
            }
    }

    private void findCustomerByName() {
            System.out.print("Nhập Người Cần Tìm: ");
            String findName = sc.nextLine();
            if (customerMap.containsKey(findName)) {
                Customer findCustomer = customerMap.get(findName);
                System.out.println("Tên Khách: " + findCustomer.getName());
                System.out.println("Email: " + findCustomer.getEmail());
                System.out.println("Số Điện Thoại: " + findCustomer.getPhone());
                System.out.println();
            } else {
                System.out.println("Không Thể Tìm Thấy:");
            }

        }

    }

    private void AddCustomer( {

    }


}

