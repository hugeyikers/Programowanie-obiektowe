import java.util.HashMap;
import java.util.Map;

public class KoszykZakupowy {
    HashMap<Produkt, Integer> lista;

    public KoszykZakupowy(HashMap<Produkt, Integer> lista)
    {
        this.lista=lista;
    }

    public void dodajProdukt(Produkt produkt, int ilosc)
    {
        if(produkt.iloscNaMagazynie>=ilosc)
        {
            lista.put(produkt,ilosc);
            produkt.iloscNaMagazynie-=ilosc;
        }
        else
        {
            System.out.println("Za mała ilość na magazynie");
        }
    }

    public void usunProdukt(Produkt produkt, int ilosc)
    {
        for(Map.Entry<Produkt, Integer> produkty : lista.entrySet())
        {
            if(produkt.nazwa==produkty.getKey().nazwa)
            {
                int nowailosc = produkty.getValue()-ilosc;
                lista.put(produkty.getKey(),nowailosc);
            }
        }
    }

    public void wyswietlZawartoscKoszyka()
    {
        lista.forEach((klucz,wartosc) -> System.out.println(klucz.nazwa+" "+wartosc));
    }

    public int obliczCalkowitaWartosc()
    {
        int cena =0;
        for(Map.Entry<Produkt, Integer> produkt : lista.entrySet())
        {
            cena+= produkt.getKey().cena * produkt.getValue();
        }
        return cena;
    }
}
