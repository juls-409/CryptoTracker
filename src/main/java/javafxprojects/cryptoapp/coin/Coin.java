package javafxprojects.cryptoapp.coin;

import java.util.ArrayList;

public class Coin {
    private String name;
    private Double curPrice;
    public Coin(String name){
        this.name = name;
        curPrice = 0.0;
    }
    public Double getCurPrice(){
        return curPrice;
    }
    public String getName(){
        return name;
    }
    public void setCurPrice(Double price){
        this.curPrice = price;
    }
    @Override
    public String toString(){
        return name+" price: "+curPrice;
    }

    public static void main(String[] args) {
        ArrayList<Coin> coinList = new ArrayList<>();
        Coin btcCoin = new Coin("bitcoin");
        Coin dogeCoin = new Coin("dogecoin");
        Coin ethereum = new Coin("ethereum");
        coinList.add(btcCoin);
        coinList.add(dogeCoin);
        coinList.add(ethereum);
        try{
            HttpClientCoinGecko.updatePrice(btcCoin);
            HttpClientCoinGecko.updatePrice(dogeCoin);
            HttpClientCoinGecko.updatePrice(ethereum);
        } catch (Exception e){
            e.printStackTrace();
        }

        for (Coin coin: coinList){
            System.out.println(coin);
        }
    }
}
