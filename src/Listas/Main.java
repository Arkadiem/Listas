package Listas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        Scanner sc = new Scanner(System.in);
        Nodo resultadoBuscar= new Nodo();
        int Opcion = 0, Subopcion = 0;
        String ValorBuscar = "";

        while (Opcion != 8)
        {
            System.out.println("----Practica Listas-----");
            System.out.println("Que es lo que desea hacer? \n1-Inicializar / Borrar Lista \n2-Mostrar Lista \n3-Buscar Valor \n4-Insertar Palabra \n5-Eliminar Palabra \n6-Modificar Palabra \n7-Creditos \n\n8-Salir");
            Opcion = sc.nextInt();

            if(Opcion == 1 || Opcion == 2 || Opcion == 3 || Opcion == 4 || Opcion == 5 || Opcion == 6 || Opcion == 7)
            {
                switch (Opcion) {
                    case 1 -> lista.IniciarLista();
                    case 2 -> {
                        System.out.println("\nCon que orden desea mostrar la lista? \n1-Principio a Final \n2-Final a Principio");
                        Subopcion = sc.nextInt();
                        switch (Subopcion) {
                            case 1 -> lista.MostrarListaInicio();
                            case 2 -> lista.MostrarListaFinal();
                            default -> {
                                System.out.println("\nOpcion no valida, vuelva a intentarlo.");
                                System.console().readLine();
                                System.out.flush();
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("\nQue valor desea buscar?");
                        ValorBuscar = sc.next();
                        resultadoBuscar = lista.Buscar(ValorBuscar);
                        Nodo R = new Nodo();
                        R.Valor = ValorBuscar;
                        if (resultadoBuscar == null || resultadoBuscar.Valor != ValorBuscar) {
                            System.out.println("\nValor no encontrado.");
                        } else
                            System.out.println("\nBusqueda realizada con exito, se encontro el dato: {resultadoBuscar.Valor}.");
                        System.console().readLine();
                        System.out.flush();
                    }
                    case 4 -> lista.Insertar();
                    case 5 -> {
                        System.out.println("\nQue valor desea eliminar?");
                        ValorBuscar = sc.next();
                        lista.Eliminar(ValorBuscar);
                    }
                    case 6 -> {
                        System.out.println("\nQue valor desea modificar?");
                        ValorBuscar = sc.next();
                        lista.Modificar(ValorBuscar);
                    }
                    case 7 -> lista.Creditos();
                }
            }

            else if(Opcion == 8)
            {
                System.out.println("\nPrograma finalizado.");
                System.console().readLine();
            }

            else
            {
                System.out.println("\nOpcion no valida, vuelva a intentarlo.");
                System.console().readLine();
                System.out.flush();
            }
        }
    }
}
