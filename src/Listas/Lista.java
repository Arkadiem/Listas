package Listas;

import java.util.Objects;
import java.util.Scanner;

public class Lista {
    Scanner sc = new Scanner(System.in);
    Nodo P = new Nodo();
    Nodo F = new Nodo();
    public Lista()
    {
        P = null;
        F = null;
    }

    public void IniciarLista()
    {
        while(P != null && F != null)
        {
            new Nodo();
            Nodo T;
            Nodo R;
            if (P == F) P = F = null;

            else
            {
                T = F;
                R = T.Ant;
                T.Ant = null;
                R.Sig = null;
                F = R;
            }
        }

        System.out.println("\nLista vaciada / inicializada.");
    }

    public void MostrarListaInicio()
    {
        if (P == null && F == null){
            System.out.println("\nLa lista esta vacia.");
        }

        else
        {
            int i = 1;

            if (P == F)
            {
                System.out.println("\nLista de Valores:");
                System.out.println("Posicion "+i+" : "+P.Valor);
            }

            else
            {
                Nodo Q = new Nodo();
                Q = P;

                System.out.println("\nLista de Valores:");
                while (Q != null)
                {
                    System.out.println("Posicion "+i+" : "+Q.Valor);
                    Q = Q.Sig;
                    i++;
                }
            }
        }
    }

    public void MostrarListaFinal()
    {
        if (P == null && F == null) System.out.println("\nLa lista esta vacia.");

        else
        {
            int i = 1;

            if (F == P)
            {
                System.out.println("\nLista de Valores:");
                System.out.println("Posicion "+i+" : "+F.Valor);
            }

            else
            {
                Nodo Q = new Nodo();
                Q = F;

                System.out.println("\nLista de Valores:");
                while (Q != null)
                {
                    System.out.println("Posicion "+i+" : "+Q.Valor);
                    Q = Q.Ant;
                    i++;
                }
            }
        }
    }

    public Nodo Buscar(String ValorBuscar)
    {
        Nodo A = new Nodo();

        if (P == null)
        {
            A = null;
            return A;
        }

        else if(P == F && Objects.equals(P.Valor, ValorBuscar))
        {
            return P;
        }

        else
        {
            Nodo T = new Nodo();
            T = P;
            int ValorComparacion = 0;

            while (ValorComparacion != 0 || T.Sig != null)
            {
                ValorComparacion = ValorBuscar.compareTo(T.Valor);

                if (ValorComparacion == 0 && T == F)
                {
                    return F;
                }

                else if (ValorComparacion == 0)
                {
                    A = T;
                    return A;
                }

                else if (T.Sig == null)
                {
                    A = null;
                    return A;
                }

                else
                {
                    T = T.Sig;
                }
            }
            return A;
        }

    }

    public void Insertar()
    {
        Nodo Q = new Nodo();

        System.out.println("\nIngrese un el valor que desea guardar:");
        Q.Valor = sc.nextLine();

        if(P == null && F == null)
        {
            P = Q;
            F = Q;

            System.out.println("\nValor guardardo con exito.");
        }

        else if (P == F)
        {
            int ValorComparacion = Q.Valor.compareTo(P.Valor);

            if(ValorComparacion < 0)
            {
                Nodo T;
                T = P;

                Q.Sig = T;
                T.Ant = Q;
                P = Q;
            }

            else {
                Nodo T = new Nodo();
                T = F;

                Q.Ant = T;
                T.Sig = Q;
                F = Q;
            }

            System.out.println("\nValor guardardo con exito.");
        }

        else
        {
            Nodo T = new Nodo();
            T = P;

            while (T != null)
            {
                int ValorComparacion = Q.Valor.compareTo(T.Valor);

                if (T == P && ValorComparacion <= 0)
                {
                    Nodo N = new Nodo();
                    N = P;

                    Q.Sig = N;
                    N.Ant = Q;
                    P = Q;

                    System.out.println("\nValor guardardo con exito.");
                    break;
                }

                else if (T == F && ValorComparacion >= 0)
                {
                    Nodo N = new Nodo();
                    N = F;

                    Q.Ant = N;
                    N.Sig = Q;
                    F = Q;

                    System.out.println("\nValor guardardo con exito.");
                    break;
                }

                else if (ValorComparacion <= 0)
                {
                    Q.Sig = T;
                    Q.Ant = T.Ant;
                    T.Ant.Sig= Q;
                    T.Ant = Q;

                    System.out.println("\nValor guardardo con exito.");
                    break;
                }

                else
                {
                    T = T.Sig;
                }
            }
        }
    }

    public void Eliminar(String ValorBuscar)
    {
        Nodo T = new Nodo();
        T = Buscar(ValorBuscar);

        if(T == null)
        {
            System.out.println("\nValor no encontrado.");
        }

        else
        {
            if(P == F) P = F = null;

            else if (T == P)
            {
                Nodo H = new Nodo();

                H = P.Sig;
                P.Ant = null;
                H.Ant = null;
                P = H;
            }

            else if(T == F)
            {
                Nodo H = new Nodo();

                H = F.Ant;
                F.Sig = null;
                H.Sig = null;
                F = H;
            }

            else
            {
                T.Ant.Sig = T.Sig;
                T.Sig.Ant = T.Ant;
                T.Sig = T.Ant = null;
            }

            System.out.println("\nValor eliminado correctamente.");
        }
    }

    public void Modificar(String ValorBuscar)
    {
        Nodo R = new Nodo();
        R = Buscar(ValorBuscar);

        if (R == null)
        {
            System.out.println("\nValor no encontrado");
        }

        else
        {
            System.out.println("\nIngresa el nuevo valor de: "+R.Valor);
            String Remplazo = sc.nextLine();

            if (P == F)
            {
                P.Valor = Remplazo;

                System.out.println("\nValor modificado con exito.");
            }

            else if (P.Sig == F && Objects.equals(F.Valor, ValorBuscar))
            {
                F.Valor = Remplazo;

                System.out.println("\nValor modificado con exito.");
            }

            else if (F.Ant == P && Objects.equals(P.Valor, ValorBuscar))
            {
                P.Valor = Remplazo;

                System.out.println("\nValor modificado con exito.");
            }

            else
            {
                Nodo Rem = new Nodo();
                Rem = R;

                (Rem.Sig).Ant = Rem.Ant;
                (Rem.Ant).Sig = Rem.Sig;
                Rem.Ant = Rem.Sig = null;
                Rem.Valor = Remplazo;

                Nodo T = new Nodo();
                T = P;

                while (T != null)
                {
                    int ValorComparacion = Rem.Valor.compareTo(T.Valor);

                    if (T == P && ValorComparacion <= 0)
                    {
                        Nodo N = new Nodo();
                        N = P;

                        Rem.Sig = N;
                        N.Ant = Rem;
                        P = Rem;

                        System.out.println("\nValor modificado con exito.");
                        break;
                    }

                    else if (T == F && ValorComparacion >= 0)
                    {
                        Nodo N = new Nodo();
                        N = F;

                        Rem.Ant = N;
                        N.Sig = Rem;
                        F = Rem;

                        System.out.println("\nValor modificado con exito.");
                        break;
                    }

                    else if (ValorComparacion <= 0)
                    {
                        Rem.Sig = T;
                        Rem.Ant = T.Ant;
                        T.Ant.Sig = Rem;
                        T.Ant = Rem;

                        System.out.println("\nValor Modificado con exito.");
                        break;
                    }

                    else
                    {
                        T = T.Sig;
                    }
                }
            }
        }
    }

    public void Creditos()
    {
        System.out.println("\nMateria: Estructura de Datos Aplicados \nIntegrantes del Equipo: \nJason Urbina Sotelo \nGael \nNava");
    }
}
