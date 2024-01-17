package pkgProject;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DoublyLinkedList {
    Node head;
    Node tail;

    // Parametresiz constructor yazmadim
    public DoublyLinkedList(Node h, Node t) {
        head = h;
        tail = t;
    }

    /*
     * Ogrenci numarasi sirasina gore ekler
     *
     */
    public void insertInOrder(Student s) {

        // Listenin bos olup olmadigini kontrol ediyoruz
        if (head == null) {
            Node newNode = new Node(s, null, null);
            head = newNode;
            tail = newNode;

        } else {
            Node current = head;
            Node index;

            // current head'i göstericek
            for (current = head; current != null; current = current.next) {

                // current'ın data'sı index'in datasından buyukse ekliyor
                if (current.data.getStudentNumber() > s.getStudentNumber()) {
                    if (current == head) {
                        Node newStudent = new Node(s, current, null);
                        current.prev = newStudent;
                        head = newStudent;

                        break;
                    } else {
                        Node newStudent = new Node(s, current, current.prev);
                        current.prev.next = newStudent;
                        current.prev = newStudent;

                        break;
                    }

                } else {
                    if (current == tail) {
                        Node newStudent = new Node(s, null, current);
                        current.next = newStudent;
                        tail = newStudent;

                        break;
                    }

                }

            }
        }
    }

    // toString kullanılacak
    public String findByName(String target) {
        Node position = head;
        while (position != null) {
            Student dataAtPosition = position.data;
            String dataName = dataAtPosition.getNameSurname();
            if (dataName.equals(target) == true) {
                return position.data.toString();
            }
            position = position.next;
        }
        return null; // target bulunamadi
    }

    public void deleteByStudentNumber(int studentNumber) {
        Node position = head;
        int dataAtPosition;
        while (position != null) {
            dataAtPosition = position.data.getStudentNumber();
            if (dataAtPosition == studentNumber) {
                // Listenin tek bi elemandan olusup olusmadigini kontrol ediyor
                if (head != tail) {
                    if (position == head) {
                        head = position.next;
                    } else if (position == tail) {
                        position.prev.next = position.next;

                    } else {
                        position.prev.next = position.next;
                        position.next.prev = position.prev;
                    }

                } else {
                    head = tail = null;
                }
            }
            position = position.next;
        }
        return; // ogrenci bulunamadi
    }

    public void sortInAscendingOrder() {
        Node current = null;
        Node index = null;
        Student temp;
        // Listenin bos olup olmadigini kontrol ediyoruz
        if (head == null) {
            return;
        } else {
            // current head'i göstericek
            for (index = current.next; index != null; index = index.next) {
                // current'in data'si index'in datasindan buyukse degistiriyor
                if (current.data.getStudentNumber() > index.data.getStudentNumber()) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
            }
        }
    }

    public void sortInDescendingOrder() {
        Node current = null;
        Node index = null;
        Student temp;
        // Listenin bos olup olmadigini kontrol ediyoruz
        if (head == null) {
            return;
        } else {
            // current head'i göstericek
            for (current = tail; current != null; current = current.prev) {
                // current'ın data'sı index'in datasından kucukse değiştiriyor
                System.out.println("" + current.data);
            }
        }
    }

    public void display() {
        // Node current head'i gosterecek
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            // herbir node'u yazdırıyor pointer'ı arttırarak
            System.out.println(current.data + "");
            current = current.next;
        }

    }

    public static void main(String[] args) {

        int mainMenuInput = 1;
        DoublyLinkedList dll = new DoublyLinkedList(null, null);
        while (mainMenuInput != 7) {
            System.out.println(
                    "Yapmak istediginiz islemi giriniz \n1- Dosyadan okuyarak cift bagli liste olusturma \n2- Klavyeden girilen bilgilerle cift bagli liste olusturma veya olan listeye ogrenci ekleme \n3- Klavyeden adi ve soyadi girilen ogrencinin bilgileri ekrana yazdir \n4- Ogrenci numarasi girilen ogrenciyi cift bagli listeden sil \n5- Listenin icindeki tum kayitlar ogrenci numarasina gore artan sirada ekrana yazdir \n6- Listenin icindeki tum kayitlari ogrenci numarasina gore azalan sirada yazdir \n7- Programdan cik");
            Scanner mainMenu = new Scanner(System.in);
            mainMenuInput = mainMenu.nextInt();

            // Menuden 1. islem secilirse
            if (mainMenuInput == 1) {
                Scanner fileReader = null;
                try {
                    // Dosyayi acmayi deniyor
                    fileReader = new Scanner(new FileInputStream("ogrenciler.txt"));
                } catch (FileNotFoundException e) {
                    // Dosya bulunamazsa bu kod blogu calisacak ve programi sonlandiracak
                    System.out.println("File not found!");
                    System.exit(0);
                }

                String line;
                while (fileReader.hasNext()) {
                    line = fileReader.nextLine();
                    String[] values = line.split(",");
                    int valueSize = values.length;
                    int studentNumber = Integer.parseInt(values[0]);
                    String nameSurname = values[1];
                    ArrayList<String> phoneNumber = new ArrayList<>();
                    for (int i = 1; i <= (valueSize - 2); i++) {
                        String phone = values[i + 1];
                        phoneNumber.add(phone);
                    }
                    String phone = values[2];
                    phoneNumber.add(phone);
                    Student newStudent = new Student(studentNumber, nameSurname, phoneNumber);
                    dll.insertInOrder(newStudent);
                }
            }

            // Menuden 2. islem secilirse
            else if (mainMenuInput == 2) {
                Scanner keyboardReader = new Scanner(System.in);
                System.out.println("Ogrenci numarasini giriniz: ");
                int studentNumber = keyboardReader.nextInt();
                System.out.println("Ogrencinin adi ve soyadini giriniz: ");
                String nameSurname = keyboardReader.nextLine();
                System.out.println("");
                ArrayList<String> phoneNumber = new ArrayList<>();
                String morePhone = new String("h");
                do {
                    String phone = keyboardReader.nextLine();
                    phoneNumber.add(phone);
                    System.out.println("Ogrencinin eklenmesi gereken telefonu varsa e yoksa h giriniz: ");
                    morePhone = keyboardReader.nextLine();
                } while (morePhone.equalsIgnoreCase("e"));
                Student newStudent = new Student(studentNumber, nameSurname, phoneNumber);
                dll.insertInOrder(newStudent);
            }

            // Menuden 3. islem secilirse
            else if (mainMenuInput == 3) {
                Scanner keyboardReader = new Scanner(System.in);
                System.out.println("Listeden bulunmasini istediginiz ogrencinin adini soyadini giriniz: ");
                String nameSurname = keyboardReader.nextLine();
                String studentInfo = dll.findByName(nameSurname);
                if (studentInfo == null) {
                    System.out.println("Ogrenci listede bulunamadi!");
                } else {
                    System.out.println(studentInfo);
                }
            }

            // Menuden 4. islem secilirse
            else if (mainMenuInput == 4) {
                Scanner keyboardReader = new Scanner(System.in);
                System.out.println("Listeden silinmesini istediginiz ogrencinin ogrenci numarasini giriniz: ");
                int studentNumber = keyboardReader.nextInt();
                dll.deleteByStudentNumber(studentNumber);
            }

            // Menuden 5. islem secilirse
            else if (mainMenuInput == 5) {

                dll.display();
            }

            // Menuden 6. islem secilirse
            else if (mainMenuInput == 6) {
                dll.sortInDescendingOrder();

            }

            // Menuden 7. islem veya yanlis bir input girilirse
            else {
                System.out.println("Programdan cikiliyor");
                System.exit(0);
            }
        }

    }

}
