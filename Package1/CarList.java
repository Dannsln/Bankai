package Package1;

import java.util.Scanner;

public class CarList {

    private Node first;
    Node last;

    public CarList(){
        first = null;
    }

    //CarList x = new CarList();

    public Car readData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa marca: "); String brand = sc.nextLine();
        System.out.println("Ingresa modelo :"); String model = sc.nextLine();
        System.out.println("Ingresa VIN(número de serie): "); String VIN = sc.nextLine().trim();
        System.out.println("Ingresa año de lanzamiento: "); int year = sc.nextInt();
        System.out.println("Ingresa precio: "); double price = sc.nextDouble(); sc.nextLine();
        boolean available; available = false; boolean entry = false;

        while (!entry) {
            System.out.println("Ingresa disponibilidad: \nS=Disponible N=No Disponible"); 
            String answer = sc.nextLine().trim().toLowerCase();
            if (answer.contains("s")) {
                available = true;entry = true; break;
            } else if(answer.contains("n")){
                entry = true; break;
            } else {
                System.out.println("Escribe una entrada válida");
            }
        }
        return new Car(brand, model, VIN, year, price, available);

    }


    public CarList createList(){
        first = null;
        first = new Node(readData(), first);
        last = first;
        return this;
    }

    /*System.out.println(c.brand + " " + c.model + " | Año: " + c.year + " | Precio: $" + c.price + 
    " | Disponible: " + (c.available ? "Sí" : "No"));*/

    public void viewLinkedList(){
        Node current;
        int k = 0;
        current = first;

        while (current!=null) {
           Car c = current.data;
           System.out.println(c.brand + " " + c.model + " | VIN: "+c.VIN +" | Año: " + c.year + " | Precio: $" + c.price +
           " | Disponible: " + (c.available ? "Sí" : "No"));
           current = current.link;
           k++;
        }
        System.out.println("\nNúmero de elementos: "+k);
        
    }

    public CarList insertByBegin(){

       String answer;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Desea agregar un nuevo nodo¿?(S/N)\nS=Sí N=No: ");
            answer = sc.nextLine().trim().toLowerCase();
            if (answer.contains("s")) {
            Node neew = new Node(readData(), first);
            neew.link = first;
            first = neew;
        } 
          
        } while (answer.contains("s"));
        return this;  
    }


    public CarList insertAtTheEnd(){

        String answer;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Desea agregar un nuevo nodo¿?(S/N)\nS=Sí N=No: ");
            answer = sc.nextLine().trim().toLowerCase();
            if (answer.contains("s")) {
            Node neew = new Node(readData());
            last.link = neew;
            last = neew;
        } 
          
        } while (answer.contains("s"));
        return this;  
    }

    public Node searchNode(String Target){

        Node n, find = null; n = first;

        while ((n!=null)) {

            if((n.data.VIN !=null) && (n.data.VIN.equals(Target))){
                find = n;
               System.out.println("Nodo encontrado: ");
                System.out.println(n.data.brand + " " + n.data.model + " | VIN: "+n.data.VIN +" | Año: " + n.data.year + " | Precio: $" + n.data.price +
           " | Disponible: " + (n.data.available ? "Sí" : "No"));
           return find;
    
            }
            n=n.link;
        }
        System.out.println("No hay nodos con tal valor");
        return null;
    }



    public CarList insertInList(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa Nodo Objetivo(Clave Vin)");String target = sc.nextLine();

        Node found = searchNode(target);

        if (found!=null) {
            System.out.println("Nodo encontrado:\n");
            System.out.println(found.data.brand + found.data.model+ " | VIN: "+found.data.VIN+" | Año: "+found.data.year+" | Precio: $" +found.data.price);
            System.out.println();
            System.out.println("Ingresar Nodo Antes o Después(A/B)\nA= Antes B= Después");
            String answer = sc.nextLine().trim().toLowerCase();
            if (answer.contains("a")) {
                Car newDataOfCar = readData();
                Node newNode = new Node(newDataOfCar);
                
                if (found==first) {
                    newNode.link = first;
                    first = newNode;
                    
                } else{
                    Node previous = first;
                    while (previous.link!=found) {
                        previous = previous.link;
                    }
                    newNode.link = found;
                    previous.link = newNode;
                }
            } else if (answer.contains("b")) {
                Car newCar = readData();
                Node newNode = new Node(newCar, found.link);
                found.link = newNode;
                if (found==last) {
                    last = newNode;
                }
            }  }
        return this;}
/* 
        while (n!=null) {
            if((n.data.VIN!=null)&&(n.data.VIN.equals(target))){
                find = n;
                ishere = true;
                if (ishere) {
                    System.out.println("Nodo encontrado");
            System.out.println(n.data.brand + " " + n.data.model + " | VIN: "+n.data.VIN +" | Año: " + n.data.year + " | Precio: $" + n.data.price +
            " | Disponible: " + (n.data.available ? "Sí" : "No"));
                } else{
                    System.out.println("Aquel nodo no está en esta lista");
                }
            }
            n = n.link;
            n.link = current;
        }
        
        if (ishere) {
            System.out.println("Ingresar Nodo Antes o Después(A/B)\nA= Antes B= Después");
            String answer = sc.nextLine().trim().toLowerCase();
            if (answer.contains("a")) {
                CarList z = new CarList();
                x.insertAtTheEnd();
            } else if (answer.contains("b")) {
                x.insertAtTheEnd();
            }
            
        }
        return this;
    }*/


    public void Menu(){
        Scanner sc = new Scanner(System.in);
        char answer;
        System.out.println("Ingresa el Nodo Inicial(Nodo raíz)\n");
        createList();
        System.out.println("Actualmente tienes un nodo inicial, es el siguiente: \n");
        viewLinkedList();

        do {
            
           
            System.out.println("---------------Despliegue de Menú--------------");
            System.out.println("Selecciona una opción");
            System.out.println("1.Insertar por Inicio\n2.Insertar por Final\n3.Insertar en Lista\n4.Buscar un Nodo específico\n5.Ver Lista\n6.Salir");


            answer = sc.next().charAt(0);
        sc.nextLine();
        switch (answer) {
            case '1':
            insertByBegin();viewLinkedList();
                break;
            case '2':
            insertAtTheEnd();viewLinkedList();
            break;
            case '3':
            insertInList(); viewLinkedList();
            break;
            case '4':
            System.out.println("Escribe valor del VIN");
            String Target = sc.nextLine().trim();
            searchNode(Target);
            break;
            case '5':
            System.out.println("Lista actua: ");
            viewLinkedList();
            break;
            case '6': 
            System.out.println("Terminando ejecución del programa");
            break;
            default:
            System.out.println("Ingresa valor válido");
                break;
        }
    
        } while (answer!='6');
        sc.close();
    
    }
    
    }


