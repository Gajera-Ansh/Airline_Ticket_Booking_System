
/* --------------------------------------------------------Shree Ganeshay Namah------------------------------------------------ */
import java.util.*;

public class Airline {
    static Scanner sc = new Scanner(System.in);
    String fullName;
    String mobileNumber;
    String birthDate;
    String bookingDate;
    String email;
    String password;
    StringBuffer from, to;
    int seat;
    String flightNumber;
    StringBuffer food = new StringBuffer();
    int bill;
    boolean ticketBook;
    static int accountNumber;

    static {
        System.out.println("\n---------------------------------------------------------\n" +
                "Welcome to Airline Ticket Booking System\n---------------------------------------------------------\n");
    }

    void signup(Airline[] a, int id) {
        System.out.print("\n---------------------------------------------------------\nEnter first name: ");
        String f = sc.next().trim().toUpperCase();
        System.out.print("Enter Last name: ");
        String l = sc.next().trim().toUpperCase();
        a[id].fullName = f + " " + l;

        boolean exit = true;
        while (exit) {
            boolean status = true;
            System.out.print("Enter Mobile Number: ");
            a[id].mobileNumber = sc.next().trim();
            for (int i = 0; i < a.length - 1; i++) {
                if (a[id].mobileNumber.equals(a[i].mobileNumber)) {
                    System.out.println("\n---------------------------------------------------------\n" +
                            "Mobile Number already exist\nPlease try again...\n---------------------------------------------------------\n");
                    status = false;
                    break;
                } else {
                    status = true;
                }
            }
            if (status) {
                if (mobileNumber.length() == 10) {
                    for (int i = 0; i < mobileNumber.length(); i++) {
                        if (mobileNumber.charAt(i) >= '0' && mobileNumber.charAt(i) <= '9') {
                            status = false;
                        } else {
                            System.out.println("\n---------------------------------------------------------\n" +
                                    "Invalid Mobile Number\nPlease try again...\n---------------------------------------------------------\n");
                            status = true;
                            break;
                        }
                    }
                } else {
                    System.out.println("\n---------------------------------------------------------\n" +
                            "Invalid Mobile Number\nPlease try again...\n---------------------------------------------------------\n");
                    status = true;
                }
                if (status) {
                    continue;
                } else {
                    exit = false;
                }
            } else {
                continue;
            }
        }

        while (!exit) {
            System.out.print("Enter Birth Date (mm/dd/yyyy): ");
            a[id].birthDate = sc.next().trim();
            if (isValidDate(birthDate)) {
                exit = true;
            } else {
                System.out.println("\n---------------------------------------------------------\n" +
                        "Invalid Date\nPlease try again...\n---------------------------------------------------------\n");
                continue;
            }
        }

        while (exit) {
            boolean status = true;
            boolean isValid = false;
            System.out.print("Enter Email-Id: ");
            a[id].email = sc.next().trim();
            for (int i = 0; i < a.length - 1; i++) {
                if (a[id].email.equals(a[i].email)) {
                    System.out.println("\n---------------------------------------------------------\n" +
                            "Email already exist\nPlease try again...\n---------------------------------------------------------\n");
                    status = false;
                    break;
                } else {
                    status = true;
                }
            }
            if (status) {
                if (a[id].email.contains("@") && a[id].email.contains(".")) {
                    int at = a[id].email.indexOf("@");
                    int dot = a[id].email.lastIndexOf(".");
                    if (dot <= at) {
                        System.out.println("\n---------------------------------------------------------\n" +
                                "Format: abc@xyz.com\nPlease try again...\n---------------------------------------------------------\n");
                        continue;
                    } else {
                        for (int i = 0; i < a[id].email.length(); i++) {
                            if (i == at || i == dot) {
                                continue;
                            } else if ((a[id].email.charAt(i) >= 'a' && a[id].email.charAt(i) <= 'z')
                                    || (a[id].email.charAt(i) >= '0' && a[id].email.charAt(i) <= '9')) {
                                isValid = true;
                            } else {
                                isValid = false;
                                break;
                            }
                        }
                    }
                    if (isValid) {
                        exit = false;
                        break;
                    } else {
                        System.out.println("\n---------------------------------------------------------\n" +
                                "Format: abc@xyz.com\nPlease try again...\n---------------------------------------------------------\n");
                        continue;
                    }
                } else {
                    System.out.println("\n---------------------------------------------------------\n" +
                            "Format: abc@xyz.com\nPlease try again...\n---------------------------------------------------------\n");
                    continue;
                }
            } else {
                continue;
            }
        }

        while (!exit) {
            System.out.print("Enter Password: ");
            a[id].password = sc.next().trim();
            if (password.length() >= 6) {
                exit = true;
            } else {
                System.out.println("\n---------------------------------------------------------\n" +
                        "Password should be minimum 6 characters\nPlease try again...\n---------------------------------------------------------\n");
                continue;
            }
        }

        while (exit) {
            System.out.print("Confirm Password: ");
            String confirmPassword = sc.next().trim();
            if (confirmPassword.equals(password)) {
                System.out.println("\n---------------------------------------------------------\n" +
                        "Signup Successful\n---------------------------------------------------------\n");
                exit = false;
            } else {
                System.out.println(
                        "\n---------------------------------------------------------\nPassword does not match\nPlease try again...\n---------------------------------------------------------\n");
                continue;
            }
        }
    }

    boolean isValidDate(String date) {
        if (date.length() != 10) {
            return false;
        }
        if (date.charAt(2) != '/' || date.charAt(5) != '/') {
            return false;
        }
        String monthStr = date.substring(0, 2);
        String dayStr = date.substring(3, 5);
        String yearStr = date.substring(6, 10);
        if (!isNumber(yearStr) || !isNumber(monthStr) || !isNumber(dayStr)) {
            return false;
        }
        int day = toInt(dayStr);
        int month = toInt(monthStr);
        int year = toInt(yearStr);
        if (year > 2007 || year < 1980) {
            System.out.println("\n---------------------------------------------------------\n" +
                    "You are not eligible for this service\n---------------------------------------------------------");
            return false;
        }
        if (year > 2007 || year < 1980 || month < 1 || month > 12) {
            return false;
        }
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 2 && isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
        return day >= 1 && day <= daysInMonth[month - 1];
    }

    boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    int toInt(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result = result * 10 + (str.charAt(i) - '0');
        }
        return result;
    }

    boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean isValidTicketDate(String date) {
        if (date.length() != 10) {
            return false;
        }
        if (date.charAt(2) != '/' || date.charAt(5) != '/') {
            return false;
        }
        String monthStr = date.substring(0, 2);
        String dayStr = date.substring(3, 5);
        String yearStr = date.substring(6, 10);
        if (!isNumber(yearStr) || !isNumber(monthStr) || !isNumber(dayStr)) {
            return false;
        }
        int day = toInt(dayStr);
        int month = toInt(monthStr);
        int year = toInt(yearStr);
        if (year != 2025 || month < 1 || month > 2) {
            return false;
        }
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 2 && isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
        if (month == 2) {
            return day >= 23 && day <= daysInMonth[month - 1];
        } else if (month == 3) {
            return day >= 1 && day <= daysInMonth[month - 1];
        } else {
            return false;
        }
    }

    boolean login(Airline[] a) {
        boolean status = false;
        System.out.print("\n---------------------------------------------------------\nEnter Email-Id: ");
        String emailId = sc.next().trim();
        System.out.print("Enter password: ");
        String pass = sc.next().trim();
        for (int i = 0; i < a.length; i++) {
            if (pass.equals(a[i].password) && emailId.equals(a[i].email)) {
                System.out.println("\n---------------------------------------------------------\n" +
                        "Login Successful\n---------------------------------------------------------");
                accountNumber = i;
                status = false;
                break;
            } else {
                status = true;
            }
        }
        if (status) {
            System.out.println("\n---------------------------------------------------------\n" +
                    "Invalid Email-Id or Password\nPlease try again...\n---------------------------------------------------------\n");
            return false;
        } else {
            return true;
        }
    }

    void domestic() {
        System.out.println("\n--------------------------------------------");
        System.out.println("| ID | From |  To |  Duration |    Price   |\n");
        System.out.println("| 01 |  AHD | DEL |  01h 50m  | Rs.  4,500 |");
        System.out.println("| 02 |  AHD | BOM |  01h 20m  | Rs.  5,000 |");
        System.out.println("| 03 |  AHD | KOL |  02h 25m  | Rs. 10,400 |");
        System.out.println("| 04 |  AHD | BLR |  02h 30m  | Rs. 10,400 |");
        System.out.println("| 05 |  AHD | JAI |  01h 40m  | Rs.  6,500 |");
        System.out.println("| 06 |  AHD | GOA |  01h 40m  | Rs.  5,500 |");
        System.out.println("| 07 |  AHD | SXR |  02h 10m  | Rs. 11,000 |");
        System.out.println("| 08 |  AHD | CHE |  02h 25m  | Rs. 10,900 |");
        System.out.println("--------------------------------------------\n");
    }

    void international() {
        System.out.println("\n--------------------------------------------");
        System.out.println("| ID | From |  To |  Duration |    Price   |\n");
        System.out.println("| 01 |  AHD | YTO |  22h 52m  | Rs. 55,500 |");
        System.out.println("| 02 |  AHD | NYC |  17h 20m  | Rs. 50,000 |");
        System.out.println("| 03 |  AHD | DBX |  03h 25m  | Rs. 28,400 |");
        System.out.println("--------------------------------------------\n");
    }

    void internationalB() {
        System.out.println("\n--------------------------------------------");
        System.out.println("| ID | From |  To |  Duration |    Price    |\n");
        System.out.println("| 01 |  AHD | YTO |  22h 52m  | Rs. 101,500 |");
        System.out.println("| 02 |  AHD | NYC |  17h 20m  | Rs. 200,000 |");
        System.out.println("| 03 |  AHD | DBX |  03h 25m  | Rs.  50,400 |");
        System.out.println("--------------------------------------------\n");
    }

    void food() {
        System.out.println("\n----------------------------");
        System.out.println("| ID | Food Item |   Price |\n");
        System.out.println("| 01 |  Tea      | Rs. 100 |");
        System.out.println("| 02 |  Coffee   | Rs. 150 |");
        System.out.println("| 03 |  Burger   | Rs. 350 |");
        System.out.println("| 04 |  Pizza    | Rs. 500 |");
        System.out.println("| 05 |  Salad    | Rs. 200 |");
        System.out.println("| 06 |  Fries    | Rs. 150 |");
        System.out.println("| 07 |  Sandwich | Rs. 300 |");
        System.out.println("| 08 |  Dessert  | Rs. 350 |");
        System.out.println("----------------------------\n");
    }

    void foodBill(Airline[] aArray) {
        aArray[accountNumber].food = new StringBuffer();
        boolean foodStatus = true;
        while (foodStatus) {
            aArray[accountNumber].food();
            System.out.print("Enter Food ID: ");
            int foodID = sc.nextInt();
            switch (foodID) {
                case 1:
                    aArray[accountNumber].food = food.append("Tea, ");
                    aArray[accountNumber].bill += 100;
                    break;
                case 2:
                    aArray[accountNumber].food = food.append("Coffee, ");
                    aArray[accountNumber].bill += 150;
                    break;
                case 3:
                    aArray[accountNumber].food = food.append("Burger, ");
                    aArray[accountNumber].bill += 350;
                    break;
                case 4:
                    aArray[accountNumber].food = food.append("Pizza, ");
                    aArray[accountNumber].bill += 500;
                    break;
                case 5:
                    aArray[accountNumber].food = food.append("Salad, ");
                    aArray[accountNumber].bill += 200;
                    break;
                case 6:
                    aArray[accountNumber].food = food.append("Fries, ");
                    aArray[accountNumber].bill += 150;
                    break;
                case 7:
                    aArray[accountNumber].food = food.append("Sandwich, ");
                    aArray[accountNumber].bill += 300;
                    break;
                case 8:
                    aArray[accountNumber].food = food.append("Dessert, ");
                    aArray[accountNumber].bill += 350;
                    break;
                default:
                    System.out.println(
                            "\n---------------------------------------------------------\n"
                                    +
                                    "Invalid choice\nPlease try again...\n---------------------------------------------------------\n");
                    break;
            }
            System.out.println("\n1. Add More\n2. Continue");
            int choice = sc.nextInt();
            if (choice == 1) {
                continue;
            } else {
                foodStatus = false;
            }
        }
    }

    boolean cancleTicket(Airline[] a) {
        boolean cancleStatus = true;
        while (cancleStatus) {
            System.out.print("\nEnter Email Id: ");
            String cancleEmail = sc.next();
            System.out.print("Enter Password: ");
            String canclePassword = sc.next();
            sc.nextLine();
            System.out.print("Enter flight Number: ");
            String canlceFlight = sc.nextLine();
            if (a[accountNumber].email.equals(cancleEmail) && a[accountNumber].password.equals(canclePassword)
                    && a[accountNumber].flightNumber.equalsIgnoreCase(canlceFlight)) {
                System.out.println("\n---------------------------------------------------------\n" +
                        "Ticket Cancellation Successful\n" +
                        "---------------------------------------------------------\n");
                cancleStatus = false;

            } else {
                System.out.println("\n---------------------------------------------------------\n" +
                        "Invalid Credentials\nPlease try again...\n---------------------------------------------------------\n");
            }
        }
        if (!cancleStatus) {
            return false;
        } else {
            return true;
        }
    }

    void displayBill(Airline[] a) {
        System.out.println("\n------------------Bill----------------\n");
        System.out.println("Name: " + a[accountNumber].fullName);
        System.out.println("Email: " + a[accountNumber].email);
        System.out.println("Flight Number: " + a[accountNumber].flightNumber);
        System.out.println("From: " + a[accountNumber].from);
        System.out.println("To: " + a[accountNumber].to);
        System.out.println("Seat quantity: " + a[accountNumber].seat);
        System.out.println("Flight Booking Date: " + a[accountNumber].bookingDate);
        System.out.println("Food: " + a[accountNumber].food);
        System.out.println("Total Bill: Rs. " + a[accountNumber].bill);
        System.out.println("\n-------------------------------------\n");
    }

    void pay() {
        String mainPin = "123456";
        System.out.println("This is Airline UPI id: airline3254@sbi\n");
        boolean payStatus = true;
        while (payStatus) {
            System.out.print("Enter UPI id: ");
            String upi = sc.next().trim();
            System.out.print("Enter Pin: ");
            String pin = sc.next();
            if (pin.length() == 6) {
                if (pin.equals(mainPin) && upi.equals("airline3254@sbi")) {
                    payStatus = false;
                    System.out.println("\n---------------------------------------------------------\n" +
                            "Payment Successful\n---------------------------------------------------------\n");
                } else {
                    System.out.println(
                            "\n---------------------------------------------------------\n"
                                    +
                                    "Invalid Pin or UPI id\nPlease try again...\n---------------------------------------------------------\n");
                    continue;
                }
            } else {
                System.out.println(
                        "\n---------------------------------------------------------\n" +
                                "Pin length must be 6 digit\nPlease try again...\n---------------------------------------------------------\n");
                continue;
            }
        }
    }

    /*----------------------------------------------------Main Method---------------------------------------------------- */
    public static void main(String[] args) {
        Airline a = new Airline();
        Airline[] aArray = new Airline[0];
        boolean exit = true;
        boolean statusSignup = false;
        while (exit) {
            System.out.println("\n1. Signup\n2. Login\n3. Exit");
            int choice = sc.nextInt();

            /*-------------------------------Signup-------------------------------*/
            if (choice == 1) {
                System.out.println("\n-------------------------Signup-------------------------\n");
                aArray = Arrays.copyOf(aArray, aArray.length + 1);
                aArray[aArray.length - 1] = new Airline();
                aArray[aArray.length - 1].signup(aArray, aArray.length - 1);
                statusSignup = true;

                /*-------------------------------Login-------------------------------*/
            } else if (choice == 2) {
                System.out.println("\n-------------------------Login-------------------------\n");
                if (statusSignup) {
                    boolean status = a.login(aArray);
                    while (status) {
                        System.out.println("\n1.Book Ticket\n2.Cancel Ticket\n3.Previous Booking\n4.Logout");
                        int ch = sc.nextInt();

                        /*-------------------------------Boook Ticket-------------------------------*/
                        if (ch == 1) {
                            System.out.println("\n-------------------------Ticket Booking-------------------------\n");
                            System.out.println("1. Domestic\n2. International");
                            int c = sc.nextInt();

                            /*-------------------------------Domestic-------------------------------*/
                            if (c == 1) {
                                aArray[accountNumber].domestic();
                                System.out.print("Enter ID: ");
                                int id = sc.nextInt();
                                int flightStatus = (int) (Math.random() * 3) + 1;
                                if (flightStatus == 1 || flightStatus == 2) {
                                    aArray[accountNumber].from = new StringBuffer("AHD");
                                    switch (id) {
                                        case 1:
                                            aArray[accountNumber].to = new StringBuffer("DEL");
                                            aArray[accountNumber].bill = 4500;
                                            break;
                                        case 2:
                                            aArray[accountNumber].to = new StringBuffer("BOM");
                                            aArray[accountNumber].bill = 5000;
                                            break;
                                        case 3:
                                            aArray[accountNumber].to = new StringBuffer("KOL");
                                            aArray[accountNumber].bill = 10400;
                                            break;
                                        case 4:
                                            aArray[accountNumber].to = new StringBuffer("BLR");
                                            aArray[accountNumber].bill = 10400;
                                            break;
                                        case 5:
                                            aArray[accountNumber].to = new StringBuffer("JAI");
                                            aArray[accountNumber].bill = 6500;
                                            break;
                                        case 6:
                                            aArray[accountNumber].to = new StringBuffer("GOA");
                                            aArray[accountNumber].bill = 5500;
                                            break;
                                        case 7:
                                            aArray[accountNumber].to = new StringBuffer("SXR");
                                            aArray[accountNumber].bill = 11000;
                                            break;
                                        case 8:
                                            aArray[accountNumber].to = new StringBuffer("CHE");
                                            aArray[accountNumber].bill = 10900;
                                            break;
                                        default:
                                            System.out.println(
                                                    "\n---------------------------------------------------------\n" +
                                                            "Invalid choice\nPlease try again...\n---------------------------------------------------------\n");
                                            break;
                                    }
                                    boolean validDate = false;
                                    while (!validDate) {
                                        System.out.print("Enter departure date (mm/dd/yyyy): ");
                                        String date = sc.next();
                                        if (a.isValidTicketDate(date)) {
                                            aArray[accountNumber].bookingDate = date;
                                            validDate = true;
                                        } else {
                                            System.out.println(
                                                    "\n---------------------------------------------------------\n" +
                                                            "Invalid Date\nPlease try again...\n---------------------------------------------------------\n");
                                            continue;
                                        }
                                    }
                                    boolean seatStatus = true;
                                    while (seatStatus) {
                                        System.out.print("How many seat you want to book: ");
                                        aArray[accountNumber].seat = sc.nextInt();
                                        if (aArray[accountNumber].seat >= 1 && aArray[accountNumber].seat <= 5) {
                                            aArray[accountNumber].bill *= aArray[accountNumber].seat;
                                            seatStatus = false;
                                        } else {
                                            System.out.println(
                                                    "\n---------------------------------------------------------\n" +
                                                            "You can book minimume 1 and miaximume 5 seat\nPlease try again...\n---------------------------------------------------------\n");
                                            continue;
                                        }
                                    }
                                    int flightN = (int) (Math.random() * 10000);
                                    aArray[accountNumber].flightNumber = "SB " + Integer.toString(flightN);

                                    System.out.println("\n1. Food Option\n2. Continue");
                                    int choice1 = sc.nextInt();
                                    if (choice1 == 1) {
                                        aArray[accountNumber].foodBill(aArray);
                                        aArray[accountNumber].displayBill(aArray);
                                        a.pay();
                                        aArray[accountNumber].ticketBook = true;
                                    } else if (choice1 == 2) {
                                        aArray[accountNumber].displayBill(aArray);
                                        a.pay();
                                        aArray[accountNumber].ticketBook = true;
                                    } else {
                                        System.out.println(
                                                "\n---------------------------------------------------------\n" +
                                                        "Invalid choice\nPlease try again...\n---------------------------------------------------------\n");
                                    }
                                } else {
                                    System.out.println("\n---------------------------------------------------------\n" +
                                            "Flight is not available\nPlease try again...\n---------------------------------------------------------\n");
                                    continue;
                                }
                            }

                            /*-------------------------------International-------------------------------*/
                            else if (c == 2) {
                                System.out.println("\n1. Economy\n2. Business");
                                int choice2 = sc.nextInt();

                                /*-------------------------------Economy-------------------------------*/
                                if (choice2 == 1) {
                                    aArray[accountNumber].international();
                                    System.out.print("Enter ID: ");
                                    int id = sc.nextInt();
                                    int flightStatus = (int) (Math.random() * 3) + 1;
                                    if (flightStatus == 1 || flightStatus == 2) {
                                        aArray[accountNumber].from = new StringBuffer("AHD");
                                        switch (id) {
                                            case 1:
                                                aArray[accountNumber].to = new StringBuffer("YTO");
                                                aArray[accountNumber].bill = 55500;
                                                break;
                                            case 2:
                                                aArray[accountNumber].to = new StringBuffer("NYC");
                                                aArray[accountNumber].bill = 50000;
                                                break;
                                            case 3:
                                                aArray[accountNumber].to = new StringBuffer("DBX");
                                                aArray[accountNumber].bill = 28400;
                                                break;
                                            default:
                                                System.out.println(
                                                        "\n---------------------------------------------------------\n"
                                                                +
                                                                "Invalid choice\nPlease try again...\n---------------------------------------------------------\n");
                                                break;
                                        }
                                        boolean validDate = false;
                                        while (!validDate) {
                                            System.out.print("Enter departure date (mm/dd/yyyy): ");
                                            String date = sc.next();
                                            if (a.isValidTicketDate(date)) {
                                                aArray[accountNumber].bookingDate = date;
                                                validDate = true;
                                            } else {
                                                System.out.println(
                                                        "\n---------------------------------------------------------\n"
                                                                +
                                                                "Invalid Date\nPlease try again...\n---------------------------------------------------------\n");
                                                continue;
                                            }
                                        }
                                        boolean seatStatus = true;
                                        while (seatStatus) {
                                            System.out.print("How many seat you want to book: ");
                                            aArray[accountNumber].seat = sc.nextInt();
                                            if (aArray[accountNumber].seat >= 1 && aArray[accountNumber].seat <= 5) {
                                                aArray[accountNumber].bill *= aArray[accountNumber].seat;
                                                seatStatus = false;
                                            } else {
                                                System.out.println(
                                                        "\n---------------------------------------------------------\n"
                                                                +
                                                                "You can book minimume 1 and miaximume 5 seat\nPlease try again...\n---------------------------------------------------------\n");
                                                continue;
                                            }
                                        }
                                        int flightN = (int) (Math.random() * 10000);
                                        aArray[accountNumber].flightNumber = "SB " + Integer.toString(flightN);
                                        System.out.println("\n1. Food Option\n2. Continue");
                                        int choice1 = sc.nextInt();
                                        if (choice1 == 1) {
                                            aArray[accountNumber].foodBill(aArray);
                                            aArray[accountNumber].displayBill(aArray);
                                            a.pay();
                                            aArray[accountNumber].ticketBook = true;
                                        } else if (choice1 == 2) {
                                            aArray[accountNumber].displayBill(aArray);
                                            a.pay();
                                            aArray[accountNumber].ticketBook = true;
                                        } else {
                                            System.out.println(
                                                    "\n---------------------------------------------------------\n" +
                                                            "Invalid choice\nPlease try again...\n---------------------------------------------------------\n");
                                        }
                                    } else {
                                        System.out.println(
                                                "\n---------------------------------------------------------\n" +
                                                        "Flight is not available\nPlease try again...\n---------------------------------------------------------\n");
                                        continue;
                                    }
                                }

                                /*-------------------------------Business-------------------------------*/
                                else if (choice2 == 2) {
                                    aArray[accountNumber].internationalB();
                                    System.out.print("Enter ID: ");
                                    int id = sc.nextInt();
                                    int flightStatus = (int) (Math.random() * 3) + 1;
                                    if (flightStatus == 1 || flightStatus == 2) {
                                        aArray[accountNumber].from = new StringBuffer("AHD");
                                        switch (id) {
                                            case 1:
                                                aArray[accountNumber].to = new StringBuffer("YTO");
                                                aArray[accountNumber].bill = 101500;
                                                break;
                                            case 2:
                                                aArray[accountNumber].to = new StringBuffer("NYC");
                                                aArray[accountNumber].bill = 200000;
                                                break;
                                            case 3:
                                                aArray[accountNumber].to = new StringBuffer("DBX");
                                                aArray[accountNumber].bill = 50400;
                                                break;
                                            default:
                                                System.out.println(
                                                        "\n---------------------------------------------------------\n"
                                                                +
                                                                "Invalid choice\nPlease try again...\n---------------------------------------------------------\n");
                                                break;
                                        }
                                        boolean validDate = false;
                                        while (!validDate) {
                                            System.out.print("Enter departure date (mm/dd/yyyy): ");
                                            String date = sc.next();
                                            if (a.isValidTicketDate(date)) {
                                                aArray[accountNumber].bookingDate = date;
                                                validDate = true;
                                            } else {
                                                System.out.println(
                                                        "\n---------------------------------------------------------\n"
                                                                +
                                                                "Invalid Date\nPlease try again...\n---------------------------------------------------------\n");
                                                continue;
                                            }
                                        }
                                        boolean seatStatus = true;
                                        while (seatStatus) {
                                            System.out.print("How many seat you want to book: ");
                                            aArray[accountNumber].seat = sc.nextInt();
                                            if (aArray[accountNumber].seat >= 1 && aArray[accountNumber].seat <= 5) {
                                                aArray[accountNumber].bill *= aArray[accountNumber].seat;
                                                seatStatus = false;
                                            } else {
                                                System.out.println(
                                                        "\n---------------------------------------------------------\n"
                                                                +
                                                                "You can book minimume 1 and miaximume 5 seat\nPlease try again...\n---------------------------------------------------------\n");
                                                continue;
                                            }
                                        }
                                        int flightN = (int) (Math.random() * 10000);
                                        aArray[accountNumber].flightNumber = "SB " + Integer.toString(flightN);

                                        System.out.println("\n1. Food Option\n2. Continue");
                                        int choice1 = sc.nextInt();
                                        if (choice1 == 1) {
                                            aArray[accountNumber].foodBill(aArray);
                                            aArray[accountNumber].displayBill(aArray);
                                            a.pay();
                                            aArray[accountNumber].ticketBook = true;
                                        } else if (choice1 == 2) {
                                            aArray[accountNumber].displayBill(aArray);
                                            a.pay();
                                            aArray[accountNumber].ticketBook = true;
                                        } else {
                                            System.out.println(
                                                    "\n---------------------------------------------------------\n" +
                                                            "Invalid choice\nPlease try again...\n---------------------------------------------------------\n");
                                        }
                                    } else {
                                        System.out.println(
                                                "\n---------------------------------------------------------\n" +
                                                        "Flight is not available\nPlease try again...\n---------------------------------------------------------\n");
                                        continue;
                                    }
                                } else {
                                    System.out.println(
                                            "\n---------------------------------------------------------\n" +
                                                    "Invalid choice\nPlease try again...\n---------------------------------------------------------\n");
                                    continue;
                                }
                            } else {
                                System.out.println(
                                        "\n---------------------------------------------------------\n" +
                                                "Invalid choice\nPlease try again...\n---------------------------------------------------------\n");
                                continue;
                            }
                        }

                        /*-------------------------------Cancel Ticket-------------------------------*/
                        else if (ch == 2) {
                            if (aArray[accountNumber].ticketBook) {
                                System.out.println(
                                        "\n-------------------------Ticket Cancellation-------------------------\n");
                                aArray[accountNumber].ticketBook = aArray[accountNumber].cancleTicket(aArray);
                            } else {
                                System.out.println("\n---------------------------------------------------------\n" +
                                        "No ticket booked\nPlease book a ticket first...\n---------------------------------------------------------\n");
                            }
                        }

                        /*-------------------------------Previous Ticket-------------------------------*/
                        else if (ch == 3) {
                            if (aArray[accountNumber].ticketBook) {
                                System.out.println(
                                        "\n-------------------------Previous Ticket-------------------------\n");
                                aArray[accountNumber].displayBill(aArray);
                            } else {
                                System.out.println("\n---------------------------------------------------------\n" +
                                        "No ticket booked\nPlease book a ticket first...\n---------------------------------------------------------\n");
                            }
                        }

                        /*-------------------------------Logout-------------------------------*/
                        else if (ch == 4) {
                            System.out.println("\n---------------------------------------------------------\n" +
                                    "Logout..\n---------------------------------------------------------\n");
                            break;
                        } else {
                            System.out.println(
                                    "\n---------------------------------------------------------\n" +
                                            "Invalid choice\nPlease try again...\n---------------------------------------------------------\n");
                        }
                    }
                } else {
                    System.out.println("\n---------------------------------------------------------\n" +
                            "Please Signup first\n---------------------------------------------------------\n");
                }
            }

            /*-------------------------------Exit-------------------------------*/
            else if (choice == 3) {
                exit = false;
                System.out.println("\n---------------------------------------------------------\n" +
                        "Exiting the program\n---------------------------------------------------------\n");
            } else {
                System.out.println("\n---------------------------------------------------------\n" +
                        "Invalid choice\nPlease try again...\n---------------------------------------------------------\n");
            }
        }
    }
}